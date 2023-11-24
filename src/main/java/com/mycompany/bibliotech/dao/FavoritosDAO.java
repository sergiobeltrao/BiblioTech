package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;
import com.mycompany.bibliotech.model.bean.Favoritos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class FavoritosDAO {
    
    public void favCreate(Favoritos fav, String userNome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            // Pega o usuário que está favoritando
            String consultaSQL = "SELECT USE_ID FROM USUARIO WHERE USE_NICK = ?";
            stmt = con.prepareStatement(consultaSQL);
            stmt.setString(1, userNome);
            ResultSet resultado = stmt.executeQuery();
            int userId = 0;

            // Verifica se há resultados
            if (resultado.next()) {
                userId = resultado.getInt("USE_ID");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao consultar USE_ID para tabela de favorito");
                return;  // Encerre o método se não encontrar o usuário
            }
           
            // Faz o insert na tabela FAVORITO
            stmt = con.prepareStatement("INSERT INTO FAVORITO (ID, FAV_CATEGORIA1, FAV_SUB1, FAV_CATEGORIA2, FAV_SUB2, FAV_USUARIO) VALUES(NULL, ?, ?, ?, ?, ?)");

            stmt.setString(1, fav.getFavCategoria1());
            stmt.setString(2, fav.getFavSub1());
            stmt.setString(3, fav.getFavCategoria2());
            stmt.setString(4, fav.getFavSub2());
            stmt.setInt(5, userId);

            // Para preparar o SQL e executar
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro nos dados do favorito: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void atualizar(Favoritos fav, String userIdEmEdicao) {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;

    try {
        if (con == null) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.");
            return;
        }

        con.setAutoCommit(false);  // Desativa o autocommit

        String consultaSQL = "SELECT USE_ID FROM USUARIO WHERE USE_NICK = ?";
            stmt = con.prepareStatement(consultaSQL);
            stmt.setString(1, userIdEmEdicao);
            ResultSet resultado = stmt.executeQuery();
            int userId = 0;

            // Verifica se há resultados
            if (resultado.next()) {
                userId = resultado.getInt("USE_ID");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao consultar USE_ID para tabela de favorito");
                return;  // Encerre o método se não encontrar o usuário
            }
        
        String consultSQL = "SELECT ID FROM FAVORITO WHERE FAV_USUARIO = ?";
            stmt = con.prepareStatement(consultSQL);
            stmt.setInt(1, userId);
            ResultSet resultad = stmt.executeQuery();
            int favId = 0;

            // Verifica se há resultados
            if (resultad.next()) {
                favId = resultad.getInt("FAV_USUARIO");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao consultar USE_ID para tabela de usuario");
                return;  // Encerre o método se não encontrar o usuário
            }
        
        // Prepare SQL statement
        stmt = con.prepareStatement("UPDATE FAVORITO SET FAV_CATEGORIA1=?, FAV_SUB1=?, FAV_CATEGORIA2=?, FAV_SUB2=? WHERE ID=?");

        // Set values for SQL statement
        stmt.setString(1, fav.getFavCategoria1());
        stmt.setString(2, fav.getFavSub1());
        stmt.setString(3, fav.getFavCategoria2());
        stmt.setString(4, fav.getFavSub2());
        stmt.setInt(5, favId);

        int affectedRows = stmt.executeUpdate();

        if (affectedRows > 0) {
            con.commit();
            JOptionPane.showMessageDialog(null, "Favorito atualizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum favorito atualizado. Verifique os dados informados.");
        }
    } catch (SQLException ex) {
        try {
            con.rollback();  // Desfaz a transação em caso de exceção
        } catch (SQLException rollbackEx) {
            rollbackEx.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Erro ao atualizar favorito: " + ex.getMessage());
        ex.printStackTrace();
    } finally {
        try {
            con.setAutoCommit(true);  // Reativa o autocommit no final, para evitar efeitos colaterais
        } catch (SQLException autoCommitEx) {
            autoCommitEx.printStackTrace();
        }
        ConnectionFactory.closeConnection(con, stmt);
    }
}

}
