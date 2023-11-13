/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author jonat
 */
public class TelaAvaliacaoDAO {

    public List<Avaliacao> find() {
        Connection con = ConnectionFactory.getConnection();
        String sql = "SELECT L.LIV_NOME_LIVRO, L.LIV_PAGINA, L.LIV_ANO, L.LIV_EDITORA, A.AVA_COMENTARIO"
                + "FROM LIVRO L LEFT JOIN AVALIACAO A ON L.ID_LIVRO = A.AVA_FK_LIVRO"
                + "LEFT JOIN CATEGORIA C ON L.LIV_CATEGORIA = C.CAT_ID WHERE LIV_NOME_LIVRO = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Avaliacao> Avaliacao = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Avaliacao avaliacao = new Avaliacao();

                avaliacao.setTxtBuscaLivro(rs.getString("LIV_NOME_LIVRO"));
                avaliacao.setTxtPaginas(rs.getInt("LIV_PAGINA"));
                avaliacao.setTxtAno(rs.getInt("LIV_ANO"));
                avaliacao.setTxtEditora(rs.getString("LIV_EDITORA"));
                avaliacao.setTxtComentario(rs.getString("AVA_COMENTARIO"));
                Avaliacao.add(avaliacao);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Livro não encontrado " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return Avaliacao;

    }
}
