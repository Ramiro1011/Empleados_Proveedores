package controlador;


import DTO.DepartamentoDTO;
import DTO.EmpleadoDTO;
import modelo.Departamento;
import vistas.FrmDepartamento;
import vistas.FrmPrincipal;


import java.util.ArrayList;


public class ControllerRRHH {
    private static ControllerRRHH instancia = null;
    private static ArrayList<Departamento> departamentos;

    private ControllerRRHH(){
        departamentos = new ArrayList<Departamento>();
        this.agregarDepartamento(1,"RRHH");
        this.agregarDepartamento(2, "IT");
    }
    static public ControllerRRHH getInstance(){
        if (instancia == null){
            instancia = new ControllerRRHH();
        }
        return instancia;
    }
    public void agregarDepartamento(int codigo, String denominacion){
        departamentos.add(new Departamento(codigo, denominacion));
    }

    public Departamento ObtenerDepartamento(int codigo){
        for (Departamento d: departamentos){
            if (d.getCodigo()  == codigo){
                return d;
            }
        }
        return null;
    }

    public void CambiarEmpDepartamento(EmpleadoDTO e, int dv, int dn){
        Departamento DV = ObtenerDepartamento(dv);
        Departamento DN = ObtenerDepartamento(dn);
        DN.agregarEmpleado(e.dni, e.apellido, e.nombre);
        DV.eliminarEmpleado(e.dni);
    }

    public ArrayList<DepartamentoDTO> obtenerDepartamentos(){
        ArrayList<DepartamentoDTO> res = new ArrayList<DepartamentoDTO>();
        for (Departamento d: departamentos){
            res.add(d.toDTO());
        }
        return res;
    }


}
