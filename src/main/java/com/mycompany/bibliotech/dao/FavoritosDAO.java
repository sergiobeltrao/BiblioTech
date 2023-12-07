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
            stmt = con.prepareStatement("INSERT INTO FAVORITO (FAV_CATEGORIA1, FAV_SUB1, FAV_CATEGORIA2, FAV_SUB2, FAV_ID_USUARIO) VALUES(?, ?, ?, ?, ?)");

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
    
    public void atualizar(Favoritos fav, String userId) {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;

    try {
        if (con == null) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.");
            return;
        }

        con.setAutoCommit(false);  // Desativa o autocommit
        
         // Verificar se o endereço existe para o usuário
        int enderecoExistenteId = obterIdFavUsuario(userId);

        if (enderecoExistenteId == 0) {
            // Se o endereço não existe, chama o método cadastrarEndereco para criar um novo endereço
            
            favCreate(fav, obterNickPorId(userId));
            // Obtém o ID do endereço recém-criado
            enderecoExistenteId = obterIdFavUsuario(userId);
        }
        // Prepare SQL statement
        stmt = con.prepareStatement("UPDATE FAVORITO SET FAV_CATEGORIA1=?, FAV_SUB1=?, FAV_CATEGORIA2=?, FAV_SUB2=? WHERE FAV_ID_USUARIO=?");

        // Set values for SQL statement
        stmt.setString(1, fav.getFavCategoria1());
        stmt.setString(2, fav.getFavSub1());
        stmt.setString(3, fav.getFavCategoria2());
        stmt.setString(4, fav.getFavSub2());
        stmt.setInt(5, Integer.parseInt(userId));
        //stmt.setInt(6, favId);

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

private int obterIdFavUsuario(String userId) {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    ResultSet result = null;

    try {
        if (con == null) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.");
            return 0;
        }

        String consultaEnderecoExistenteSQL = "SELECT F.FAV_ID_USUARIO\n" +
"FROM USUARIO U\n" +
"LEFT JOIN FAVORITO F ON U.USE_ID = F.FAV_ID_USUARIO\n" +
"WHERE U.USE_ID = ?;";
        
        stmt = con.prepareStatement(consultaEnderecoExistenteSQL);
        stmt.setString(1, userId);
        result = stmt.executeQuery();

        if (result.next()) {
            return result.getInt("FAV_ID_USUARIO");
        } else {
            return 0;  // Se não encontrar o endereço, retorna 0
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao obter ID do favorito: " + ex.getMessage());
        return 0;
    } finally {
        ConnectionFactory.closeConnection(con, stmt, result);
    }
}
private String obterNickPorId(String userId) {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    ResultSet result = null;

    try {
        if (con == null) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.");
            return null;
        }

        String consultaSQL = "SELECT USE_NICK FROM USUARIO WHERE USE_ID = ?";
        stmt = con.prepareStatement(consultaSQL);
        stmt.setString(1, userId);
        result = stmt.executeQuery();

        if (result.next()) {
            return result.getString("USE_NICK");
        } else {
            return null;  // Se não encontrar o usuário, retorna null
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao obter USE_NICK por ID: " + ex.getMessage());
        return null;
    } finally {
        ConnectionFactory.closeConnection(con, stmt, result);
    }
}
}
