package com.mycompany.bibliotech.dao;

import com.mycompany.bibliotech.connection.ConnectionFactory;
import com.mycompany.bibliotech.model.bean.Editora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EditoraDAO {

    public void create(Editora ed) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("INSERT INTO EDITORA (ID_EDITORA, EDT_NOME_EDITORA) VALUES(NULL, ?)");

            stmt.setString(1, ed.getNome());

            // Para preparar o SQL e executar
            stmt.executeUpdate();

            // Desativado por enquanto para evitar duplicidade de mensagens
            // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro nos dados da editora: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Editora> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Editora> editoras = new ArrayList<>();

        try {
            stmt = con.prepareCall("SELECT * FROM EDITORA");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Editora editora = new Editora();

                editora.setId(rs.getInt("ID_EDITORA"));
                editora.setNome(rs.getString("EDT_NOME_EDITORA"));

                editoras.add(editora);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler a tabela: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return editoras;
    }
}
