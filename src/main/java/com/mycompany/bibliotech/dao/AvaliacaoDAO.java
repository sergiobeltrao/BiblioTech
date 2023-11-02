package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;
import com.mycompany.bibliotech.model.bean.Avaliacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AvaliacaoDAO {

    public void create(Avaliacao av) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("INSERT INTO AVALIACOES (ID, AVA_USUARIO, AVA_TOTAL, AVA_COMENTARIO, AVA_DATA_AVALIACAO) VALUES(NULL, ?, '9.0', 'ISSO SERÁ IMPLEMENTADO', NOW())");

            stmt.setString(1, av.getAvaliacaoDoUsuario());

            // Para preparar o SQL e executar
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro nos dados da avaliação: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
