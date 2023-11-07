package com.mycompany.bibliotech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.bibliotech.connection.ConnectionFactory;

public class UsuarioLoginDAO {

    public String checkLogin(String login, String senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String userType = null;

        // A = Administrador, F = Funcionário, C = Cliente
        String[] userTypesToCheck = {"ADMIN", "BIBLIOTECARIO", "CLIENTE"};

        try {
            for (String userTypeToCheck : userTypesToCheck) {
                stmt = con.prepareStatement("SELECT * FROM USUARIO WHERE USE_NICK = ? AND USE_SENHA = ? AND USE_TYPE = ?");
                stmt.setString(1, login);
                stmt.setString(2, senha);
                stmt.setString(3, userTypeToCheck);

                rs = stmt.executeQuery();

                if (rs.next()) {
                    userType = userTypeToCheck;
                    break; // Saia do loop se encontrar uma correspondência
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioLoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return userType;

    }
}
