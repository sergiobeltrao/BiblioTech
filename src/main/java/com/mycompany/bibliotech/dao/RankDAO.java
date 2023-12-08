package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RankDAO {

    public static List<String> ranking() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT LIVRO.ID_LIVRO, LIVRO.LIV_NOME_LIVRO, "
                    + "ROUND(AVG(AVALIACAO.AVA_USUARIO), 1) AS MEDIA_NOTA FROM LIVRO\n"
                    + "JOIN AVALIACAO ON LIVRO.ID_LIVRO = AVALIACAO.AVA_FK_LIVRO\n"
                    + "GROUP BY LIVRO.ID_LIVRO, LIVRO.LIV_NOME_LIVRO\n"
                    + "ORDER BY MEDIA_NOTA DESC LIMIT 10;");
            ResultSet rank = stmt.executeQuery();

            List<String> resultList = new ArrayList<>();
            while (rank.next()) {
                String livroNome = rank.getString("LIVRO.LIV_NOME_LIVRO");
                double mediaNota = rank.getDouble("MEDIA_NOTA");
                resultList.add(livroNome + "   Nota: " + mediaNota);
            }

            return resultList;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na seleção do rank" + ex);
            return null;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public static List<String> record() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT ID_LIVRO, LIV_NOME_LIVRO FROM LIVRO\n"
                    + "	ORDER BY ID_LIVRO DESC\n"
                    + "	LIMIT 10");
            ResultSet record = stmt.executeQuery();

            List<String> resultList = new ArrayList<>();
            while (record.next()) {
                String livro = record.getString("LIV_NOME_LIVRO");

                resultList.add(livro);
            }

            return resultList;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lançamentos não encontrado" + ex);
            return null;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public static List<String> topList() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT ROUND(AVG(AVALIACAO.AVA_USUARIO), 1) AS MEDIA_NOTA FROM LIVRO\n"
                    + "JOIN AVALIACAO ON LIVRO.ID_LIVRO = AVALIACAO.AVA_FK_LIVRO\n"
                    + "GROUP BY LIVRO.ID_LIVRO, LIVRO.LIV_NOME_LIVRO\n"
                    + "ORDER BY MEDIA_NOTA DESC LIMIT 10;");
            ResultSet rank = stmt.executeQuery();

            List<String> resultList = new ArrayList<>();
            while (rank.next()) {
                double mediaNota = rank.getDouble("MEDIA_NOTA");
                resultList.add("Nota: " + mediaNota);
            }

            return resultList;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na seleção do rank" + ex);
            return null;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
