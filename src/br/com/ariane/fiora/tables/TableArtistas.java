package br.com.ariane.fiora.tables;

import br.com.ariane.fiora.modelo.Artista;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TableArtistas extends AbstractTableModel {
    private String[] nomeColunas = {"Código Artista", "Nome", "Gênero", "Ano de Criação", "Site", "Tipo do Artista"};    
    private ArrayList<Artista> artistas;  
    
    public TableArtistas(){
        artistas = new ArrayList<>();
    }  
    
    public TableArtistas(ArrayList<Artista> listaDeArtistas){
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
                return a.getCodArtista();
            case 1:
                return a.getNome();
            case 2:
                return a.getGenero();
            case 3:
                return a.getAnoCriacao();
            case 4:
                return a.getSite();
            case 5:
                return a.getTipoArtista();
            default:
                throw new UnsupportedOperationException("Operação sem suporte!");
        }
    }
}
