package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;
import com.mycompany.bibliotech.model.bean.Avaliacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AvaliacaoDAO {

    public void create(Avaliacao av, String nomeDoLivro, String nomeDoUsuario) {
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

            // Pega o usuário que está avaliando
            String idDoUsuarioQueAvaliou = "SELECT USE_ID FROM USUARIO WHERE USE_NICK = ?";
            stmt = con.prepareStatement(idDoUsuarioQueAvaliou);
            stmt.setString(1, nomeDoUsuario);
            ResultSet resultadoUser = stmt.executeQuery();
            int idDoUser = 0;

            if (resultadoUser.next()) {
                idDoUser = resultadoUser.getInt("USE_ID");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao consultar USE_ID para tabela de avaliações");
            }

            stmt = con.prepareStatement("INSERT INTO AVALIACAO (AVA_ID_USUARIO, AVA_FK_LIVRO, AVA_USUARIO, AVA_COMENTARIO, AVA_DATA_AVALIACAO) VALUES(?, ?, ?, ?, NOW())");

            stmt.setInt(1, idDoUser);
            stmt.setInt(2, idLivro);
            stmt.setString(3, av.getAvaliacaoDoUsuario());
            stmt.setString(4, av.getComentarioAvaliacao());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro nos dados da avaliação: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    // Para o retorno dos dados do banco na jTable
    public List<Avaliacao> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Avaliacao> avaliacoes = new ArrayList<>();

        try {
            stmt = con.prepareCall("SELECT AVA_USUARIO, AVA_COMENTARIO FROM AVALIACAO;");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Avaliacao avaliacao = new Avaliacao();

                avaliacao.setAvaliacaoDoUsuario(rs.getString("AVA_USUARIO"));
                avaliacao.setComentarioAvaliacao(rs.getString("AVA_COMENTARIO"));

                avaliacoes.add(avaliacao);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return avaliacoes;
    }

    public void rank(Avaliacao nota, String buscaLivro, String verificaUsuario, String rank) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            // Pega o ID_LIVRO que está sendo cadastrado
            String consultaSQL = "SELECT ID_LIVRO FROM LIVRO WHERE LIV_NOME_LIVRO = ?";
            stmt = con.prepareStatement(consultaSQL);
            stmt.setString(1, buscaLivro);
            ResultSet resultado = stmt.executeQuery();
            int idLivro = 0;

            // Verifica se há resultados
            if (resultado.next()) {
                idLivro = resultado.getInt("ID_LIVRO");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao consultar ID_LIVRO para tabela de avaliações");
            }

            // Pega o usuário que está avaliando
            String idDoUsuarioQueAvaliou = "SELECT USE_ID FROM USUARIO WHERE USE_NICK = ?";
            stmt = con.prepareStatement(idDoUsuarioQueAvaliou);
            stmt.setString(1, verificaUsuario);
            ResultSet resultadoUser = stmt.executeQuery();
            int idDoUser = 0;

            if (resultadoUser.next()) {
                idDoUser = resultadoUser.getInt("USE_ID");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao consultar USE_ID para tabela de avaliações");
            }

            // Faz o insert na tabela AVALIACAO
            stmt = con.prepareStatement("INSERT INTO AVALIACAO (AVA_ID_USUARIO, AVA_FK_LIVRO, AVA_USUARIO, AVA_TOTAL, AVA_COMENTARIO, AVA_DATA_AVALIACAO) VALUES(?, ?, ?, '10.0', 'kjgvhadfoi', NOW())");

            // O AVA_TOTAL ainda será implementado, deixei um valor qualquer.
            // Implementar captura do USE_ID com base no usuário logado para preencher o AVA_FK_USUARIO.
            stmt.setInt(2, idLivro);
            stmt.setString(3, rank);
            //stmt.setInt(3, nota.get);
            //stmt.setString(4, nota.getComentarioAvaliacao());
            stmt.setInt(1, idDoUser);

            // Para preparar o SQL e executar
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro nos dados da avaliação: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
