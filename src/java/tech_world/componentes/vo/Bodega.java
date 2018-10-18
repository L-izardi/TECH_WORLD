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
public class Bodega {
    private int bodega_cod;
    private String bodega_nombre;
    private int bodega_telefono;
    private int bodega_pais_cod;
     
    public Bodega(){
        
    }
    public Bodega(int bodega_cod,String bodega_nombre,int bodega_telefono,int bodega_pais_cod){
        this.bodega_cod=bodega_cod;
        this.bodega_nombre=bodega_nombre;
        this.bodega_telefono=bodega_telefono;
        this.bodega_pais_cod=bodega_pais_cod;
    }

    public int getBodega_cod() {
        return bodega_cod;
    }

    public void setBodega_cod(int bodega_cod) {
        this.bodega_cod = bodega_cod;
    }

    public String getBodega_nombre() {
        return bodega_nombre;
    }

    public void setBodega_nombre(String bodega_nombre) {
        this.bodega_nombre = bodega_nombre;
    }

    public int getBodega_telefono() {
        return bodega_telefono;
    }

    public void setBodega_telefono(int bodega_telefono) {
        this.bodega_telefono = bodega_telefono;
    }

    public int getBodega_pais_cod() {
        return bodega_pais_cod;
    }

    public void setBodega_pais_cod(int bodega_pais_cod) {
        this.bodega_pais_cod = bodega_pais_cod;
    }
    
    
}
