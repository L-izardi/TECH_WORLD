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
public class Tipo_Empleado {
    
    private int tipo_cod;
    private int tipo_descripcion;

    public Tipo_Empleado(){

    }
    public Tipo_Empleado(int tipo_cod, int tipo_descripcion){
    	this.tipo_cod=tipo_cod;
    	this.tipo_descripcion=tipo_descripcion;
    }

    public int getTipo_cod() {
        return tipo_cod;
    }

    public void setTipo_cod(int tipo_cod) {
        this.tipo_cod = tipo_cod;
    }

    public int getTipo_descripcion() {
        return tipo_descripcion;
    }

    public void setTipo_descripcion(int tipo_descripcion) {
        this.tipo_descripcion = tipo_descripcion;
    }
    
}
