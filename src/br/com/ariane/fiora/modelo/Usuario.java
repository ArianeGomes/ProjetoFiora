package br.com.ariane.fiora.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Usuario {
    public Connection con;
    private String nome, funcao, login;
    private int senha;
    
    public Usuario() {
        con = new Conexao().criarConexao();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }
    
    private void liberarRecursos(Connection c, PreparedStatement ps) {
        if (c != null) {
            try {
                c.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    private void liberarRecursos(Connection c, PreparedStatement ps, ResultSet rs) {
        if (c != null) {
            try {
                c.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    public void incluirUsuario(Usuario u) {
        PreparedStatement ps = null;
        
        try {
            ps = this.con.prepareStatement("INSERT INTO usuario (login, senha, funcao, nome) "
                                         + "VALUES (?, ?, ?, ?)");
            ps.setString(1, u.getLogin());
            ps.setInt(2, u.getSenha());
            ps.setString(3, u.getFuncao());
            ps.setString(4, u.getNome());
            
            ps.executeUpdate();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            liberarRecursos(con, ps);
        }
    }
    
    public void alterarUsuario(Usuario u) {
        PreparedStatement ps = null;
        
        try {
            ps = this.con.prepareStatement("UPDATE usuario "
                                         + "SET senha = ?, funcao = ?, nome = ? "
                                         + "WHERE login = ?");
            ps.setInt(1, u.getSenha());
            ps.setString(2, u.getFuncao());
            ps.setString(3, u.getNome());
            ps.setString(4, u.getLogin());
            
            ps.executeUpdate();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }  finally {
            liberarRecursos(con, ps);
        }
    }
    
    public void excluirUsuario(Usuario u) {
        PreparedStatement ps = null;
        
        try {
            ps = this.con.prepareStatement("DELETE FROM usuario "
                                         + "WHERE login = ?");
            ps.setString(1, u.getLogin());
            
            ps.executeUpdate();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            liberarRecursos(con, ps);
        }
    }
    
    public ArrayList<Usuario> listarUsuario() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Usuario> usuarios = null;
        
        try {
            ps = this.con.prepareStatement("SELECT * FROM usuario");
            rs = ps.executeQuery();
            
            usuarios = new ArrayList<>();
            
            while (rs.next()) {
                Usuario u = new Usuario();
                
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getInt("senha"));
                u.setNome(rs.getString("nome"));
                u.setFuncao(rs.getString("funcao"));
                
                usuarios.add(u);
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            liberarRecursos(con, ps, rs);
        }
        
        return usuarios;
    }
    
    public Usuario buscarUsuario(String login) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario u = null;
        
        try {
            ps = this.con.prepareStatement("SELECT * FROM usuario "
                                         + "WHERE login LIKE ?");
            ps.setString(1, login);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                u = new Usuario();
                
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getInt("senha"));
                u.setFuncao(rs.getString("funcao"));
                u.setNome(rs.getString("nome"));
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            liberarRecursos(con, ps, rs);
        }
        
        return u;
    }
}
