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
    
    public void atualizar(Endereco end) {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;

    try {
        if (con == null) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.");
            return;
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
        stmt.setInt(9, end.getId());

        int linhasAfetadas = stmt.executeUpdate();

        if (linhasAfetadas > 0) {
            con.commit();
            JOptionPane.showMessageDialog(null, "Endereço atualizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum endereço atualizado. Verifique os dados informados.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar endereço: " + ex.getMessage());
        ex.printStackTrace();
    } finally {
        ConnectionFactory.closeConnection(con, stmt);
    }
}
}
