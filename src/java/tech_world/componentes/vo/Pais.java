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
public class Pais {
    private int pais_cod;
    private String pais_nombre;
    
    public Pais(){
        
    }
    public Pais(int pais_cod,String pais_nombre){
        this.pais_cod=pais_cod;
        this.pais_nombre=pais_nombre;
    }

    public int getPais_cod() {
        return pais_cod;
    }

    public void setPais_cod(int pais_cod) {
        this.pais_cod = pais_cod;
    }

    public String getPais_nombre() {
        return pais_nombre;
    }

    public void setPais_nombre(String pais_nombre) {
        this.pais_nombre = pais_nombre;
    }
    
}
