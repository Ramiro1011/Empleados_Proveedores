package vistas;

import DTO.DepartamentoDTO;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class DepartamentoTableModel extends AbstractTableModel {
    ArrayList<DepartamentoDTO> datos;
    protected String[] columnNames = new String[] {"Numero", "Denominacion"};
    protected Class[] columnClasses = new Class[] {int.class, String.class};

    public String getColumnName(int col) {return  columnNames[col];}
    public Class getColumnClass(int col) {return  columnClasses[col];}

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return datos.get(rowIndex).codigo;
            case 1: return datos.get(rowIndex).denominacion;
            default: return null;
        }
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    public int getColumnCount(){
        return columnNames.length;
    }

    public boolean isCellEditable(int row, int column){
        return false;
    }
    public DepartamentoDTO getDepartamento(int indexDepartamento){
        return datos.get(indexDepartamento);
    }

    public DepartamentoTableModel(ArrayList<DepartamentoDTO> datos){
        this.datos = datos;
    }

}
