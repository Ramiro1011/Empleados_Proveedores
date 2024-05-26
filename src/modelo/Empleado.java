package modelo;

import DTO.EmpleadoDTO;

public class Empleado {
    private String dni;
    private String apellido;
    private String nombre;

    public Empleado(String dni, String apellido, String nombre){
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public EmpleadoDTO toDto(){
        EmpleadoDTO e = new EmpleadoDTO();
        e.dni = this.dni;
        e.nombre = this.nombre;
        e.apellido =  this.apellido;
        return e;
    }
    public String getDni(){
        return dni;
    }

    public void setDni(String dni){
        this.dni = dni;
    }
    public void setApellido(String Apellido){
        this.apellido = Apellido;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
