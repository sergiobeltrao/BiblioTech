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

    public void cadastraAutor(Autor autor) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("INSERT INTO AUTOR (ID_AUTOR, AUT_NOME_AUTOR, AUT_NACIONALIDADE, AUT_SEXO)  VALUES(NULL, ?, ?, ?)");

            stmt.setString(1, autor.getNome());
            stmt.setString(2, autor.getNacionalidade());
            stmt.setString(3, autor.getSexo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Autor cadastrado. Use o mecanismo de pesquisa para selecionar.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no cadastro do autor: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Autor> leTabelaAutoresCompleta() {
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

    public static void listaNacionalidadesParaAutores(JComboBox<String> comboBox) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM NACIONALIDADE");
            PreparedStatement comando = stmt;
            ResultSet resultado = comando.executeQuery();

            comboBox.removeAllItems();
            comboBox.addItem("Não Informada");

            while (resultado.next()) {
                comboBox.addItem(resultado.getString("NAC_NOME"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela de nacionalidades: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public static void mostraNomeDoAutor(JComboBox<String> comboBox, String busca) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
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
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public static void mostraNomePaisESexoDoAutor(JComboBox<String> comboBox, String busca) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT CONCAT(AUT_NOME_AUTOR, ', ', SUBSTRING_INDEX(AUT_NACIONALIDADE, ' - ', 1)) AS PESQUISA_AUTOR FROM AUTOR WHERE AUT_NOME_AUTOR LIKE ?");

            stmt.setString(1, "%" + busca + "%");

            ResultSet resultado = stmt.executeQuery();

            comboBox.removeAllItems();
            boolean encontrouResultado = false;

            while (resultado.next()) {
                encontrouResultado = true;
                String nomePesquisado = resultado.getString("PESQUISA_AUTOR");
                comboBox.addItem(nomePesquisado);
            }

            if (!encontrouResultado) {
                comboBox.addItem("Nada encontrado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela de autores: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean verificaSeAutorJaEstaCadastrado(Autor autor) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet resultado = null;
        boolean encontrouResultado = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM AUTOR WHERE AUT_NOME_AUTOR = ? AND AUT_NACIONALIDADE = ? AND AUT_SEXO = ?");

            stmt.setString(1, autor.getNome());
            stmt.setString(2, autor.getNacionalidade());
            stmt.setString(3, autor.getSexo());

            resultado = stmt.executeQuery();

            if (resultado.next()) {
                encontrouResultado = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na verificação do autor: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, resultado);
        }
        return encontrouResultado;
    }

    // Para o retorno dos dados do banco na jTable
    public List<Autor> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Autor> autores = new ArrayList<>();

        try {
            stmt = con.prepareCall("SELECT AUT_NOME_AUTOR, AUT_NACIONALIDADE, AUT_SEXO FROM AUTOR");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Autor autor = new Autor();

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

    public static void selectPesquisaAutorNome(JComboBox<String> comboBox, String busca) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT CONCAT('ID ', ID_AUTOR, ' - ', AUT_NOME_AUTOR) AS ID_E_NOME_AUTOR FROM AUTOR WHERE AUT_NOME_AUTOR LIKE ?");

            stmt.setString(1, "%" + busca + "%");

            ResultSet resultado = stmt.executeQuery();

            comboBox.removeAllItems();
            boolean encontrouResultado = false;

            while (resultado.next()) {
                encontrouResultado = true;
                String nomePesquisado = resultado.getString("ID_E_NOME_AUTOR");
                comboBox.addItem(nomePesquisado);
            }

            if (!encontrouResultado) {
                 JOptionPane.showMessageDialog(null, "Nada encontrado");
                selectGeralAutorNome(comboBox);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela de autores: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public static void selectGeralAutorNome(JComboBox<String> comboBox) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT CONCAT('ID ', ID_AUTOR, ' - ', AUT_NOME_AUTOR) AS ID_E_NOME_AUTOR FROM AUTOR");

            ResultSet resultado = stmt.executeQuery();

            comboBox.removeAllItems();
            boolean encontrouResultado = false;

            comboBox.addItem("Selecione");
            while (resultado.next()) {
                encontrouResultado = true;
                String nomePesquisado = resultado.getString("ID_E_NOME_AUTOR");
                comboBox.addItem(nomePesquisado);
            }

            if (!encontrouResultado) {
                comboBox.addItem("Nada encontrado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela de autores: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public String selectIdDoAutor(String busca) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String resultado = null;

        try {
            stmt = con.prepareStatement("SELECT ID_AUTOR FROM AUTOR WHERE AUT_NOME_AUTOR LIKE ?");
            stmt.setString(1, "%" + busca + "%");

            rs = stmt.executeQuery();

            if (rs.next()) {
                resultado = rs.getString("ID_AUTOR");
            } else {
                // Para evitar um NullPointerException caso o select não retorne nada.
                resultado = "";
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na consulta: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return resultado;
    }

    public Autor selectGeralComId(int idAutor) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Autor autor = new Autor();

        try {
            stmt = con.prepareStatement("SELECT AUT_NOME_AUTOR, AUT_NACIONALIDADE, AUT_SEXO FROM AUTOR WHERE ID_AUTOR = ?");
            stmt.setInt(1, idAutor);

            rs = stmt.executeQuery();

            if (rs.next()) {
                autor.setNome(rs.getString("AUT_NOME_AUTOR"));
                autor.setNacionalidade(rs.getString("AUT_NACIONALIDADE"));
                autor.setSexo(rs.getString("AUT_SEXO"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na consulta: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return autor;
    }

    public boolean atualizaInfoAutor(int idAutor, Autor autor) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "UPDATE AUTOR SET AUT_NOME_AUTOR = ?, AUT_NACIONALIDADE = ?, AUT_SEXO = ? WHERE ID_AUTOR = ?";

            stmt = con.prepareStatement(sql);

            stmt.setString(1, autor.getNome());
            stmt.setString(2, autor.getNacionalidade());
            stmt.setString(3, autor.getSexo());
            stmt.setInt(4, idAutor);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Retorna true se a atualização for bem-sucedida

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no update: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
}
