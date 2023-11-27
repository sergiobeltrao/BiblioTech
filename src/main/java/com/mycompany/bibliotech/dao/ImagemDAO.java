package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImagemDAO {

    public byte[] selecionarImagem(int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        byte[] imagem = null;

        try {
            // Consulta SQL para selecionar a imagem com base no ID
            String sql = "SELECT LIV_IMAGEM FROM LIVRO WHERE id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            // Verificar se há resultados
            if (rs.next()) {
                // Obter a imagem como array de bytes
                imagem = rs.getBytes("LIV_IMAGEM");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }

        return imagem;
    }
}
