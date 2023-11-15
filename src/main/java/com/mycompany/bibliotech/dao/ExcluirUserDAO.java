package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ExcluirUserDAO {

    public void mostrarEExcluirUsuario() {
        // Lista de usuários do banco de dados
        JComboBox<String> userList = new JComboBox<>();

        // Preenche a lista de usuários
        preencherListaUsuarios(userList);

        // Exibição da caixa de diálogo para o usuário fazer uma escolha
        int option = JOptionPane.showConfirmDialog(
                null,
                userList,
                "Selecione um usuário para excluir:",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Se o usuário pressionar OK, excluir o usuário selecionado
        if (option == JOptionPane.OK_OPTION) {
            String usuarioSelecionado = (String) userList.getSelectedItem();
            excluirUsuario(usuarioSelecionado);
        }
    }

    private void preencherListaUsuarios(JComboBox<String> userList) {
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

  private void excluirUsuario(String usuarioSelecionado) {
    Connection conexao = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {
        // Obtém uma conexão usando a classe ConnectionFactory
        conexao = ConnectionFactory.getConnection();

        // Log para verificar o valor de USE_NOME
        System.out.println("USE_NOME recebido: " + usuarioSelecionado);

        // Consulta SQL para obter o USE_ID associado ao USE_NOME
        String sqlId = "SELECT USE_ID FROM USUARIO WHERE USE_NOME = ?";
        statement = conexao.prepareStatement(sqlId);
        statement.setString(1, usuarioSelecionado);
        resultSet = statement.executeQuery();

        // Verifica se encontrou o USE_ID
        if (resultSet.next()) {
            int userId = resultSet.getInt("USE_ID");
            System.out.println("USE_ID encontrado: " + userId);

            // Excluir registros relacionados primeiro
            excluirRegistrosRelacionados(conexao, userId);

            // Consulta SQL para excluir o usuário
            String sqlDeleteUser = "DELETE FROM USUARIO WHERE USE_ID = ?";
            statement = conexao.prepareStatement(sqlDeleteUser);
            statement.setInt(1, userId);

            // Executa a atualização
            int linhasAfetadas = statement.executeUpdate();

            // Verifica se o usuário foi excluído com sucesso
            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Usuário e registros relacionados excluídos com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao excluir o usuário. Usuário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException e) {
        // Mensagem de erro ao usuário em caso de falha
        JOptionPane.showMessageDialog(null, "Erro ao excluir usuário. Detalhes do erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    } finally {
        // Fecha os recursos
        ConnectionFactory.closeConnection(conexao, statement, resultSet);
    }
}

private void excluirRegistrosRelacionados(Connection conexao, int userId) throws SQLException {
    // Log para verificar o valor de USE_ID
    System.out.println("Excluindo registros relacionados para USE_ID: " + userId);

    // Consulta SQL para excluir registros relacionados
    String sqlDeleteRelacionados = "DELETE EU, E, TU, T, F "
                                 + "FROM ENDERECO_USUARIO EU "
                                 + "LEFT JOIN ENDERECO E ON EU.ENDERECO_CHAVE = E.END_ID "
                                 + "LEFT JOIN TELEFONE_USUARIO TU ON EU.ENDERECO_USER = TU.TELEFONE_USER "
                                 + "LEFT JOIN TELEFONE T ON TU.TELEFONE_FONE = T.TEL_ID "
                                 + "LEFT JOIN FAVORITO F ON EU.ENDERECO_USER = F.FAV_USUARIO "
                                 + "WHERE EU.ENDERECO_USER = ?";
    PreparedStatement statement = conexao.prepareStatement(sqlDeleteRelacionados);
    statement.setInt(1, userId);
    statement.executeUpdate();
}






}
