package vistas;

import controlador.ControllerRRHH;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmDepartamento extends JInternalFrame {
    private JPanel PnlPrincipal;
    private JTable table1;
    private JButton empleadosButton;
    private JDesktopPane desktopPane;
    private JFrame owner;
    private DepartamentoTableModel tableModel;
    private ModalResult modalResult = ModalResult.Cancelar;

    private void inicializarEventos(JFrame owner, JDesktopPane princ){
        empleadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmEmpleados frm = new FrmEmpleados(owner, tableModel.getDepartamento(table1.getSelectedRow()));
                princ.removeAll();
                princ.add(frm);
                frm.setVisible(true);
            }
        });
    };

    public FrmDepartamento(JFrame owner, JDesktopPane princ){
        this.owner = owner;
        setContentPane(PnlPrincipal);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);

        tableModel = new DepartamentoTableModel(ControllerRRHH.getInstance().obtenerDepartamentos());
        table1.setModel(tableModel);

        this.setBorder(null);
        inicializarEventos(owner, princ);
    }

}
