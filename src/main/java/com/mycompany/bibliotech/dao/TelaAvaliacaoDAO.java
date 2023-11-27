package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;
import com.mycompany.bibliotech.model.bean.Avaliacao;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
            comboBox.addItem("");

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
            comboBox.addItem("");

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

            stmt.setString(1, buscaAlfabetica + "%");

            ResultSet resultado = stmt.executeQuery();

            comboBox.removeAllItems();
            comboBox.addItem("");

            while (resultado.next()) {
                comboBox.addItem(resultado.getString("LIV_NOME_LIVRO"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao bucar livro cabaço " + ex);
        }
    }

    public static void buscaCategorias(JComboBox<String> comboBox, String buscaCategorias) {

        try {

            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;

            stmt = con.prepareStatement("SELECT LIV_NOME_LIVRO FROM LIVRO WHERE LIV_CATEGORIA = ?");

            stmt.setString(1, buscaCategorias);

            ResultSet resultado = stmt.executeQuery();

            comboBox.removeAllItems();
            comboBox.addItem("");

            while (resultado.next()) {
                comboBox.addItem(resultado.getString("LIV_NOME_LIVRO"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Erro ao buscar livro " + ex);
        }

    }

    public static void buscaSubCategorias(JComboBox<String> comboBox, String buscaSubCategorias) {

        try {

            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;

            stmt = con.prepareStatement("SELECT LIV_NOME_LIVRO FROM LIVRO WHERE LIV_SUBCATEGORIA = ?");

            stmt.setString(1, buscaSubCategorias);

            ResultSet resultado = stmt.executeQuery();

            comboBox.removeAllItems();
            comboBox.addItem("");

            while (resultado.next()) {
                comboBox.addItem(resultado.getString("LIV_NOME_LIVRO"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Erro ao buscar livro " + ex);
        }

    }

    public Avaliacao find(String pesquisar, JLabel imagemLivro) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            if (con == null) {
                throw new SQLException("Não foi possível conectar ao banco de dados.");
            }
            // Pega o ID_LIVRO que está sendo cadastrado
            String consultaSQL = "SELECT ID_LIVRO FROM LIVRO WHERE LIV_NOME_LIVRO = ?";
            stmt = con.prepareStatement(consultaSQL);
            stmt.setString(1, pesquisar);
            ResultSet resultado = stmt.executeQuery();
            int livroId = 0;

            // Verifica se há resultados
            if (resultado.next()) {
                livroId = resultado.getInt("ID_LIVRO");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao consultar ID_LIVRO para tabela de livro");
            }

            String sql = "SELECT L.LIV_PAGINA, L.LIV_EDITORA, L.LIV_ISBN, L.LIV_ANO, L.LIV_IMAGEM, L.LIV_IDIOMA, A.AUT_NOME_AUTOR,\n"
                    + "ROUND(AVG(AV.AVA_USUARIO), 1) AS MEDIA_NOTA FROM LIVRO L JOIN LIVRO_AUTOR LA ON L.ID_LIVRO = LA.LIVRO_CHAVE\n"
                    + "JOIN AUTOR A ON LA.LIVRO_AUTOR = A.ID_AUTOR LEFT JOIN AVALIACAO AV ON L.ID_LIVRO = AV.AVA_FK_LIVRO\n"
                    + "WHERE L.ID_LIVRO = ? GROUP BY L.ID_LIVRO, A.AUT_NOME_AUTOR";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, livroId);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Avaliacao pes = new Avaliacao();
                pes.setTxtPaginas(rs.getInt("LIV_PAGINA"));
                pes.setTxtEditora(rs.getString("LIV_EDITORA"));
                pes.setTxtIsbn(rs.getString("LIV_ISBN"));
                pes.setTxtAno(rs.getInt("LIV_ANO"));
                pes.setTxtIdioma(rs.getString("LIV_IDIOMA"));
                pes.setTxtNomeAutor(rs.getString("AUT_NOME_AUTOR"));
                pes.setTxtNotaMax("Nota: " + rs.getString("MEDIA_NOTA"));

                 Blob blob = (Blob) rs.getBlob("LIV_IMAGEM");
                byte[] img = blob.getBytes(1, (int) blob.length());
                try {
                    BufferedImage imagem = ImageIO.read(new ByteArrayInputStream(img));
                    ImageIcon icone = new ImageIcon(imagem);
                    Icon foto = new ImageIcon(icone.getImage().getScaledInstance(imagemLivro.getWidth(), imagemLivro.getHeight(), Image.SCALE_SMOOTH));
                    imagemLivro.setIcon(foto);

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao buscar imagem. " + e.getMessage());
                }
                return pes;

            } else {
                System.out.println(pesquisar + " erro dao find");
                JOptionPane.showMessageDialog(null, "erro no dao findDAO");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no catch do findDAO: " + ex.getMessage());
            ex.printStackTrace();

        } finally {
            if (rs != null) {
                rs.close();
            }
            ConnectionFactory.closeConnection(con, stmt);
        }
        return null;
    }
}
