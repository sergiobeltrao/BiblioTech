package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;
import com.mycompany.bibliotech.model.bean.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ImagemDAO {

    public void alterarImagem(Livro imagem) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE LIVRO SET LIV_IMAGEM = ? WHERE ID_LIVRO = ?";
            stmt = con.prepareStatement(sql);
            stmt.setBytes(1, imagem.getImagem());
            stmt.setInt(2, imagem.getId());
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no update: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public byte[] buscarImagemPorId(int livroId) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        byte[] imagemBytes = null;

        try {
            String sql = "SELECT LIV_IMAGEM FROM LIVRO WHERE ID_LIVRO = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, livroId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                imagemBytes = rs.getBytes("LIV_IMAGEM");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na busca: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return imagemBytes;
    }

    public void excluirImagem(int livroId) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE LIVRO SET LIV_IMAGEM = NULL WHERE ID_LIVRO = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, livroId);
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
