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
public class Sucursal {
    
    private int sucursal_cod;
    private String sucursal_nombre;
    private String sucursal_direccion;
    private int sucursal_pais_cod;

    public Sucursal(){

    }
    public Sucursal(int sucursal_cod, String sucursal_nombre, String sucursal_direccion, int sucursal_pais_cod){
    	this.sucursal_cod=sucursal_cod;
    	this.sucursal_nombre=sucursal_nombre;
    	this.sucursal_direccion=sucursal_direccion;
    	this.sucursal_pais_cod=sucursal_pais_cod;
    }

    public int getSucursal_cod() {
        return sucursal_cod;
    }

    public void setSucursal_cod(int sucursal_cod) {
        this.sucursal_cod = sucursal_cod;
    }

    public String getSucursal_nombre() {
        return sucursal_nombre;
    }

    public void setSucursal_nombre(String sucursal_nombre) {
        this.sucursal_nombre = sucursal_nombre;
    }

    public String getSucursal_direccion() {
        return sucursal_direccion;
    }

    public void setSucursal_direccion(String sucursal_direccion) {
        this.sucursal_direccion = sucursal_direccion;
    }

    public int getSucursal_pais_cod() {
        return sucursal_pais_cod;
    }

    public void setSucursal_pais_cod(int sucursal_pais_cod) {
        this.sucursal_pais_cod = sucursal_pais_cod;
    }
    
}
