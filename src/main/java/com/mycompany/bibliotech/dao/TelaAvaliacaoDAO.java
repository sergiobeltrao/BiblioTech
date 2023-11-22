	/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author jonat
 */
public class TelaAvaliacaoDAO {

    public static void listarCategorias(JComboBox<String> comboBox) {
        try {
            Connection con = ConnectionFactory.getConnection();
            String sql = "select LIV_NOME_LIVRO from livro where LIV_NOME_LIVRO like '%?%';";
            PreparedStatement comando = con.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();

           
            comboBox.addItem("");

            while (resultado.next()) {
               // comboBox.addItem(String.valueOf(resultado.getInt("CAT_ID")) + " - " + resultado.getString("CAT_NOME"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela categoria: " + ex);
        }
    }
}
