package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class LivroCategoriaDAO {

    public static void listarCategorias(JComboBox<String> comboBox) {
        try {
            Connection con = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM CATEGORIA";
            PreparedStatement comando = con.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();

            comboBox.removeAllItems();
            comboBox.addItem("Não Informada");

            while (resultado.next()) {
                comboBox.addItem(String.valueOf(resultado.getInt("CAT_ID")) + " - " + resultado.getString("CAT_NOME"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela categoria: " + ex);
        }
    }

    public static void listarSubCategoria(JComboBox<String> comboBox, String idCategoria) {
        try {
            comboBox.removeAllItems();
            comboBox.addItem("Não Informada");

            if (idCategoria != null && !idCategoria.isEmpty()) {
                // Verifica se idCategoria é um número válido antes de converter.
                try {
                    int categoriaId = Integer.parseInt(idCategoria);

                    Connection con = ConnectionFactory.getConnection();
                    String sql = "SELECT * FROM SUBCATEGORIA WHERE SCA_CATEGORIA = ?";
                    PreparedStatement comando = con.prepareStatement(sql);
                    comando.setInt(1, categoriaId);
                    ResultSet resultado = comando.executeQuery();

                    while (resultado.next()) {
                        comboBox.addItem(String.valueOf(resultado.getInt("SCA_ID")) + " - " + resultado.getString("SCA_NOME"));
                    }
                } catch (NumberFormatException e) {
                    // Trate o erro, por exemplo, emitindo uma mensagem de erro ou fazendo outra ação apropriada.
                    System.err.println("ID de categoria inválido: " + idCategoria);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela sub-categoria: " + ex);
        }
    }

}
