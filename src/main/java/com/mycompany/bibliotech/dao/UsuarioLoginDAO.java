package com.mycompany.bibliotech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.bibliotech.connection.ConnectionFactory;
import com.mycompany.bibliotech.model.bean.ApplicationContext;
import com.mycompany.bibliotech.model.bean.Login;
import javax.swing.JOptionPane;

public class UsuarioLoginDAO {

    public String checkLogin(String login, String senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String userType = null;

        // A = Administrador, F = Funcionário, C = Cliente
        String[] userTypesToCheck = {"ADMIN", "CLIENTE"};

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

    public boolean tipoDoUsuarioLogado() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet resultado = null;
        boolean usuarioAdministrador = false;

        Login login = ApplicationContext.getLogin();

        try {
            stmt = con.prepareStatement("SELECT USE_TYPE FROM USUARIO WHERE USE_NICK = ?");
            stmt.setString(1, login.getNick());

            resultado = stmt.executeQuery();

            if (resultado.next()) {
                String userType = resultado.getString("USE_TYPE");

                if (userType.equals("ADMIN")) {
                    usuarioAdministrador = true;
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na verificação do autor: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, resultado);
        }
        return usuarioAdministrador;
    }

}
