package com.mycompany.bibliotech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.mycompany.bibliotech.connection.ConnectionFactory;
import com.mycompany.bibliotech.model.bean.Usuario;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioCadastroDAO {

    public void cadastrarUsuario(Usuario user) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO USUARIO (USE_ID, USE_NICK, USE_SENHA, USE_TYPE, USE_NOME, USE_SOBRENOME, USE_DATANASC, USE_EMAIL, USE_CRIA, USE_SEXO, USE_CPF) VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, NOW(), ?, ?)");

            stmt.setString(1, user.getUserNick());
            stmt.setString(2, user.getUserSenha());
            stmt.setString(3, user.getUserType());
            stmt.setString(4, user.getUserNome());
            stmt.setString(5, user.getUserSobrenome());
            
            java.util.Date utilDate = user.getUserDataNasc();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        
            stmt.setDate(6, sqlDate);
            stmt.setString(7, user.getUserEmail());
            stmt.setString(8, user.getUserSexo());
            stmt.setString(9, user.getUserCpf());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
