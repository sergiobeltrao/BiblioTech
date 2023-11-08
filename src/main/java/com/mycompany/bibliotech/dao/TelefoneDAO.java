package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;
import com.mycompany.bibliotech.model.bean.Telefone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TelefoneDAO {

       public void cadastrarTelefone(Telefone tel, String userNome, String telefone, String tipo) {
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
                JOptionPane.showMessageDialog(null, "Erro ao consultar USE_ID para tabela de telefone");
                return;  // Encerre o método se não encontrar o usuário
            }

            // Verificar se o telefone já existe na tabela Telefone
            String consultaTelefoneExistenteSQL = "SELECT TEL_ID FROM TELEFONE WHERE TEL_TELEFONE = ? AND TEL_TIPO = ?";
            stmt = con.prepareStatement(consultaTelefoneExistenteSQL);
            stmt.setString(1, tel.getTelefone());
            stmt.setString(2,tel.getTipo());
            ResultSet resultadoTelefoneExistente = stmt.executeQuery();

            int telefoneExistenteId = 0;

            // Se um registro existente for encontrado
            if (resultadoTelefoneExistente.next()) {
                telefoneExistenteId = resultadoTelefoneExistente.getInt("TEL_ID");
            } else {
                // Caso contrário, insira um novo telefone na tabela TELEFONE
                stmt = con.prepareStatement("INSERT INTO TELEFONE (TEL_ID, TEL_TIPO, TEL_TELEFONE) VALUES(NULL, ?, ?)");
                stmt.setString(1, tel.getTipo());
                stmt.setString(2, tel.getTelefone());

                // Executar a inserção na tabela TELEFONE
                stmt.executeUpdate();

                // Obtenha o ID do novo telefone
                stmt = con.prepareStatement("SELECT LAST_INSERT_ID() AS LAST_ID");
                ResultSet result = stmt.executeQuery();
                if (result.next()) {
                    telefoneExistenteId = result.getInt("LAST_ID");
                }
            }

            // Preparar o SQL para inserir na tabela telefone_usuario
            stmt = con.prepareStatement("INSERT INTO telefone_usuario (TELEFONE_USER, TELEFONE_FONE) VALUES(?, ?);");
            stmt.setInt(1, userId);
            stmt.setInt(2, telefoneExistenteId);

            // Executar a inserção na tabela telefone_usuario
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro nos dados do endereço: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
