package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;
import com.mycompany.bibliotech.model.bean.Autor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class AutorDAO {

    public void create(Autor aut) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO AUTOR (ID_AUTOR, AUT_NOME_AUTOR, AUT_DATA_NASC, AUT_NACIONALIDADE, AUT_BIBLIOGRAFIA, AUT_SEXO) VALUES(NULL, ?, ?, ?, ?, ?)");

            java.util.Date utilDate = aut.getDataDeNascimento();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            stmt.setString(1, aut.getNome());
            stmt.setDate(2, sqlDate);
            stmt.setString(3, aut.getNacionalidade());
            stmt.setString(4, aut.getBibliografia());
            stmt.setString(5, aut.getSexo());

            // Para preparar o SQL e executar
            stmt.executeUpdate();

            // Desativado por enquanto para evitar duplicidade de mensagens
            // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro nos dados do autor: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Autor> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Autor> autores = new ArrayList<>();

        try {
            stmt = con.prepareCall("SELECT * FROM AUTOR");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Autor autor = new Autor();

                autor.setId(rs.getInt("ID_AUTOR"));
                autor.setNome(rs.getString("AUT_NOME_AUTOR"));
                autor.setDataDeNascimento(rs.getDate("AUT_DATA_NASC"));
                autor.setNacionalidade(rs.getString("AUT_NACIONALIDADE"));
                autor.setBibliografia(rs.getString("AUT_BIBLIOGRAFIA"));
                autor.setSexo(rs.getString("AUT_SEXO"));

                autores.add(autor);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return autores;
    }

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
