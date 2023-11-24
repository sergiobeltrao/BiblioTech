package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class TelaAvaliacaoDAO {

    // Mostrar todos os livros. Sem filtrar.
    public static void listaTituloDosLivros(JComboBox<String> comboBox) {
        try {
            Connection con = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM LIVRO";
            PreparedStatement comando = con.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();

            comboBox.removeAllItems();
            comboBox.addItem("Resultados...");

            while (resultado.next()) {
                comboBox.addItem(resultado.getString("LIV_NOME_LIVRO"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela de livros: " + ex);
        }
    }

    // Mostra os livros com base no que foi digitado.
    public static void listaFiltrada(JComboBox<String> comboBox, String buscaTitulo) {

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;

            stmt = con.prepareStatement("SELECT LIV_NOME_LIVRO FROM LIVRO WHERE LIV_NOME_LIVRO LIKE ?");

            // Tive que mandar os % do comando SQL pra cá. Se usar direto no prepareStatement vai
            // dar o erro "parameter index out of range (1 number of parameters which is 0)"
            
            stmt.setString(1, "%" + buscaTitulo + "%");

            //PreparedStatement comando = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            comboBox.removeAllItems();
            comboBox.addItem("Resultados...");

            while (resultado.next()) {
                comboBox.addItem(resultado.getString("LIV_NOME_LIVRO"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela de livros: " + ex);
        }
    }
    public static void listaAlfabeto(JComboBox<String> comboBox, String buscaAlfabetica) {

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;

            stmt = con.prepareStatement("SELECT LIV_NOME_LIVRO FROM LIVRO WHERE LIV_NOME_LIVRO LIKE ?");

            // Tive que mandar os % do comando SQL pra cá. Se usar direto no prepareStatement vai
            // dar o erro "parameter index out of range (1 number of parameters which is 0)"
            
            stmt.setString(1,   buscaAlfabetica + "%" );

            //PreparedStatement comando = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            comboBox.removeAllItems();
            comboBox.addItem("Resultados...");

            while (resultado.next()) {
                comboBox.addItem(resultado.getString("LIV_NOME_LIVRO"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao bucar livro cabaço " + ex);
        }
    }
    
    public static void buscaCategorias (JComboBox<String> comboBox, String buscaCategorias) {
    
        try {
            
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            stmt = con.prepareStatement("SELECT LIV_NOME_LIVRO FROM LIVRO WHERE LIV_CATEGORIA = ?");
            
            stmt.setString(1, buscaCategorias);
            
            ResultSet resultado = stmt.executeQuery();
            
            comboBox.removeAllItems();
            comboBox.addItem("Resultados");
            
            
            while (resultado.next()) {
                comboBox.addItem(resultado.getString("LIV_NOME_LIVRO"));
            }             
                    
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, " Erro ao buscar livro " + ex);            
        }
        
    }
    
    public static void buscaSubCategorias (JComboBox<String> comboBox, String buscaSubCategorias) {
    
        try {
            
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            stmt = con.prepareStatement("SELECT LIV_NOME_LIVRO FROM LIVRO WHERE LIV_SUBCATEGORIA = ?");
            
            stmt.setString(1, buscaSubCategorias);
            
            ResultSet resultado = stmt.executeQuery();
            
            comboBox.removeAllItems();
            comboBox.addItem("Resultados");
            
            
            while (resultado.next()) {
                comboBox.addItem(resultado.getString("LIV_NOME_LIVRO"));
            }               
                    
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, " Erro ao buscar livro " + ex);            
        }
        
    }
}
