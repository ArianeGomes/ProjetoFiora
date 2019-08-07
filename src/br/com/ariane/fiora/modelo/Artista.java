package br.com.ariane.fiora.modelo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Artista {
    public Connection con;
    private int codArtista, anoCriacao;
    private String genero, site, nome, tipoArtista, loginUsuario;
    
    public Artista() {
        con = new Conexao().criarConexao();
    }

    public int getCodArtista() {
        return codArtista;
    }

    public void setCodArtista(int codArtista) {
        this.codArtista = codArtista;
    }

    public String getTipoArtista() {
        return tipoArtista;
    }

    public void setTipoArtista(String tipoArtista) {
        this.tipoArtista = tipoArtista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoCriacao() {
        return anoCriacao;
    }

    public void setAnoCriacao(int anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
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
    
    public void incluirArtista(Artista a, File img) {
        PreparedStatement ps = null;
        
        try {
            FileInputStream fis = new FileInputStream(img);
            
            ps = this.con.prepareStatement("INSERT INTO artista (nome, genero, anocriacao, site, loginUsuario, tipoArtista, foto) "
                                         + "VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, a.getNome());
            ps.setString(2, a.getGenero());
            ps.setInt(3, a.getAnoCriacao());
            ps.setString(4, a.getSite());
            ps.setString(5, a.getLoginUsuario());
            ps.setString(6, a.getTipoArtista());
            ps.setBinaryStream(7, fis); 
            
            ps.executeUpdate();
        } catch(FileNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            liberarRecursos(con, ps);
        }
    }
    
    public void alterarArtista(Artista a) {
        PreparedStatement ps = null;
        
        try {
            
            ps = this.con.prepareStatement("UPDATE artista "
                                         + "SET nome = ?, genero = ?, anoCriacao = ?, site = ?, loginUsuario = ?, tipoArtista = ? "
                                         + "WHERE codArtista = ?");
            ps.setString(1, a.getNome());
            ps.setString(2, a.getGenero());
            ps.setInt(3, a.getAnoCriacao());
            ps.setString(4, a.getSite());
            ps.setString(5, a.getLoginUsuario());
            ps.setString(6, a.getTipoArtista());
            ps.setInt(7, a.getCodArtista());
            
            ps.executeUpdate();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }  finally {
            liberarRecursos(con, ps);
        }
    }
    
    public void alterarArtista(Artista a, File img) {
        PreparedStatement ps = null;
        
        try {
            FileInputStream fis = new FileInputStream(img);
            
            ps = this.con.prepareStatement("UPDATE artista "
                                         + "SET nome = ?, genero = ?, anoCriacao = ?, site = ?, loginUsuario = ?, tipoArtista = ?, foto = ? "
                                         + "WHERE codArtista = ?");
            ps.setString(1, a.getNome());
            ps.setString(2, a.getGenero());
            ps.setInt(3, a.getAnoCriacao());
            ps.setString(4, a.getSite());
            ps.setString(5, a.getLoginUsuario());
            ps.setString(6, a.getTipoArtista());
            ps.setBinaryStream(7, fis); 
            ps.setInt(8, a.getCodArtista());
            
            ps.executeUpdate();
        } catch(FileNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }  finally {
            liberarRecursos(con, ps);
        }
    }
    
    public void excluirArtista(Artista a) {
        PreparedStatement ps = null;
        
        try {
            ps = this.con.prepareStatement("DELETE FROM artista "
                                         + "WHERE codArtista = ?");
            ps.setInt(1, a.getCodArtista());
            
            ps.executeUpdate();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            liberarRecursos(con, ps);
        }
    }
    
    public ArrayList<Artista> listarArtistas() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Artista> artistas = null;
        
        try {
            ps = this.con.prepareStatement("SELECT * FROM artista");
            rs = ps.executeQuery();
            
            artistas = new ArrayList<>();
            
            while (rs.next()) {
                Artista a = new Artista();
                
                a.setCodArtista(rs.getInt("codArtista"));
                a.setNome(rs.getString("nome"));
                a.setGenero(rs.getString("genero"));
                a.setAnoCriacao(rs.getInt("anoCriacao"));
                a.setSite(rs.getString("site"));
                a.setTipoArtista(rs.getString("tipoArtista"));
                a.setLoginUsuario(rs.getString("loginUsuario"));
                
                artistas.add(a);
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            liberarRecursos(con, ps, rs);
        }
        
        return artistas;
    }
    
    public ArrayList<Artista> buscarArtista(String busca) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Artista> artista = null;
        
        try {
            ps = this.con.prepareStatement("SELECT * FROM artista "
                                         + "WHERE nome LIKE ?");
            ps.setString(1, busca+"%");
            rs = ps.executeQuery();
            
            artista = new ArrayList<>();
            
            while (rs.next()) {
                Artista a = new Artista();
                
                a.setCodArtista(rs.getInt("codArtista"));
                a.setNome(rs.getString("nome"));
                a.setGenero(rs.getString("genero"));
                a.setAnoCriacao(rs.getInt("anoCriacao"));
                a.setSite(rs.getString("site"));
                a.setTipoArtista(rs.getString("tipoArtista"));
                a.setLoginUsuario(rs.getString("loginUsuario"));
                
                artista.add(a);
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            liberarRecursos(con, ps, rs);
        }
        
        return artista;
    }
    
    public Artista buscarArtista(int codigo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Artista a = null;
        
        try {
            ps = this.con.prepareStatement("SELECT * FROM artista "
                                         + "WHERE codArtista LIKE ?");
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                a = new Artista();
                
                a.setCodArtista(rs.getInt("codArtista"));
                a.setNome(rs.getString("nome"));
                a.setGenero(rs.getString("genero"));
                a.setAnoCriacao(rs.getInt("anoCriacao"));
                a.setSite(rs.getString("site"));
                a.setTipoArtista(rs.getString("tipoArtista"));
                a.setLoginUsuario(rs.getString("loginUsuario"));
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            liberarRecursos(con, ps, rs);
        }
        
        return a;
    }
    
    public BufferedImage abrirImagem(int codigoArtista){
        PreparedStatement ps = null;
        ResultSet rs = null;
        BufferedImage bi = null;
        
        try{
            ps = this.con.prepareStatement("SELECT foto FROM artista " +
                                           "WHERE codArtista = ?");
            
            ps.setInt(1, codigoArtista);
            rs = ps.executeQuery();
            
            rs.next();
            
            //lendo a imagem como um InputStream
            InputStream img = rs.getBinaryStream("foto");

            //decodificando o InputStream como um BufferedImage
            bi = ImageIO.read(img);
            
        } catch(IOException | SQLException ioe){
            throw new RuntimeException(ioe);
        }
        
        return bi;
    }  
}
