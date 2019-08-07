package br.com.ariane.fiora.tables;

import br.com.ariane.fiora.modelo.Album;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TableAlbunsListagem extends AbstractTableModel {
    private String[] nomeColunas = {"Titulo", "Ano de Lancamento", "Midia"};    
    private ArrayList<Album> albuns;
    
    public TableAlbunsListagem(){
        albuns = new ArrayList<>();
    }  
    
    public TableAlbunsListagem(ArrayList<Album> listaDeAlbuns){
        this();
        albuns.addAll(listaDeAlbuns);
    } 
    
    public Album retornarObjetoSelecionado(int linha){
        return albuns.get(linha);
    }
    
    @Override
    public int getRowCount() {
        return albuns.size();
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
        Album a = albuns.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return a.getTitulo();
            case 1:
                return a.getAnoLancamento();
            case 2:
                return a.getMidia();
            default:
                throw new UnsupportedOperationException("Operação sem suporte!");
        }
    }
}
