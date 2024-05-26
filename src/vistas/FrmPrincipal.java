package vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmPrincipal extends JFrame{
    private JButton departamentosButton;
    private JPanel PnlPrincipal;
    private JDesktopPane desktopPane;
    private FrmPrincipal self;
    private void inicializarEventos(){
        departamentosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmDepartamento frm = new FrmDepartamento(self, desktopPane);
                desktopPane.removeAll();
                desktopPane.add(frm);
                frm.setVisible(true);
            }
        });

    }
    public FrmPrincipal(){
        setTitle("Menu Principal");
        setLocationRelativeTo(null);
        setSize(700, 360);
        setContentPane(PnlPrincipal);
        self = this;
        inicializarEventos();
    }

}
