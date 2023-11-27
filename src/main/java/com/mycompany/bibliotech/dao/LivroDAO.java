package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;
import com.mycompany.bibliotech.model.bean.Autor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.mycompany.bibliotech.model.bean.Livro;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class LivroDAO {
    
    public void create(Livro lv) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO LIVRO (ID_LIVRO, LIV_NOME_LIVRO, LIV_ISBN, LIV_ANO, LIV_PAGINA, LIV_CATEGORIA, LIV_SUBCATEGORIA, LIV_IDIOMA, LIV_EDITORA, LIV_SINOPSE) VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            stmt.setString(1, lv.getTitulo());
            stmt.setString(2, lv.getIsbn());
            stmt.setInt(3, lv.getAnoDePublicacao());
            stmt.setInt(4, lv.getNumeroDePaginas());
            stmt.setString(5, lv.getCategoria());
            stmt.setString(6, lv.getSubCategoria());
            stmt.setString(7, lv.getIdioma());
            stmt.setString(8, lv.getEditora());
            stmt.setString(9, lv.getSinopse());

            // Para preparar o SQL e executar
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro nos dados do livro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public static void listaDeIdiomas(JComboBox<String> comboBox) {
        try {
            Connection con = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM IDIOMA";
            PreparedStatement comando = con.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            
            comboBox.removeAllItems();
            comboBox.addItem("Selecione");
            
            while (resultado.next()) {
                comboBox.addItem(resultado.getString("IDI_NOME"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela de idiomas: " + ex);
        }
    }

    // Para o retorno dos dados do banco na jTable
    public List<Livro> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Livro> livros = new ArrayList<>();
        
        try {
            stmt = con.prepareCall("SELECT L.LIV_NOME_LIVRO, A.AUT_NOME_AUTOR, L.LIV_ISBN, L.LIV_ANO, L.LIV_PAGINA, L.LIV_CATEGORIA, L.LIV_SUBCATEGORIA, L.LIV_IDIOMA, L.LIV_EDITORA FROM LIVRO L INNER JOIN AUTOR A ON L.ID_LIVRO = A.ID_AUTOR;");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Livro livro = new Livro();
                Autor autor = new Autor();
                
                livro.setTitulo(rs.getString("LIV_NOME_LIVRO"));
                autor.setNome(rs.getString("AUT_NOME_AUTOR"));
                livro.setIsbn(rs.getString("LIV_ISBN"));
                livro.setAnoDePublicacao(rs.getInt("LIV_ANO"));
                livro.setNumeroDePaginas(rs.getInt("LIV_PAGINA"));
                livro.setCategoria(rs.getString("LIV_CATEGORIA"));
                livro.setSubCategoria(rs.getString("LIV_SUBCATEGORIA"));
                livro.setIdioma(rs.getString("LIV_IDIOMA"));
                livro.setEditora(rs.getString("LIV_EDITORA"));
                
                livro.setAutor(autor);
                livros.add(livro);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela: " + ex);
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return livros;
    }
    
    public String verificaDuplicidadeIsbn(String isbn) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String resultado = null;
        
        try {
            stmt = con.prepareStatement("SELECT LIV_ISBN FROM LIVRO WHERE LIV_ISBN = ?");
            stmt.setString(1, isbn);
            
            rs = stmt.executeQuery();

            // Se houver um resultado, pegue o ISBN retornado
            if (rs.next()) {
                resultado = rs.getString("LIV_ISBN");
            } else {
                // Para evitar um NullPointerException caso o select não retorne nada.
                resultado = "";
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na consulta: " + ex);
        } finally {
            // Feche as conexões e objetos ResultSet
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return resultado;
    }
}
