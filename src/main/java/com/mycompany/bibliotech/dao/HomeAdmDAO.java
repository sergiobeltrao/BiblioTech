package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;
import com.mycompany.bibliotech.model.bean.UsuariosAvaliando;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class HomeAdmDAO {
   
    public static List<String> record() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT USE_ID, USE_NICK FROM USUARIO\n"
                    + "	ORDER BY USE_ID DESC\n"
                    + "	LIMIT 10");
            ResultSet record = stmt.executeQuery();

            List<String> resultList = new ArrayList<>();
            while (record.next()) {
                String livro = record.getString("USE_NICK");

                resultList.add(livro);
            }

            return resultList;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuarios não encontrados" + ex);
            return null;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     public static List<UsuariosAvaliando> numeroDeNotasPorUser() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<UsuariosAvaliando> contagens = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT U.USE_NICK, COUNT(*) AS QUANTIDADE_DE_AVALIACOES\n" +
"FROM AVALIACAO A\n" +
"JOIN LIVRO L ON A.AVA_FK_LIVRO = L.ID_LIVRO\n" +
"JOIN USUARIO U ON A.AVA_ID_USUARIO = U.USE_ID\n" +
"GROUP BY U.USE_NICK\n" +
"ORDER BY QUANTIDADE_DE_AVALIACOES DESC");
            rs = stmt.executeQuery();

            while (rs.next()) {
                UsuariosAvaliando contagem = new UsuariosAvaliando();
                contagem.setNomeUsuario(rs.getString("USE_NICK"));
                contagem.setQuantidadeAvaliacoes(rs.getInt("QUANTIDADE_DE_AVALIACOES"));
                contagens.add(contagem);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return contagens;
    }
     
     public static List<String> data() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT U.USE_NICK, MAX(A.AVA_DATA_AVALIACAO) AS DATA_MAIS_RECENTE\n" +
"FROM USUARIO U\n" +
"LEFT JOIN AVALIACAO A ON U.USE_ID = A.AVA_ID_USUARIO\n" +
"GROUP BY U.USE_NICK\n" +
"ORDER BY DATA_MAIS_RECENTE DESC");
            ResultSet rank = stmt.executeQuery();

            List<String> resultList = new ArrayList<>();
            while (rank.next()) {
                String livroNome = rank.getString("U.USE_NICK");
                 Timestamp dataMaisRecente = rank.getTimestamp("DATA_MAIS_RECENTE");
                resultList.add(livroNome + "   Avaliação mais recente: " + dataMaisRecente);
            }

            return resultList;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na procura das datas de avaliação" + ex);
            return null;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
