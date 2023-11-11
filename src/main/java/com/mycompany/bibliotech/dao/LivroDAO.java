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
            stmt = con.prepareStatement("INSERT INTO LIVRO (ID_LIVRO, LIV_NOME_LIVRO, LIV_ISBN, LIV_ANO, LIV_PAGINA, LIV_QUANTIDADE, LIV_CATEGORIA, LIV_SUBCATEGORIA, LIV_PRECO, LIV_IDIOMA, LIV_EDITORA, LIV_SINOPSE) VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, lv.getTitulo());
            stmt.setString(2, lv.getIsbn());
            stmt.setInt(3, lv.getAnoDePublicacao());
            stmt.setInt(4, lv.getNumeroDePaginas());
            stmt.setInt(5, lv.getQuantidadeLivro());
            stmt.setString(6, lv.getCategoria());
            stmt.setString(7, lv.getSubCategoria());
            stmt.setDouble(8, lv.getPreco());
            stmt.setString(9, lv.getIdioma());
            stmt.setString(10, lv.getEditora());
            stmt.setString(11, lv.getSinopse());

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
            comboBox.addItem("Não Informado");

            while (resultado.next()) {
                comboBox.addItem(resultado.getString("IDI_NOME"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela de idiomas: " + ex);
        }
    }

    // Para o retorno dos dados do banco na gtable
    public List<Livro> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Livro> livros = new ArrayList<>();

        try {
            stmt = con.prepareCall("SELECT ID_LIVRO, LIV_NOME_LIVRO, LIV_ISBN, LIV_ANO, LIV_PAGINA, LIV_CATEGORIA, LIV_SUBCATEGORIA, LIV_IDIOMA, LIV_EDITORA FROM LIVRO");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Livro livro = new Livro();

                livro.setId(rs.getInt("ID_LIVRO"));
                livro.setTitulo(rs.getString("LIV_NOME_LIVRO"));
                livro.setIsbn(rs.getString("LIV_ISBN"));
                livro.setAnoDePublicacao(rs.getInt("LIV_ANO"));
                livro.setNumeroDePaginas(rs.getInt("LIV_PAGINA"));
                livro.setCategoria(rs.getString("LIV_CATEGORIA"));
                livro.setSubCategoria(rs.getString("LIV_SUBCATEGORIA"));
                livro.setIdioma(rs.getString("LIV_IDIOMA"));
                livro.setEditora(rs.getString("LIV_EDITORA"));

                livros.add(livro);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return livros;
    }

}
