package br.com.ariane.fiora.modelo;

import java.awt.Image;
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

public class Album {
    public Connection con;
    private int codAlbum, codArtista, anoLancamento;
    private String titulo, midia, gravadora, loginUsuario;
    
    public Album() {
        con = new Conexao().criarConexao();
    }

    public int getCodAlbum() {
        return codAlbum;
    }

    public void setCodAlbum(int codAlbum) {
        this.codAlbum = codAlbum;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMidia() {
        return midia;
    }

    public void setMidia(String midia) {
        this.midia = midia;
    }

    public String getGravadora() {
        return gravadora;
    }

    public void setGravadora(String gravadora) {
        this.gravadora = gravadora;
    }

    public int getCodArtista() {
        return codArtista;
    }

    public void setCodArtista(int codArtista) {
        this.codArtista = codArtista;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }
    
    @Override
    public String toString() {
        return titulo;
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
    
    public void incluirAlbum(Album a, File img) {
        PreparedStatement ps = null;
        
        try {
            FileInputStream fis = new FileInputStream(img);
            
            ps = this.con.prepareStatement("INSERT INTO album (codArtista, gravadora, titulo, anoLancamento, midia, capa, loginUsuario) "
                                         + "VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, a.getCodArtista());
            ps.setString(2, a.getGravadora());
            ps.setString(3, a.getTitulo());
            ps.setInt(4, a.getAnoLancamento());
            ps.setString(5, a.getMidia());
            ps.setBinaryStream(6, fis);
            ps.setString(7, a.getLoginUsuario());
            
            ps.executeUpdate();
        } catch(FileNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            liberarRecursos(con, ps);
        }
    }
    
    public void alterarAlbum(Album a) {
        PreparedStatement ps = null;
        
        try {
            ps = this.con.prepareStatement("UPDATE album "
                                         + "SET codArtista = ?, gravadora = ?, titulo = ?, anoLancamento = ?, midia = ?, loginUsuario = ? "
                                         + "WHERE codAlbum = ?");
            ps.setInt(1, a.getCodArtista());
            ps.setString(2, a.getGravadora());
            ps.setString(3, a.getTitulo());
            ps.setInt(4, a.getAnoLancamento());
            ps.setString(5, a.getMidia());
            ps.setString(6, a.getLoginUsuario());
            ps.setInt(7, a.getCodAlbum());
            
            ps.executeUpdate();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }  finally {
            liberarRecursos(con, ps);
        }
    }
    
    public void alterarAlbum(Album a, File img) {
        PreparedStatement ps = null;
        
        try {
            FileInputStream fis = new FileInputStream(img);
            
            ps = this.con.prepareStatement("UPDATE album "
                                         + "SET codArtista = ?, gravadora = ?, titulo = ?, anoLancamento = ?, midia = ?, capa = ?, loginUsuario = ? "
                                         + "WHERE codAlbum = ?");
            ps.setInt(1, a.getCodArtista());
            ps.setString(2, a.getGravadora());
            ps.setString(3, a.getTitulo());
            ps.setInt(4, a.getAnoLancamento());
            ps.setString(5, a.getMidia());
            ps.setBinaryStream(6, fis);
            ps.setString(7, a.getLoginUsuario());
            ps.setInt(8, a.getCodAlbum());
            
            ps.executeUpdate();
        } catch(FileNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }  finally {
            liberarRecursos(con, ps);
        }
    }
    
    public void excluirAlbum(int codigoAlbum) {
        PreparedStatement ps = null;
        
        try {
            ps = this.con.prepareStatement("DELETE FROM album "
                                         + "WHERE codAlbum = ?");
            ps.setInt(1, codigoAlbum);
            
            ps.executeUpdate();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            liberarRecursos(con, ps);
        }
    }
    
    public void excluirTodosAlbuns(int codigoArtista) {
        PreparedStatement ps = null;
        
        try {
            ps = this.con.prepareStatement("DELETE FROM album WHERE codArtista = ?");
            ps.setInt(1, codigoArtista);
            
            ps.executeUpdate();
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            liberarRecursos(con, ps);
        }
    }
    
    public ArrayList<Album> listarAlbuns() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Album> albuns = null;
        
        try {
            ps = this.con.prepareStatement("SELECT * FROM album");
            rs = ps.executeQuery();
            
            albuns = new ArrayList<>();
            
            while (rs.next()) {
                Album a = new Album();
                
                a.setCodAlbum(rs.getInt("codAlbum"));
                a.setCodArtista(rs.getInt("codArtista"));
                a.setGravadora(rs.getString("gravadora"));
                a.setTitulo(rs.getString("titulo"));
                a.setAnoLancamento(rs.getInt("anoLancamento"));
                a.setMidia(rs.getString("midia"));
                a.setLoginUsuario(rs.getString("loginUsuario"));
                
                albuns.add(a);
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            liberarRecursos(con, ps, rs);
        }
        
        return albuns;
    }
    
    public ArrayList<Album> listarAlbuns(int codigoArtista) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Album> albuns = null;
        
        try {
            ps = this.con.prepareStatement("SELECT * FROM album WHERE codArtista = ?");
            ps.setInt(1, codigoArtista);
            rs = ps.executeQuery();
            
            albuns = new ArrayList<>();
            
            while (rs.next()) {
                Album a = new Album();
                
                a.setCodAlbum(rs.getInt("codAlbum"));
                a.setCodArtista(rs.getInt("codArtista"));
                a.setGravadora(rs.getString("gravadora"));
                a.setTitulo(rs.getString("titulo"));
                a.setAnoLancamento(rs.getInt("anoLancamento"));
                a.setMidia(rs.getString("midia"));
                a.setLoginUsuario(rs.getString("loginUsuario"));
                
                albuns.add(a);
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            liberarRecursos(con, ps, rs);
        }
        
        return albuns;
    }
    
    public Album buscarAlbum(int codigo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Album a = new Album();
        
        try {
            ps = this.con.prepareStatement("SELECT * FROM album "
                                         + "WHERE codAlbum LIKE ?");
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                a.setCodAlbum(rs.getInt("codAlbum"));
                a.setCodArtista(rs.getInt("codArtista"));
                a.setGravadora(rs.getString("gravadora"));
                a.setTitulo(rs.getString("titulo"));
                a.setAnoLancamento(rs.getInt("anoLancamento"));
                a.setMidia(rs.getString("midia"));
                a.setLoginUsuario(rs.getString("loginUsuario"));
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            liberarRecursos(con, ps, rs);
        }
        
        return a;
    }
    
    public Image abrirImagem(int codigoAlbum){
        PreparedStatement ps = null;
        ResultSet rs = null;
        BufferedImage bi = null;
        
        try{
            ps = this.con.prepareStatement("SELECT capa FROM album " +
                                           "WHERE codAlbum = ?");
            
            ps.setInt(1, codigoAlbum);
            rs = ps.executeQuery();
            
            rs.next();
            
            //lendo a imagem como um InputStream
            InputStream img = rs.getBinaryStream("capa");

            //decodificando o InputStream como um BufferedImage
            bi = ImageIO.read(img);
            
            
            
        } catch(IOException | SQLException ioe){
            throw new RuntimeException(ioe);
        }
        
        return bi;
    }
}
