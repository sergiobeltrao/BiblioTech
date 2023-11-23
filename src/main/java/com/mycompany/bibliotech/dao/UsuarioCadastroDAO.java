package com.mycompany.bibliotech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.mycompany.bibliotech.connection.ConnectionFactory;
import com.mycompany.bibliotech.model.bean.Usuario;
import com.mycompany.bibliotech.model.bean.Telefone;
import com.mycompany.bibliotech.model.bean.Endereco;
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
     public void atualizar(Usuario user) {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;

    try {
        if (con == null) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.");
            return;
        }

        stmt = con.prepareStatement("UPDATE USUARIO SET USE_NICK=?, USE_SENHA=?, USE_TYPE=?, USE_NOME=?, USE_SOBRENOME=?, USE_DATANASC=?, USE_EMAIL=?, USE_CRIA=?, USE_SEXO=?, USE_CPF=? WHERE USE_ID=?");

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
        stmt.setInt(10, user.getUserId());  // Certifique-se de que este método exista em seu objeto Usuario

        int linhasAfetadas = stmt.executeUpdate();

        if (linhasAfetadas > 0) {
            con.commit();  // Confirme a transação apenas se a atualização for bem-sucedida
            JOptionPane.showMessageDialog(null, "Edição realizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum usuário atualizado. Verifique o ID do usuário.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao Editar: " + ex.getMessage());
        ex.printStackTrace();  // Isso ajudará a identificar a origem exata do erro no console
    } finally {
        ConnectionFactory.closeConnection(con, stmt);
    }
}
public void buscarUsuarioPorNome(Usuario user, String userNome) {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;

    try {
        if (con == null) {
            throw new SQLException("Não foi possível conectar ao banco de dados.");
        }

        stmt = con.prepareStatement("SELECT * FROM USUARIO WHERE USE_NICK = ?");
        stmt.setString(1, userNome);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // Adapte conforme necessário com os nomes reais das colunas no seu banco de dados
            user.setUserId(rs.getInt("USE_ID"));
            user.setUserEmail(rs.getString("USE_EMAIL"));
            
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao buscar usuário: " + ex.getMessage());
        ex.printStackTrace();
    } finally {
        ConnectionFactory.closeConnection(con, stmt);
    }
}






}
