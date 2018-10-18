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
public class Categoria {
    private int categoria_cod;
    private String categoria_descripcion;
    
    public Categoria(){
        
    }
    public Categoria(int categoria_cod,String categoria_descripcion){
        this.categoria_cod=categoria_cod;
        this.categoria_descripcion=categoria_descripcion;
    }

    public int getCategoria_cod() {
        return categoria_cod;
    }

    public void setCategoria_cod(int categoria_cod) {
        this.categoria_cod = categoria_cod;
    }

    public String getCategoria_descripcion() {
        return categoria_descripcion;
    }

    public void setCategoria_descripcion(String categoria_descripcion) {
        this.categoria_descripcion = categoria_descripcion;
    }
    
}
