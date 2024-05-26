package vistas;

import DTO.DepartamentoDTO;
import DTO.EmpleadoDTO;
import controlador.ControllerRRHH;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmEmpleadoABM extends JDialog{
    private JPanel PnlPrincipal;
    private JButton cancelarButton;
    private JButton aceptarButton;
    private JTextField textDni;
    private JTextField textApellido;
    private JTextField textNombre;
    private JLabel lblTitulo;
    private ModoABM modoOperacion;
    private ModalResult modalResult = ModalResult.Cancelar;

    private void InicializarEventos(DepartamentoDTO d, EmpleadoDTO emp){
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (modoOperacion){
                    case Agregar:
                        ControllerRRHH.getInstance().ObtenerDepartamento(d.codigo).agregarEmpleado(textDni.getText(), textApellido.getText(),textNombre.getText() );
                        break;
                    case Modificar:
                        ControllerRRHH.getInstance().ObtenerDepartamento(d.codigo).modificarEmpleado(emp.dni, textDni.getText(), textApellido.getText(),textNombre.getText());
                        break;
                }
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

    public FrmEmpleadoABM(JFrame owner, DepartamentoDTO d, EmpleadoDTO e){
        super(owner, true);
        setSize(360, 240);
        setTitle("Agregar Empleado");
        setContentPane(PnlPrincipal);
        setLocationRelativeTo(null);

        InicializarEventos(d, e);

    }
    public void setDatos(EmpleadoDTO datos){
        textDni.setText(datos.dni);
        textApellido.setText(datos.apellido);
        textNombre.setText(datos.nombre);
    }
    public void setModo(ModoABM modo){
        modoOperacion = modo;
        switch (modoOperacion){
            case Modificar:
                lblTitulo.setText("Modificar Empleado");
                break;
        }
    }

    public ModalResult getModalResult(){
        return modalResult;
    }
}
