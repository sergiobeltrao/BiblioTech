package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;
import com.mycompany.bibliotech.model.bean.Avaliacao;
import com.mycompany.bibliotech.model.bean.ContagemAvaliacoesLivro;
import com.mycompany.bibliotech.model.bean.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class AvaliacaoDAO {

    public void create(Avaliacao av, String nomeDoLivro, String nomeDoUsuario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            // Pega o ID_LIVRO que está sendo cadastrado
            String consultaSQL = "SELECT ID_LIVRO FROM LIVRO WHERE LIV_NOME_LIVRO = ?";
            stmt = con.prepareStatement(consultaSQL);
            stmt.setString(1, nomeDoLivro);
            ResultSet resultado = stmt.executeQuery();
            int idLivro = 0;

            // Verifica se há resultados
            if (resultado.next()) {
                idLivro = resultado.getInt("ID_LIVRO");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao consultar ID_LIVRO para tabela de avaliações");
            }

            // Pega o usuário que está avaliando
            String idDoUsuarioQueAvaliou = "SELECT USE_ID FROM USUARIO WHERE USE_NICK = ?";
            stmt = con.prepareStatement(idDoUsuarioQueAvaliou);
            stmt.setString(1, nomeDoUsuario);
            ResultSet resultadoUser = stmt.executeQuery();
            int idDoUser = 0;

            if (resultadoUser.next()) {
                idDoUser = resultadoUser.getInt("USE_ID");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao consultar USE_ID para tabela de avaliações");
            }

            stmt = con.prepareStatement("INSERT INTO AVALIACAO (AVA_ID_USUARIO, AVA_FK_LIVRO, AVA_USUARIO, AVA_COMENTARIO, AVA_DATA_AVALIACAO) VALUES(?, ?, ?, ?, NOW())");

            stmt.setInt(1, idDoUser);
            stmt.setInt(2, idLivro);
            stmt.setString(3, av.getAvaliacaoDoUsuario());
            stmt.setString(4, av.getComentarioAvaliacao());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro nos dados da avaliação: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    // Para o retorno dos dados do banco na jTable
    public List<Avaliacao> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Avaliacao> avaliacoes = new ArrayList<>();

        try {
            stmt = con.prepareCall("SELECT L.LIV_NOME_LIVRO, A.AVA_USUARIO, A.AVA_COMENTARIO FROM AVALIACAO A JOIN LIVRO L ON A.AVA_FK_LIVRO = L.ID_LIVRO");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Avaliacao avaliacao = new Avaliacao();
                Livro livro = new Livro();

                avaliacao.setAvaliacaoDoUsuario(rs.getString("AVA_USUARIO"));
                avaliacao.setComentarioAvaliacao(rs.getString("AVA_COMENTARIO"));
                livro.setTitulo(rs.getString("LIV_NOME_LIVRO"));

                avaliacao.setLivro(livro);
                avaliacoes.add(avaliacao);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return avaliacoes;
    }

    public void rank(Avaliacao nota, String buscaLivro, String verificaUsuario, String rank, String comentario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            // Pega o ID_LIVRO que está sendo cadastrado
            String consultaSQL = "SELECT ID_LIVRO FROM LIVRO WHERE LIV_NOME_LIVRO = ?";
            stmt = con.prepareStatement(consultaSQL);
            stmt.setString(1, buscaLivro);
            ResultSet resultado = stmt.executeQuery();
            int idLivro = 0;

            // Verifica se há resultados
            if (resultado.next()) {
                idLivro = resultado.getInt("ID_LIVRO");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao consultar ID_LIVRO para tabela de avaliações");
            }

            // Pega o usuário que está avaliando
            String idDoUsuarioQueAvaliou = "SELECT USE_ID FROM USUARIO WHERE USE_NICK = ?";
            stmt = con.prepareStatement(idDoUsuarioQueAvaliou);
            stmt.setString(1, verificaUsuario);
            ResultSet resultadoUser = stmt.executeQuery();
            int idDoUser = 0;

            if (resultadoUser.next()) {
                idDoUser = resultadoUser.getInt("USE_ID");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao consultar USE_ID para tabela de avaliações");
            }

            // Faz o insert na tabela AVALIACAO
            stmt = con.prepareStatement("INSERT INTO AVALIACAO (AVA_ID_USUARIO, AVA_FK_LIVRO, AVA_USUARIO, AVA_COMENTARIO, AVA_DATA_AVALIACAO) VALUES(?, ?, ?, ?, NOW())");

            // Implementar captura do USE_ID com base no usuário logado para preencher o AVA_FK_USUARIO.
            stmt.setInt(1, idDoUser);
            stmt.setInt(2, idLivro);
            stmt.setString(3, rank);
            stmt.setString(4, comentario);

            JOptionPane.showMessageDialog(null, "Avaliação cadastrada com sucesso");

            // Para preparar o SQL e executar
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro nos dados da avaliação: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    // Para o retorno dos dados do banco na jTable
    public static List<ContagemAvaliacoesLivro> numeroDeNotasPorLivro() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ContagemAvaliacoesLivro> contagens = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT L.LIV_NOME_LIVRO, COUNT(*) AS QUANTIDADE_DE_AVALIACOES FROM AVALIACAO A JOIN LIVRO L ON A.AVA_FK_LIVRO = L.ID_LIVRO GROUP BY L.LIV_NOME_LIVRO ORDER BY QUANTIDADE_DE_AVALIACOES DESC");
            rs = stmt.executeQuery();

            while (rs.next()) {
                ContagemAvaliacoesLivro contagem = new ContagemAvaliacoesLivro();
                contagem.setNomeLivro(rs.getString("LIV_NOME_LIVRO"));
                contagem.setQuantidadeAvaliacoes(rs.getInt("QUANTIDADE_DE_AVALIACOES"));
                contagens.add(contagem);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return contagens;
    }

    public static void selectUsuarioQueAvaliouLivro(JComboBox<String> comboBox, int idLivro) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT U.USE_NICK FROM AVALIACAO A JOIN USUARIO U ON A.AVA_ID_USUARIO = U.USE_ID WHERE A.AVA_FK_LIVRO = ?");

            stmt.setInt(1, idLivro);

            ResultSet resultado = stmt.executeQuery();

            comboBox.removeAllItems();
            boolean encontrouResultado = false;

            while (resultado.next()) {
                encontrouResultado = true;
                String nomePesquisado = resultado.getString("USE_NICK");
                comboBox.addItem(nomePesquisado);
            }

            if (!encontrouResultado) {
                comboBox.addItem("Nada encontrado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela de avaliação: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public Avaliacao selectGeralComId(String idLivro, String idUsuario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Avaliacao avaliacao = new Avaliacao();

        try {
            stmt = con.prepareStatement("SELECT * FROM AVALIACAO WHERE AVA_FK_LIVRO = ? AND AVA_ID_USUARIO = ?");
            stmt.setString(1, idLivro);
            stmt.setString(2, idUsuario);

            rs = stmt.executeQuery();

            if (rs.next()) {
                avaliacao.setId(rs.getInt("AVA_ID_USUARIO"));
                avaliacao.setLivroAvaliado(rs.getInt("AVA_FK_LIVRO"));
                avaliacao.setAvaliacaoDoUsuario(rs.getString("AVA_USUARIO"));
                avaliacao.setComentarioAvaliacao(rs.getString("AVA_COMENTARIO"));
                avaliacao.setDataDeAvaliacao(rs.getString("AVA_DATA_AVALIACAO"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na consulta: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return avaliacao;
    }

    public boolean atualizaComentarioAvaliacao(String comentario, String idLivro, String idUsuario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "UPDATE AVALIACAO SET AVA_COMENTARIO = ? WHERE AVA_FK_LIVRO = ? AND AVA_ID_USUARIO = ?";

            stmt = con.prepareStatement(sql);

            stmt.setString(1, comentario);
            stmt.setString(2, idLivro);
            stmt.setString(3, idUsuario);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Retorna true se a atualização for bem-sucedida

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no update: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }

    public List<Avaliacao> avaliacoesDoUsuario(int idDoUsuario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Avaliacao> avaliacoes = new ArrayList<>();

        try {
            stmt = con.prepareCall("SELECT LIVRO.ID_LIVRO, LIVRO.LIV_NOME_LIVRO, AVALIACAO.AVA_USUARIO, AVALIACAO.AVA_COMENTARIO FROM AVALIACAO INNER JOIN LIVRO ON AVALIACAO.AVA_FK_LIVRO = LIVRO.ID_LIVRO WHERE AVALIACAO.AVA_ID_USUARIO = ?");
            stmt.setInt(1, idDoUsuario);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Livro livro = new Livro();
                Avaliacao avaliacao = new Avaliacao();
                livro.setId(rs.getInt("ID_LIVRO"));
                livro.setTitulo(rs.getString("LIV_NOME_LIVRO"));
                avaliacao.setAvaliacaoDoUsuario(rs.getString("AVA_USUARIO"));
                avaliacao.setComentarioAvaliacao(rs.getString("AVA_COMENTARIO"));
                avaliacao.setLivro(livro); // Associando a avaliação ao livro correspondente

                avaliacoes.add(avaliacao);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return avaliacoes;
    }

    public boolean deletarAvaliacao(int idUsuario, double avaliacao, String comentario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            String sql = "DELETE FROM AVALIACAO WHERE AVA_ID_USUARIO = ? AND AVA_USUARIO = ? AND AVA_COMENTARIO = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            stmt.setDouble(2, avaliacao);
            stmt.setString(3, comentario);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean atualizarAvaliacao(int idUsuario, String novoValorDaNota, String novoComentario, String idLivro) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE AVALIACAO SET AVA_USUARIO = ?, AVA_COMENTARIO = ? WHERE AVA_FK_LIVRO = ? AND AVA_ID_USUARIO = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, novoValorDaNota);
            stmt.setString(2, novoComentario);
            stmt.setString(3, idLivro);
            stmt.setInt(4, idUsuario);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
