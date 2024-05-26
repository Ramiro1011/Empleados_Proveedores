package modelo;

import DTO.DepartamentoDTO;
import DTO.EmpleadoDTO;

import java.util.ArrayList;


public class Departamento {
    private int codigo;
    private String denominacion;
    private ArrayList<Empleado> empleados;

    public Departamento(int codigo, String denominacion){
        this.codigo = codigo;
        this.denominacion = denominacion;
        empleados = new ArrayList<Empleado>();
    }
    public void agregarEmpleado(String dni, String apellido, String nombre){
        empleados.add(new Empleado(dni, apellido, nombre));
    }

    public void modificarEmpleado(String dniV, String dni, String apellido, String nombre){
        for (Empleado e: empleados){
            if(e.getDni().equals(dniV)){
                e.setDni(dni);
                e.setApellido(apellido);
                e.setNombre(nombre);
            }
        }
    }
    public void eliminarEmpleado(String dni){
        Empleado e2 = null;
        for (Empleado e: empleados){
            if(e.getDni().equals(dni)){
                e2 = e;
                break;
            }
        }
        if (e2!= null){empleados.remove(e2);}

    }
    public int getCodigo(){
        return codigo;
    }
    public ArrayList<EmpleadoDTO> obtenerEmpleados()
    {
        ArrayList<EmpleadoDTO> resultado = new ArrayList<EmpleadoDTO>();
        for (Empleado e: empleados) {
            resultado.add(e.toDto());
        }
        return resultado;
    }


    public DepartamentoDTO toDTO(){
        DepartamentoDTO dDTO = new DepartamentoDTO();
        dDTO.codigo = this.codigo;
        dDTO.denominacion = this.denominacion;
        dDTO.empleados = this.empleados;
        return dDTO;
    }
}
