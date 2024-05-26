package vistas;

import DTO.EmpleadoDTO;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;


public class EmpleadoTableModel extends AbstractTableModel {
    ArrayList<EmpleadoDTO> datos;
    protected String[] columnNames = new String[] {"DNI", "Apellido", "Nombre"};
    protected Class[] columnClasses = new Class[] {int.class, String.class, String.class};

    public String getColumnName(int col) {return  columnNames[col];}
    public Class getColumnClass(int col) {return  columnClasses[col];}

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return datos.get(rowIndex).dni;
            case 1: return datos.get(rowIndex).apellido;
            case 2: return datos.get(rowIndex).nombre;
            default: return null;
        }
    }
    public void refresh(){
        fireTableDataChanged();
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
    public EmpleadoDTO getEmpleado(int indexEmpleado){
        return datos.get(indexEmpleado);
    }
    public EmpleadoTableModel(ArrayList<EmpleadoDTO> datos){
        this.datos = datos;
    }
    public void setDatos(ArrayList<EmpleadoDTO> datos){
        this.datos = datos;
        refresh();
    }
}
