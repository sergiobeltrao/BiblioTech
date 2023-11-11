/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jonat
 */
public class TelaAvalaiacaoDAO {

    public void TelaAcaliacao() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT L.LIV_NOME_LIVRO, L.LIV_PAGINA, L.LIV_ANO, L.LIV_EDITORA, "
                    + "L.LIV_SINOPSE, A.AVA_COMENTARIO, C.CAT_NOME FROM LIVRO L LEFT JOIN AVALIACAO A ON "
                    + "L.ID_LIVRO = A.AVA_FK_LIVRO LEFT JOIN CATEGORIA C ON L.LIV_CATEGORIA = C.CAT_ID WHERE LIV_NOME_LIVRO = ?;");

        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Livro não encontrado: " + ex);
        } 
        finally {
            ConnectionFactory.closeConnection(con, stmt);

        }
    }
}
