package com.mycompany.bibliotech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.mycompany.bibliotech.connection.ConnectionFactory;
import com.mycompany.bibliotech.model.bean.Usuario;
import com.mycompany.bibliotech.model.bean.Telefone;
import com.mycompany.bibliotech.model.bean.Endereco;
import com.mycompany.bibliotech.model.bean.Favoritos;
import com.mycompany.bibliotech.telas.EdicaoUsuario;
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

    public void atualizar(Usuario user, String userId) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        //EdicaoUsuario eduser = new EdicaoUsuario(user, endereco, telefone, favoritos);
        
            try {
        if (con == null) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.");
            return;
        }

        con.setAutoCommit(false);  // Desativa o autocommit

            stmt = con.prepareStatement("UPDATE USUARIO SET USE_NICK=?, USE_NOME=?, USE_SOBRENOME=?, USE_DATANASC=?, USE_EMAIL=?, USE_SEXO=?, USE_CPF=? WHERE USE_ID=?");

            stmt.setString(1, user.getUserNick());
            stmt.setString(2, user.getUserNome());
            stmt.setString(3, user.getUserSobrenome());

            java.util.Date utilDate = user.getUserDataNasc();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            stmt.setDate(4, sqlDate);
            stmt.setString(5, user.getUserEmail());
            stmt.setString(6, user.getUserSexo());
            stmt.setString(7, user.getUserCpf());
            stmt.setInt(8, Integer.parseInt(userId));

             int linhasAfetadas = stmt.executeUpdate();

        if (linhasAfetadas > 0) {
            con.commit();  // Confirma a transação apenas se a atualização for bem-sucedida
            JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum usuário atualizado. Verifique o ID do usuário.");
        }
    } catch (SQLException ex) {
        try {
            con.rollback();  // Desfaz a transação em caso de exceção
        } catch (SQLException rollbackEx) {
            rollbackEx.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Erro ao Editar: " + ex.getMessage());
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

    public Usuario obterUsuarioPorNome(String userNome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            if (con == null) {
                throw new SQLException("Não foi possível conectar ao banco de dados.");
            }

            String sql = "SELECT * FROM USUARIO U "
                    + "LEFT JOIN ENDERECO_USUARIO EU ON U.USE_ID = EU.ENDERECO_USER "
                    + "LEFT JOIN ENDERECO E ON EU.ENDERECO_CHAVE = E.END_ID "
                    + "LEFT JOIN TELEFONE_USUARIO TU ON U.USE_ID = TU.TELEFONE_USER "
                    + "LEFT JOIN TELEFONE T ON TU.TELEFONE_FONE = T.TEL_ID "
                    + "LEFT JOIN FAVORITO F ON U.USE_ID = F.FAV_ID_USUARIO "
                    + "WHERE U.USE_NICK = ?";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, userNome);

            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                Usuario user = new Usuario();
                user.setUserId(resultSet.getInt("USE_ID"));
                user.setUserNick(resultSet.getString("USE_NICK"));
                user.setUserSenha(resultSet.getString("USE_SENHA"));
                user.setUserType(resultSet.getString("USE_TYPE"));
                user.setUserNome(resultSet.getString("USE_NOME"));
                user.setUserSobrenome(resultSet.getString("USE_SOBRENOME"));
                user.setUserEmail(resultSet.getString("USE_EMAIL"));
                user.setUserSexo(resultSet.getString("USE_SEXO"));
                user.setUserDataNasc(resultSet.getDate("USE_DATANASC"));
                user.setUserCpf(resultSet.getString("USE_CPF"));

                Endereco endereco = new Endereco();

                endereco.setId(resultSet.getInt("END_ID"));
                endereco.setRua(resultSet.getString("END_RUA"));
                endereco.setNum(resultSet.getInt("END_NUM"));
                endereco.setComp(resultSet.getString("END_COMP"));
                endereco.setBairro(resultSet.getString("END_BAIRRO"));
                endereco.setCidade(resultSet.getString("END_CIDADE"));
                endereco.setUf(resultSet.getString("END_UF"));
                endereco.setPais(resultSet.getString("END_PAIS"));
                endereco.setCep(resultSet.getString("END_CEP"));

                Telefone telefone = new Telefone();
                telefone.setId(resultSet.getInt("TEL_ID"));
                telefone.setTipo(resultSet.getString("TEL_TIPO"));
                telefone.setTelefone(resultSet.getString("TEL_TELEFONE"));
                // Configure os outros campos de telefone

                Favoritos favoritos = new Favoritos();
                //favoritos.setId(resultSet.getInt("ID"));
                favoritos.setFavCategoria1(resultSet.getString("FAV_CATEGORIA1"));
                favoritos.setFavSub1(resultSet.getString("FAV_SUB1"));
                favoritos.setFavCategoria2(resultSet.getString("FAV_CATEGORIA2"));
                favoritos.setFavSub2(resultSet.getString("FAV_SUB2"));
                favoritos.setFavUsuario(resultSet.getInt("FAV_ID_USUARIO"));

                user.setEndereco(endereco);
                user.setTelefone(telefone);
                user.setFavoritos(favoritos);
                
                return user;
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
                System.out.println("Usuário não encontrado.");
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar usuário: " + ex.getMessage());
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
