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
            stmt = con.prepareStatement("INSERT INTO AUTOR (ID_AUTOR, AUT_NOME_AUTOR, AUT_NACIONALIDADE, AUT_SEXO) VALUES(NULL, ?, ?, ?)");

            stmt.setString(1, aut.getNome());
            stmt.setString(2, aut.getNacionalidade());
            stmt.setString(3, aut.getSexo());

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
                autor.setNacionalidade(rs.getString("AUT_NACIONALIDADE"));
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
            comboBox.addItem("Não Informada");

            while (resultado.next()) {
                comboBox.addItem(resultado.getString("NAC_NOME"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela de nacionalidades: " + ex);
        }
    }

    public static void buscarAutor(JComboBox<String> comboBox, String busca) {
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;

            stmt = con.prepareStatement("SELECT AUT_NOME_AUTOR FROM AUTOR WHERE AUT_NOME_AUTOR LIKE ?");

            stmt.setString(1, "%" + busca + "%");

            ResultSet resultado = stmt.executeQuery();

            comboBox.removeAllItems();
            boolean encontrouResultado = false;

            while (resultado.next()) {
                encontrouResultado = true;
                comboBox.addItem(resultado.getString("AUT_NOME_AUTOR"));
            }

            if (!encontrouResultado) {
                comboBox.addItem("Nada encontrado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela de autores: " + ex);
        }
    }

}
