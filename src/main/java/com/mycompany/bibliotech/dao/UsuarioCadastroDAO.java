package com.mycompany.bibliotech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import com.mycompany.bibliotech.connection.ConnectionFactory;
import com.mycompany.bibliotech.telas.CadastroUsuario;

public class UsuarioCadastroDAO {

  /*  private int codigo;
    private String nick;
    private String senha;
    
    private String nome;
    private int datanasc;
    private String email;
    private String sexo;
    private String fone;

    public UsuarioCadastroDAO(String nome) {
        this.nome = nome;
    }

    public UsuarioCadastroDAO(String nick, String senha, String nome, String email, String sexo, String fone) {
        this.nick = nick;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
        this.fone = fone;
    }

    public UsuarioCadastroDAO() {
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNick() {
        return nick;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public int getDatanasc() {
        return datanasc;
    }

    public String getEmail() {
        return email;
    }

    public String getSexo() {
        return sexo;
    }

    public String getFone() {
        return fone;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDatanasc(int datanasc) {
        this.datanasc = datanasc;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    @Override
    public String toString() {
        return "UsuarioCadastroDAO{" + "codigo=" + codigo + ", nick=" + nick + ", senha=" + senha + ", nome=" + nome + ", datanasc=" + datanasc + ", email=" + email + ", sexo=" + sexo + ", fone=" + fone + '}';
    } */
/*
    public boolean cadNick() {
        String sql = "INSERT INTO USUARIO (USE_NICK) VALUES (?)";
        try (Connection c = ConnectionFactory.getConnection()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nick);
            ps.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    
        public boolean cadSenha() {
        String sql = "INSERT INTO USUARIO (USE_SENHA) VALUES (?)";
        try (Connection c = ConnectionFactory.getConnection()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nick);
            ps.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    
    public boolean cadType() {
        String sql = "INSERT INTO USUARIO (USE_TYPE) VALUES (?)";
        try (Connection c = ConnectionFactory.getConnection()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nick);
            ps.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    
    public boolean cadNome() {
        String sql = "INSERT INTO USUARIO (USE_Nome) VALUES (?)";
        try (Connection c = ConnectionFactory.getConnection()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nick);
            ps.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    
    public boolean cadSobrenome() {
        String sql = "INSERT INTO USUARIO (USE_SOBRENOME) VALUES (?)";
        try (Connection c = ConnectionFactory.getConnection()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nick);
            ps.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    
    public boolean cadDataNasc() {
        String sql = "INSERT INTO USUARIO (USE_DATANASC) VALUES (?)";
        try (Connection c = ConnectionFactory.getConnection()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nick);
            ps.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    
    public boolean cadEmail() {
        String sql = "INSERT INTO USUARIO (USE_EMAIL) VALUES (?)";
        try (Connection c = ConnectionFactory.getConnection()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nick);
            ps.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    
    public boolean cadCria() {
        String sql = "INSERT INTO USUARIO (USE_CRIA) VALUES (?)";
        try (Connection c = ConnectionFactory.getConnection()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nick);
            ps.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    
    public boolean cadSexo() {
        String sql = "INSERT INTO USUARIO (USE_SEXO) VALUES (?)";
        try (Connection c = ConnectionFactory.getConnection()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nick);
            ps.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    
    public boolean cadCPF() {
        String sql = "INSERT INTO USUARIO (USE_CPF) VALUES (?)";
        try (Connection c = ConnectionFactory.getConnection()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nick);
            ps.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    
    public boolean cadFone() {
        String sql = "INSERT INTO USUARIO (USE_TELEFONE) VALUES (?)";
        try (Connection c = ConnectionFactory.getConnection()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nick);
            ps.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    */
/*public boolean cadastrar() {
    CadastroUsuario cad = new CadastroUsuario();
    
    String sql = "INSERT INTO USUARIO (USE_NICK, USE_SENHA, USE_TYPE, USE_NOME, USE_SOBRENOME, USE_DATANASC, USE_EMAIL, USE_CRIA, USE_SEXO) " +
                 "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, NOW(), ?)";
    
    try (Connection c = ConnectionFactory.getConnection();
         PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, cad.nome);
            ps.setString(2, sobrenome);
            ps.setString(3, cpf);
            ps.setString(4, email);
            ps.setString(5, senha);
            ps.setString(6, nick);
            ps.setString(7, sexo);
            ps.setString(8, dataNascimento);
            ps.setString(9, endereco);
            ps.setString(10, bairro);
            ps.setString(11, cidade);
            ps.setString(12, uf);
            ps.setString(13, cep);
            ps.setString(14, telefone);
            ps.setString(15, cargo);

int linhasAfetadas = preparedStatement.executeUpdate();

            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    } */
        // ... outros métodos da classe ...

    public boolean cadastrarUsuario(String nome, String sobrenome, String cpf, String email, String senha, String nickname, String sexo, String dataNascimento, String endereco, String bairro, String cidade, String uf, String cep, String telefone, String cargo) {
     
            String sql = "INSERT INTO USUARIO (USE_NOME, USE_SOBRENOME, USE_CPF, USE_EMAIL, USE_SENHA, USE_NICK, USE_SEXO, USE_DATANASC, USE_TYPE, USE_CRIA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";
            
        try (Connection con = ConnectionFactory.getConnection()) {
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, nome);
            stmt.setString(2, sobrenome);
            stmt.setString(3, cpf);
            stmt.setString(4, email);
            stmt.setString(5, senha);
            stmt.setString(6, nickname);
            stmt.setString(7, sexo);
            stmt.setString(8, dataNascimento);
            stmt.setString(9, cargo);
     /*       stmt.setString(9, endereco);
            stmt.setString(10, bairro);
            stmt.setString(11, cidade);
            stmt.setString(12, uf);
            stmt.setString(13, cep);
            stmt.setString(14, telefone);
            stmt.setString(15, cargo); */
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } 
    }
}
