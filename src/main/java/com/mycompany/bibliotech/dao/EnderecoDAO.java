package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;
import com.mycompany.bibliotech.model.bean.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class EnderecoDAO {

    public void cadastrarEndereco(Endereco end, String userNome, String cep, int num) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            // Pega o USE_ID que está sendo cadastrado
            String consultaSQL = "SELECT USE_ID FROM USUARIO WHERE USE_NICK = ?";
            stmt = con.prepareStatement(consultaSQL);
            stmt.setString(1, userNome);
            ResultSet resultado = stmt.executeQuery();
            int userId = 0;

            // Verifica se há resultados
            if (resultado.next()) {
                userId = resultado.getInt("USE_ID");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao consultar USE_ID para tabela de endereço");
                return;  // Encerre o método se não encontrar o usuário
            }

            // Verificar se o endereço já existe na tabela ENDERECO
            String consultaEnderecoExistenteSQL = "SELECT END_ID FROM ENDERECO WHERE END_RUA = ? AND END_NUM = ? AND END_CEP = ?";
            stmt = con.prepareStatement(consultaEnderecoExistenteSQL);
            stmt.setString(1, end.getRua());
            stmt.setInt(2, end.getNum());
            stmt.setString(3, end.getCep());
            ResultSet resultadoEnderecoExistente = stmt.executeQuery();

            int enderecoExistenteId = 0;

            // Se um registro existente for encontrado
            if (resultadoEnderecoExistente.next()) {
                enderecoExistenteId = resultadoEnderecoExistente.getInt("END_ID");
            } else {
                // Caso contrário, insira um novo endereço na tabela ENDERECO
                stmt = con.prepareStatement("INSERT INTO ENDERECO (END_ID, END_RUA, END_NUM, END_COMP, END_BAIRRO, END_CIDADE, END_UF, END_PAIS, END_CEP) VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?)");
                stmt.setString(1, end.getRua());
                stmt.setInt(2, end.getNum());
                stmt.setString(3, end.getComp());
                stmt.setString(4, end.getBairro());
                stmt.setString(5, end.getCidade());
                stmt.setString(6, end.getUf());
                stmt.setString(7, end.getPais());
                stmt.setString(8, end.getCep());

                // Executar a inserção na tabela ENDERECO
                stmt.executeUpdate();

                // Obtenha o ID do novo endereço
                stmt = con.prepareStatement("SELECT LAST_INSERT_ID() AS LAST_ID");
                ResultSet result = stmt.executeQuery();
                if (result.next()) {
                    enderecoExistenteId = result.getInt("LAST_ID");
                }
            }

            // Preparar o SQL para inserir na tabela endereco_usuario
            stmt = con.prepareStatement("INSERT INTO endereco_usuario (ENDERECO_USER, ENDERECO_CHAVE) VALUES(?, ?);");
            stmt.setInt(1, userId);
            stmt.setInt(2, enderecoExistenteId);

            // Executar a inserção na tabela endereco_usuario
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro nos dados do endereço: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void atualizar(Endereco end, String userId) {
        Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;

    try {
        if (con == null) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.");
            return;
        }

        con.setAutoCommit(false);  // Desativa o autocommit
        
       // Verificar se o endereço existe para o usuário
        int enderecoExistenteId = obterIdEnderecoUsuario(userId);

        if (enderecoExistenteId == 0) {
            // Se o endereço não existe, chama o método cadastrarEndereco para criar um novo endereço
            
            cadastrarEndereco(end, obterNickPorId(userId), end.getCep(), end.getNum());
            // Obtém o ID do endereço recém-criado
            enderecoExistenteId = obterIdEnderecoUsuario(userId);
        }
            

        // Montar instrução SQL
        stmt = con.prepareStatement("UPDATE ENDERECO SET END_RUA=?, END_NUM=?, END_COMP=?, END_BAIRRO=?, END_CIDADE=?, END_UF=?, END_PAIS=?, END_CEP=? WHERE END_ID=?");

        // Setar valores para a instrução SQL
        stmt.setString(1, end.getRua());
        stmt.setInt(2, end.getNum());
        stmt.setString(3, end.getComp());
        stmt.setString(4, end.getBairro());
        stmt.setString(5, end.getCidade());
        stmt.setString(6, end.getUf());
        stmt.setString(7, end.getPais());
        stmt.setString(8, end.getCep());
        stmt.setInt(9, enderecoExistenteId);

        int linhasAfetadas = stmt.executeUpdate();

        if (linhasAfetadas > 0) {
            con.commit();
            JOptionPane.showMessageDialog(null, "Endereço atualizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum endereço atualizado. Verifique os dados informados.");
        }
    } catch (SQLException ex) {
        try {
            con.rollback();  // Desfaz a transação em caso de exceção
        } catch (SQLException rollbackEx) {
            rollbackEx.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Erro ao atualizar endereço: " + ex.getMessage());
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
private int obterIdEnderecoUsuario(String userId) {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    ResultSet result = null;

    try {
        if (con == null) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.");
            return 0;
        }

        String consultaEnderecoExistenteSQL = "SELECT E.END_ID FROM USUARIO U\n" +
                "LEFT JOIN ENDERECO_USUARIO EU ON U.USE_ID = EU.ENDERECO_USER\n" +
                "LEFT JOIN ENDERECO E ON EU.ENDERECO_CHAVE = E.END_ID\n" +
                "WHERE U.USE_ID = ?";
        
        stmt = con.prepareStatement(consultaEnderecoExistenteSQL);
        stmt.setString(1, userId);
        result = stmt.executeQuery();

        if (result.next()) {
            return result.getInt("END_ID");
        } else {
            return 0;  // Se não encontrar o endereço, retorna 0
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao obter ID do endereço: " + ex.getMessage());
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
