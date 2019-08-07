package br.com.ariane.fiora.tables;

import br.com.ariane.fiora.modelo.Artista;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TableArtistasListagem extends AbstractTableModel {
    private String[] nomeColunas = {"Nome", "Gênero", "Tipo do Artista"};    
    private ArrayList<Artista> artistas;  
    
    public TableArtistasListagem(){
        artistas = new ArrayList<>();
    }  
    
    public TableArtistasListagem(ArrayList<Artista> listaDeArtistas){
        this();
        artistas.addAll(listaDeArtistas);
    } 
    
    public Artista retornarObjetoSelecionado(int linha){
        return artistas.get(linha);
    }
    
    @Override
    public int getRowCount() {
        return artistas.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Artista a = artistas.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return a.getNome();
            case 1:
                return a.getGenero();
            case 2:
                return a.getTipoArtista();
            default:
                throw new UnsupportedOperationException("Operação sem suporte!");
        }
    }
}
