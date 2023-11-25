package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;
import com.mycompany.bibliotech.model.bean.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LivroAutorDAO {

    public String buscaIdDoLivro(Livro livro) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String idDoLivro = null;

        try {
            stmt = con.prepareStatement("SELECT ID_LIVRO FROM LIVRO WHERE LIV_NOME_LIVRO = ? AND LIV_ISBN = ? AND LIV_ANO = ? AND LIV_PAGINA = ? AND LIV_CATEGORIA = ? AND LIV_SUBCATEGORIA = ? AND LIV_IDIOMA = ? AND LIV_EDITORA = ? AND LIV_SINOPSE = ?");

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getIsbn());
            stmt.setInt(3, livro.getAnoDePublicacao());
            stmt.setInt(4, livro.getNumeroDePaginas());
            stmt.setString(5, livro.getCategoria());
            stmt.setString(6, livro.getSubCategoria());
            stmt.setString(7, livro.getIdioma());
            stmt.setString(8, livro.getEditora());
            stmt.setString(9, livro.getSinopse());

            rs = stmt.executeQuery();

            if (rs.next()) {
                idDoLivro = rs.getString("ID_LIVRO");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar o ID do livro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return idDoLivro;
    }

    public String buscaIdDoAutor(String autorNome, String autorNacionalidade) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String idDoAutor = null;

        try {
            stmt = con.prepareStatement("SELECT ID_AUTOR FROM AUTOR WHERE AUT_NOME_AUTOR = ? AND AUT_NACIONALIDADE LIKE ?");

            stmt.setString(1, autorNome);
            stmt.setString(2, autorNacionalidade + "%");

            rs = stmt.executeQuery();

            if (rs.next()) {
                idDoAutor = rs.getString("ID_AUTOR");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar o ID do autor: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return idDoAutor;
    }

    public void preencheTabelaLivroAutor(String idDoLivro, String idDoAutor) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO LIVRO_AUTOR(LIVRO_CHAVE, LIVRO_AUTOR) VALUES(?, ?)");

            stmt.setString(1, idDoLivro);
            stmt.setString(2, idDoAutor);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no cadastro dos IDs na tabela LIVRO_AUTOR: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
