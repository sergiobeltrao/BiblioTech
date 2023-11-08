
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

        // Preparar o SQL para inserir na tabela ENDERECO
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

        // Pegar o ID do endereço recém-inserido
        String consultSQL = "SELECT END_ID FROM ENDERECO WHERE END_CEP = ? AND END_NUM = ?";
        stmt = con.prepareStatement(consultSQL);
        stmt.setString(1, cep);
        stmt.setInt(2, num);
        ResultSet result = stmt.executeQuery();
        int endId = 0;

        // Verificar se há resultados
        if (result.next()) {
            endId = result.getInt("END_ID");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao consultar END_ID para tabela de usuário");
            return;  // Encerre o método se não encontrar o endereço
        }

        // Preparar o SQL para inserir na tabela endereco_usuario
        stmt = con.prepareStatement("INSERT INTO endereco_usuario (ENDERECO_USER, ENDERECO_CHAVE) VALUES(?, ?);");

        stmt.setInt(1, userId);  // Usar o ID do usuário
        stmt.setInt(2, endId);  // Usar o ID do endereço

        // Executar a inserção na tabela endereco_usuario
        stmt.executeUpdate();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro nos dados do endereço: " + ex);
    } finally {
        ConnectionFactory.closeConnection(con, stmt);
    }
}

}
