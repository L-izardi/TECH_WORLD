/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.componentes.vo;

/**
 *
 * @author Lizardi Alarcon
 */
public class Empleado {
    
    private int empleado_cod;
    private int empleado_sucursal_cod;
    private String empleado_nombre;
    private String empleado_apellido;
    private float empleado_salario;
    private int empleado_tipo_cod;

    public Empleado(){

    }
    public Empleado(int empleado_cod, int empleado_sucursal_cod, String empleado_nombre, String empleado_apellido, float empleado_salario, int empleado_tipo_cod){
    	this.empleado_cod=empleado_cod;
    	this.empleado_sucursal_cod=empleado_sucursal_cod;
    	this.empleado_nombre=empleado_nombre;
    	this.empleado_apellido=empleado_apellido;
    	this.empleado_salario=empleado_salario;
    	this.empleado_tipo_cod=empleado_tipo_cod;
    }

    public int getEmpleado_cod() {
        return empleado_cod;
    }

    public void setEmpleado_cod(int empleado_cod) {
        this.empleado_cod = empleado_cod;
    }

    public int getEmpleado_sucursal_cod() {
        return empleado_sucursal_cod;
    }

    public void setEmpleado_sucursal_cod(int empleado_sucursal_cod) {
        this.empleado_sucursal_cod = empleado_sucursal_cod;
    }

    public String getEmpleado_nombre() {
        return empleado_nombre;
    }

    public void setEmpleado_nombre(String empleado_nombre) {
        this.empleado_nombre = empleado_nombre;
    }

    public String getEmpleado_apellido() {
        return empleado_apellido;
    }

    public void setEmpleado_apellido(String empleado_apellido) {
        this.empleado_apellido = empleado_apellido;
    }

    public float getEmpleado_salario() {
        return empleado_salario;
    }

    public void setEmpleado_salario(float empleado_salario) {
        this.empleado_salario = empleado_salario;
    }

    public int getEmpleado_tipo_cod() {
        return empleado_tipo_cod;
    }

    public void setEmpleado_tipo_cod(int empleado_tipo_cod) {
        this.empleado_tipo_cod = empleado_tipo_cod;
    }
    
}
