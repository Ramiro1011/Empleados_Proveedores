package vistas;

import DTO.DepartamentoDTO;
import DTO.EmpleadoDTO;
import controlador.ControllerRRHH;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmEmpleados extends JInternalFrame{
    private JPanel pnlPrincipal;
    private JButton eliminarButton;
    private JButton modificarButton;
    private JButton agregarButton;
    private JTable table1;
    private JButton cambiarDepartamentoButton;
    private JFrame owner;
    private EmpleadoTableModel tableModel;
    private EmpleadoDTO es = null;

    public void inicializarEventos(JFrame owner, DepartamentoDTO d){
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModoABM m = ModoABM.Agregar;
                FrmEmpleadoABM frm = new FrmEmpleadoABM(owner, d, getEmpleadoDto(m));
                frm.setModo(m);
                frm.setVisible(true);
                if (frm.getModalResult() == ModalResult.Aceptar){
                    tableModel.setDatos(ControllerRRHH.getInstance().ObtenerDepartamento(d.codigo).obtenerEmpleados());
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               ControllerRRHH.getInstance().ObtenerDepartamento(d.codigo).eliminarEmpleado(tableModel.getEmpleado(table1.getSelectedRow()).dni);
               tableModel.setDatos(ControllerRRHH.getInstance().ObtenerDepartamento(d.codigo).obtenerEmpleados());
           }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmEmpleadoABM frm = new FrmEmpleadoABM(owner, d, tableModel.getEmpleado(table1.getSelectedRow()));
                frm.setModo(ModoABM.Modificar);
                frm.setDatos(tableModel.getEmpleado(table1.getSelectedRow()));
                frm.setVisible(true);
                if (frm.getModalResult() == ModalResult.Aceptar){
                    tableModel.setDatos(ControllerRRHH.getInstance().ObtenerDepartamento(d.codigo).obtenerEmpleados());
                }
            }
        });
       cambiarDepartamentoButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                FrmCambioDpt frm = new FrmCambioDpt(owner, tableModel.getEmpleado(table1.getSelectedRow()), d);
                frm.setVisible(true);
                if (frm.getModalResult() == ModalResult.Aceptar){
                    tableModel.setDatos(ControllerRRHH.getInstance().ObtenerDepartamento(d.codigo).obtenerEmpleados());
                }
           }
        });
    }

    public FrmEmpleados(JFrame owner, DepartamentoDTO d){
        this.owner = owner;
        setContentPane(pnlPrincipal);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);

        tableModel = new EmpleadoTableModel(ControllerRRHH.getInstance().ObtenerDepartamento(d.codigo).obtenerEmpleados());
        table1.setModel(tableModel);

        this.setBorder(null);
        inicializarEventos(owner, d);

    }
    public EmpleadoDTO getEmpleadoDto(ModoABM m){
        if(tableModel.getRowCount()>0 && m != ModoABM.Agregar){
            EmpleadoDTO es = tableModel.getEmpleado(table1.getSelectedRow());}
        return es;
    }
}
