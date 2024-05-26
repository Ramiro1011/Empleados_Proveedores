package vistas;

import DTO.DepartamentoDTO;
import DTO.EmpleadoDTO;
import controlador.ControllerRRHH;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmCambioDpt extends JDialog{
    private JPanel PnlPrincipal;
    private JButton cancelarButton;
    private JButton aceptarButton;
    private JTable table1;

    private ModalResult modalResult = ModalResult.Cancelar;
    private DepartamentoTableModel tableModel;


    public void inicializarEventos(EmpleadoDTO emp, DepartamentoDTO d){
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerRRHH.getInstance().CambiarEmpDepartamento(emp,d.codigo,tableModel.getDepartamento(table1.getSelectedRow()).codigo);
                modalResult = ModalResult.Aceptar;
                dispose();
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modalResult = ModalResult.Cancelar;
                dispose();
            }
        });
    }
    public FrmCambioDpt(JFrame owner,EmpleadoDTO e, DepartamentoDTO d){
        super(owner, true);
        setSize(360, 240);
        setTitle("Cambiar De Departamento");
        setContentPane(PnlPrincipal);
        tableModel = new DepartamentoTableModel(ControllerRRHH.getInstance().obtenerDepartamentos());
        table1.setModel(tableModel);

        inicializarEventos(e, d);
    }
    public ModalResult getModalResult(){
        return modalResult;
    }
}
