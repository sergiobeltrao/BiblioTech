package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;
import com.mycompany.bibliotech.model.bean.Avaliacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AvaliacaoDAO {

    public void create(Avaliacao av, String nomeDoLivro) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            // Pega o ID_LIVRO que está sendo cadastrado
            String consultaSQL = "SELECT ID_LIVRO FROM LIVRO WHERE LIV_NOME_LIVRO = ?";
            stmt = con.prepareStatement(consultaSQL);
            stmt.setString(1, nomeDoLivro);
            ResultSet resultado = stmt.executeQuery();
            int idLivro = 0;

            // Verifica se há resultados
            if (resultado.next()) {
                idLivro = resultado.getInt("ID_LIVRO");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao consultar ID_LIVRO para tabela de avaliações");
            }

            stmt = con.prepareStatement("INSERT INTO AVALIACAO (ID_AVALIACAO, AVA_FK_LIVRO, AVA_USUARIO, AVA_TOTAL, AVA_COMENTARIO, AVA_DATA_AVALIACAO, AVA_FK_USUARIO) VALUES(NULL, ?, ?, '9.0', ?, NOW(), 1)");

            // O AVA_TOTAL ainda será implementado, deixei um valor qualquer.
            // Implementar captura do USE_ID com base no usuário logado para preencher o AVA_FK_USUARIO.
            stmt.setInt(1, idLivro);
            stmt.setString(2, av.getAvaliacaoDoUsuario());
            stmt.setString(3, av.getComentarioAvaliacao());
            //stmt.setString(4, algumacoisa);

            // Para preparar o SQL e executar
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro nos dados da avaliação: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
