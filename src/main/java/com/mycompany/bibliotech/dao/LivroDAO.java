package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;
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
            stmt = con.prepareCall("SELECT LIV_NOME_LIVRO, LIV_ISBN, LIV_ANO, LIV_PAGINA, LIV_CATEGORIA, LIV_SUBCATEGORIA, LIV_IDIOMA, LIV_EDITORA FROM LIVRO");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Livro livro = new Livro();

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

    public static void selectPesquisaLivroTitulo(JComboBox<String> comboBox, String busca) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT CONCAT('ID ', ID_LIVRO, ' - ', LIV_NOME_LIVRO) AS ID_E_NOME_LIVRO FROM LIVRO WHERE LIV_NOME_LIVRO LIKE ?");

            stmt.setString(1, "%" + busca + "%");

            ResultSet resultado = stmt.executeQuery();

            comboBox.removeAllItems();
            boolean encontrouResultado = false;

            while (resultado.next()) {
                encontrouResultado = true;
                String nomePesquisado = resultado.getString("ID_E_NOME_LIVRO");
                comboBox.addItem(nomePesquisado);
            }

            if (!encontrouResultado) {
                comboBox.addItem("Nada encontrado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela de livros: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public static void selectGeralLivroTitulo(JComboBox<String> comboBox) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT CONCAT('ID ', ID_LIVRO, ' - ', LIV_NOME_LIVRO) AS ID_E_NOME_LIVRO FROM LIVRO");

            ResultSet resultado = stmt.executeQuery();

            comboBox.removeAllItems();
            boolean encontrouResultado = false;

            while (resultado.next()) {
                encontrouResultado = true;
                String nomePesquisado = resultado.getString("ID_E_NOME_LIVRO");
                comboBox.addItem(nomePesquisado);
            }

            if (!encontrouResultado) {
                comboBox.addItem("Nada encontrado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela de livros: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public String selectIdDoLivro(String busca) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String resultado = null;

        try {
            stmt = con.prepareStatement("SELECT ID_LIVRO FROM LIVRO WHERE LIV_NOME_LIVRO LIKE ?");
            stmt.setString(1, "%" + busca + "%");

            rs = stmt.executeQuery();

            if (rs.next()) {
                resultado = rs.getString("ID_LIVRO");
            } else {
                // Para evitar um NullPointerException caso o select não retorne nada.
                resultado = "";
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na consulta: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return resultado;
    }

    public Livro selectGeralComId(int idLivro) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Livro livro = new Livro();

        try {
            stmt = con.prepareStatement("SELECT LIV_NOME_LIVRO, LIV_ISBN, LIV_ANO, LIV_PAGINA, LIV_CATEGORIA, LIV_SUBCATEGORIA, LIV_IDIOMA, LIV_EDITORA, LIV_SINOPSE FROM LIVRO WHERE ID_LIVRO = ?");
            stmt.setInt(1, idLivro);

            rs = stmt.executeQuery();

            if (rs.next()) {
                livro.setTitulo(rs.getString("LIV_NOME_LIVRO"));
                livro.setIsbn(rs.getString("LIV_ISBN"));
                livro.setAnoDePublicacao(rs.getInt("LIV_ANO"));
                livro.setNumeroDePaginas(rs.getInt("LIV_PAGINA"));
                livro.setCategoria(rs.getString("LIV_CATEGORIA"));
                livro.setSubCategoria(rs.getString("LIV_SUBCATEGORIA"));
                livro.setIdioma(rs.getString("LIV_IDIOMA"));
                livro.setEditora(rs.getString("LIV_EDITORA"));
                livro.setSinopse(rs.getString("LIV_SINOPSE"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na consulta: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return livro;
    }

    public boolean atualizaInfoLivro(int idLivro, Livro livro) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "UPDATE LIVRO SET LIV_NOME_LIVRO = ?, LIV_ISBN = ?, LIV_ANO = ?, LIV_PAGINA = ?, LIV_CATEGORIA = ?, LIV_SUBCATEGORIA = ?, LIV_IDIOMA = ?, LIV_EDITORA = ?, LIV_SINOPSE = ? WHERE ID_LIVRO = ?";

            stmt = con.prepareStatement(sql);

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getIsbn());
            stmt.setInt(3, livro.getAnoDePublicacao());
            stmt.setInt(4, livro.getNumeroDePaginas());
            stmt.setString(5, livro.getCategoria());
            stmt.setString(6, livro.getSubCategoria());
            stmt.setString(7, livro.getIdioma());
            stmt.setString(8, livro.getEditora());
            stmt.setString(9, livro.getSinopse());
            stmt.setInt(10, idLivro);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Retorna true se a atualização for bem-sucedida

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no update: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }

}
