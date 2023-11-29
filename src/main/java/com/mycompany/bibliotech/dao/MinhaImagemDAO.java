package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;
import com.mycompany.bibliotech.model.bean.MinhaImagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class MinhaImagemDAO {

    // NO BANCO EU CRIEI UMA TABELA DE TESTES. MEU CÓDIGO SQL...
    // USE BIBLIOTECH;
    // CREATE TABLE TB_TESTE(ID INT PRIMARY KEY AUTO_INCREMENT, NOME VARCHAR(50), IMAGEM LONGBLOB);
    public void inserirImagem(MinhaImagem imagem) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = "INSERT INTO TB_TESTE (NOME, IMAGEM) VALUES (?, ?)";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, imagem.getNome());
            stmt.setBytes(2, imagem.getImagem());
            stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(MinhaImagem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluirImagem(MinhaImagem imagem) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = "DELETE FROM TB_TESTE WHERE ID = ?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, imagem.getId());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MinhaImagem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterarImagem(MinhaImagem imagem) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = "UPDATE TB_TESTE SET NOME = ?, IMAGEM = ? WHERE ID = ?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, imagem.getNome());
            stmt.setBytes(2, imagem.getImagem());
            stmt.setInt(3, imagem.getId());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MinhaImagem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void listarImagens(JComboBox<String> comboBox) {
        try {
            Connection con = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_TESTE";
            PreparedStatement comando = con.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();

            comboBox.removeAllItems();
            comboBox.addItem("Selecione");

            while (resultado.next()) {
                comboBox.addItem(String.valueOf(resultado.getInt("ID")) + " - " + resultado.getString("NOME"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela de imagem: " + ex);
        }
    }

    public byte[] buscarImagemPorId(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT IMAGEM FROM TB_TESTE WHERE ID = ?";
        byte[] imagemBytes = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                imagemBytes = rs.getBytes("IMAGEM");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MinhaImagemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return imagemBytes;
    }
    public byte[] exibirDisplay(String id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT LIV_IMAGEM FROM LIVRO WHERE ID_LIVRO = ?";
        byte[] exibirImagem = null;

        try {
            int idInt = Integer.parseInt(id);
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idInt);
            rs = stmt.executeQuery();

            if (rs.next()) {
                exibirImagem = rs.getBytes("LIV_IMAGEM");
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao exibir a imagem:DAO " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return exibirImagem;
    }

}
