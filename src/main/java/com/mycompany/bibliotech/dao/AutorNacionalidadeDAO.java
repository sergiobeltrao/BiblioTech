package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class AutorNacionalidadeDAO {

    public static void listaDeNacionalidades(JComboBox<String> comboBox) {
        try {
            Connection con = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM NACIONALIDADE";
            PreparedStatement comando = con.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();

            comboBox.removeAllItems();
            comboBox.addItem("Selecione");

            while (resultado.next()) {
                comboBox.addItem(resultado.getString("NAC_NOME"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela de nacionalidades: " + ex);
        }
    }

}
