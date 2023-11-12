/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;
import com.mycompany.bibliotech.model.bean.Avaliacao;
import com.mycompany.bibliotech.telas.TelaAvaliacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jonat
 */
public class TelaAvaliacaoDAO {

    public List<Avaliacao> findAll() {
        Connection con = ConnectionFactory.getConnection();
        String sql = "SELECT L.LIV_NOME_LIVRO, L.LIV_PAGINA, L.LIV_ANO, L.LIV_EDITORA, "
                + "L.LIV_SINOPSE, A.AVA_COMENTARIO, C.CAT_NOME FROM LIVRO L LEFT JOIN AVALIACAO A "
                + "ON L.ID_LIVRO = A.AVA_FK_LIVRO LEFT JOIN CATEGORIA C ON "
                + "L.LIV_CATEGORIA = C.CAT_ID WHERE LIV_NOME_LIVRO = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Avaliacao> Avaliacao = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Avaliacao avaliacao = new Avaliacao();
                
                Avaliacao.set
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Livro não encontrado " + ex);
        }

    }
}
