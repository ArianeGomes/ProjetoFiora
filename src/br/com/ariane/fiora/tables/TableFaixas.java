package br.com.ariane.fiora.tables;

import br.com.ariane.fiora.modelo.Faixa;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TableFaixas extends AbstractTableModel {
    private String[] nomeColunas = {"Número da Faixa", "Nome da Faixa"};    
    private ArrayList<Faixa> faixas;  
    
    public TableFaixas(){
        faixas = new ArrayList<>();
    }
    
    public TableFaixas(ArrayList<Faixa> listaDeFaixas){
        this();
        faixas.addAll(listaDeFaixas);
    } 
    
    public void setFaixasAdicionadas(Faixa f){
        faixas.add(f);
        fireTableDataChanged();
    }
    
    public Faixa retornarObjetoSelecionado(int linha){
        return faixas.get(linha);
    }
    
    public boolean ultimaFaixa(int numeroFaixa) {
        boolean ultimaFaixa = true;
        if ((numeroFaixa <= faixas.size())) {
            ultimaFaixa = false;
        }
        
        return ultimaFaixa;
    }
    
    @Override
    public int getRowCount() {
        return faixas.size();
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
        Faixa f = faixas.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return f.getNumeroFaixa();
            case 1:
                return f.getNomeFaixa();
            default:
                throw new UnsupportedOperationException("Operação sem suporte!");
        }
    }
}
