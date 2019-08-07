package br.com.ariane.fiora.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Faixa {
    public Connection con;
    private int codAlbum, numeroFaixa;
    private String nomeFaixa;
    
    public Faixa() {
        con = new Conexao().criarConexao();
    }

    public int getCodAlbum() {
        return codAlbum;
    }

    public void setCodAlbum(int codAlbum) {
        this.codAlbum = codAlbum;
    }

    public int getNumeroFaixa() {
        return numeroFaixa;
    }

    public void setNumeroFaixa(int numeroFaixa) {
        this.numeroFaixa = numeroFaixa;
    }

    public String getNomeFaixa() {
        return nomeFaixa;
    }

    public void setNomeFaixa(String nomeFaixa) {
        this.nomeFaixa = nomeFaixa;
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
    
    public void incluirFaixa(Faixa f) {
        PreparedStatement ps = null;
        
        try {
            ps = this.con.prepareStatement("INSERT INTO faixa (codAlbum, numeroFaixa, nomeFaixa) "
                                         + "VALUES (?, ?, ?)");
            ps.setInt(1, f.getCodAlbum());
            ps.setInt(2, f.getNumeroFaixa());
            ps.setString(3, f.getNomeFaixa());
            
            ps.executeUpdate();
        } catch(SQLException e) {
            throw new IllegalArgumentException("Já existe uma faixa com este número!\nPara alterá-la, "
                        + "selecione-a na tabela, digite o novo nome no campo de texto e clique no botão Editar");
        } finally {
            liberarRecursos(con, ps);
        }
    }
    
    public void alterarFaixa(Faixa f) {
        PreparedStatement ps = null;
        
        try {
            ps = this.con.prepareStatement("UPDATE faixa "
                                         + "SET nomeFaixa = ? "
                                         + "WHERE codAlbum = ? AND numeroFaixa = ?");
            ps.setString(1, f.getNomeFaixa());
            ps.setInt(2, f.getCodAlbum());
            ps.setInt(3, f.getNumeroFaixa());
            
            ps.executeUpdate();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }  finally {
            liberarRecursos(con, ps);
        }
    }
    
    public void excluirFaixa(Faixa f) {
        PreparedStatement ps = null;
        
        try {
            ps = this.con.prepareStatement("DELETE FROM faixa "
                                         + "WHERE numeroFaixa = ? AND codAlbum = ?");
            ps.setInt(1, f.getNumeroFaixa());
            ps.setInt(2, f.getCodAlbum());
            
            ps.executeUpdate();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            liberarRecursos(con, ps);
        }
    }
    
    public void excluirTodasFaixas(int codigoAlbum) {
        PreparedStatement ps = null;
        
        try {
            ps = this.con.prepareStatement("DELETE FROM faixa WHERE codAlbum = ?");
            ps.setInt(1, codigoAlbum);
            
            ps.executeUpdate();
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            liberarRecursos(con, ps);
        }
    }
    
    public ArrayList<Faixa> listarFaixas(int codigoAlbum) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Faixa> faixas = null;
        
        try {
            ps = this.con.prepareStatement("SELECT * FROM faixa WHERE codAlbum = ?");
            ps.setInt(1, codigoAlbum);
            rs = ps.executeQuery();
            
            faixas = new ArrayList<>();
            
            while (rs.next()) {
                Faixa f = new Faixa();
                
                f.setCodAlbum(rs.getInt("codAlbum"));
                f.setNumeroFaixa(rs.getInt("numeroFaixa"));
                f.setNomeFaixa(rs.getString("nomeFaixa"));
                
                faixas.add(f);
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            liberarRecursos(con, ps, rs);
        }
        
        return faixas;
    }
}