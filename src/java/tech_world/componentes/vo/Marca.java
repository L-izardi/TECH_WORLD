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
public class Marca {
    
    private int marca_cod;
    private String marca_nombre;

    public Marca(){

    }
    public Marca(int marca_cod,String marca_nombre){
    	this.marca_cod=marca_cod;
    	this.marca_nombre=marca_nombre;
    }

    public int getMarca_cod() {
        return marca_cod;
    }

    public void setMarca_cod(int marca_cod) {
        this.marca_cod = marca_cod;
    }

    public String getMarca_nombre() {
        return marca_nombre;
    }

    public void setMarca_nombre(String marca_nombre) {
        this.marca_nombre = marca_nombre;
    }
    
}
