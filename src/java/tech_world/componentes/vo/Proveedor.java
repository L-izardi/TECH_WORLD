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
public class Proveedor {
    
    private int proveedor_cod;
    private String proveedor_nombre;
    private int proveedor_telefono;
    private int proveedor_pais_cod;

    public Proveedor(){

    }
    public Proveedor(int proveedor_cod,String proveedor_nombre,int proveedor_telefono, int proveedor_pais_cod){
    	this.proveedor_cod=proveedor_cod;
    	this.proveedor_nombre=proveedor_nombre;
    	this.proveedor_telefono=proveedor_telefono;
    	this.proveedor_pais_cod=proveedor_pais_cod;
    }

    public int getProveedor_cod() {
        return proveedor_cod;
    }

    public void setProveedor_cod(int proveedor_cod) {
        this.proveedor_cod = proveedor_cod;
    }

    public String getProveedor_nombre() {
        return proveedor_nombre;
    }

    public void setProveedor_nombre(String proveedor_nombre) {
        this.proveedor_nombre = proveedor_nombre;
    }

    public int getProveedor_telefono() {
        return proveedor_telefono;
    }

    public void setProveedor_telefono(int proveedor_telefono) {
        this.proveedor_telefono = proveedor_telefono;
    }

    public int getProveedor_pais_cod() {
        return proveedor_pais_cod;
    }

    public void setProveedor_pais_cod(int proveedor_pais_cod) {
        this.proveedor_pais_cod = proveedor_pais_cod;
    }
    
}
