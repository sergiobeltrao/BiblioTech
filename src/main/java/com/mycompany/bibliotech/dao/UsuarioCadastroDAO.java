package com.mycompany.bibliotech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.mycompany.bibliotech.connection.ConnectionFactory;
import com.mycompany.bibliotech.model.bean.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
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

    public void excluirUsuario(String nick) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM USUARIO WHERE USE_NICK = ?");

            stmt.setString(1, nick);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void preencherListaUsuarios(JComboBox<String> userList) {
        Connection conexao = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Obtém uma conexão usando a classe ConnectionFactory
            conexao = ConnectionFactory.getConnection();

            // Consulta SQL para obter os usuários
            String sql = "SELECT USE_NICK FROM USUARIO";

            // Prepara a instrução SQL
            statement = conexao.prepareStatement(sql);

            // Executa a consulta
            resultSet = statement.executeQuery();

            // Preenche a lista de usuários
            while (resultSet.next()) {
                String nomeUsuario = resultSet.getString("USE_NICK");
                userList.addItem(nomeUsuario);
            }

        } catch (SQLException e) {
            // Mensagem de erro ao usuário em caso de falha
            JOptionPane.showMessageDialog(null, "Erro ao obter lista de usuários. Por favor, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            // Fecha os recursos
            ConnectionFactory.closeConnection(conexao, statement, resultSet);
        }
    }
     public boolean atualizar() { 
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        stmt = con.prepareStatement("UPDATE USUARIO SET nome=?, fone=?, email=? WHERE codigo=?");
        
        try {
            stmt.setString(1, );
            stmt.setString(2, );
            stmt.setString(3, );
            stmt.setInt(4, );
            
            stmt.executeUpdate();
            
            return true;
            
                JOptionPane.showMessageDialog(null, "Edição realizada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
