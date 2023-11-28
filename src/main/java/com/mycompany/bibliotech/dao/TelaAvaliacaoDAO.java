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

    private static final String DIRETORIO_IMAGENS = ".\\src\\main\\resources\\imagem\\OSegredodasEstrelas.jpeg";

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
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement stmtConsultaId = con.prepareStatement("SELECT ID_LIVRO FROM LIVRO WHERE LIV_NOME_LIVRO = ?"); PreparedStatement stmtLivro = con.prepareStatement("SELECT L.LIV_PAGINA, L.LIV_EDITORA, L.LIV_ISBN, L.LIV_ANO, L.LIV_IDIOMA, A.AUT_NOME_AUTOR, ROUND(AVG(AV.AVA_USUARIO), 1) AS MEDIA_NOTA, L.LIV_IMAGEM FROM LIVRO L JOIN LIVRO_AUTOR LA ON L.ID_LIVRO = LA.LIVRO_CHAVE JOIN AUTOR A ON LA.LIVRO_AUTOR = A.ID_AUTOR LEFT JOIN AVALIACAO AV ON L.ID_LIVRO = AV.AVA_FK_LIVRO WHERE L.ID_LIVRO = ? GROUP BY L.ID_LIVRO, A.AUT_NOME_AUTOR");) {
            stmtConsultaId.setString(1, pesquisar);
            try (ResultSet resultado = stmtConsultaId.executeQuery()) {
                int livroId = 0;

                if (resultado.next()) {
                    livroId = resultado.getInt("ID_LIVRO");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao consultar ID_LIVRO para tabela de livro");
                }

                stmtLivro.setInt(1, livroId);
                try (ResultSet rs = stmtLivro.executeQuery()) {
                    if (rs.next()) {
                        Avaliacao pes = new Avaliacao();
                        pes.setTxtPaginas(rs.getInt("LIV_PAGINA"));
                        pes.setTxtEditora(rs.getString("LIV_EDITORA"));
                        pes.setTxtIsbn(rs.getString("LIV_ISBN"));
                        pes.setTxtAno(rs.getInt("LIV_ANO"));
                        pes.setTxtIdioma(rs.getString("LIV_IDIOMA"));
                        pes.setTxtNomeAutor(rs.getString("AUT_NOME_AUTOR"));
                        pes.setTxtNotaMax("Nota: " + rs.getString("MEDIA_NOTA"));
                        byte[] imagemBytes = rs.getBytes("LIV_IMAGEM");
                        pes.setImagemLivro(new ImageIcon(imagemBytes));

                        try {
                            // Obtém o ImageIcon da avaliação
                            ImageIcon imagemIcon = pes.getImagemLivro();

                            if (imagemIcon != null) {
                                // Obtém a imagem do ImageIcon
                                Image imagem = imagemIcon.getImage();

                                // Redimensiona a imagem conforme necessário (ajuste os valores de largura e altura)
                                Image imagemRedimensionada = imagem.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

                                // Cria um novo ImageIcon com a imagem redimensionada
                                ImageIcon imagemIconRedimensionada = new ImageIcon(imagemRedimensionada);

                                // Define o ícone na JLabel (ou onde quer que você esteja usando isso)
                                imagemLivro.setIcon(imagemIconRedimensionada);
                            } else {
                                JOptionPane.showMessageDialog(null, "Imagem não encontrada. ImageIcon é nulo.");
                            }
                        } catch (Exception e) {
                            e.printStackTrace(); // Isso imprimirá a pilha de exceção completa no console
                            JOptionPane.showMessageDialog(null, "Erro ao buscar/imagem. " + e.getMessage());
                        }

                        return pes;
                    } else {
                        System.out.println(pesquisar + " erro dao find");
                        JOptionPane.showMessageDialog(null, "erro no dao findDAO");
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no catch do findDAO: " + ex.getMessage());
            throw ex; // Lança a exceção para ser tratada em um nível superior, se necessário
        }
        return null;
    }

}
