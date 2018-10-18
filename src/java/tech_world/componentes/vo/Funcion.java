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
public class Funcion {
    
    private int funcion_cod;
    private String funcion_descripcion;

    public Funcion(){

    }
    public Funcion(int funcion_cod,String funcion_descripcion){
    	this.funcion_cod=funcion_cod;
    	this.funcion_descripcion=funcion_descripcion;
    }

    public int getFuncion_cod() {
        return funcion_cod;
    }

    public void setFuncion_cod(int funcion_cod) {
        this.funcion_cod = funcion_cod;
    }

    public String getFuncion_descripcion() {
        return funcion_descripcion;
    }

    public void setFuncion_descripcion(String funcion_descripcion) {
        this.funcion_descripcion = funcion_descripcion;
    }
    
}
