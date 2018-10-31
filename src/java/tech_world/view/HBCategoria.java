/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.view;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tech_world.dao.Categoria;
import tech_world.logica.AccessCategoria;

/**
 *
 * @author Lizardi Alarcon
 */
@ManagedBean(name = "mbcategoria")
@SessionScoped
public class HBCategoria {
    private List<Categoria> Categoria;
    /**
     * Creates a new instance of HBCategoria
    */
    public HBCategoria() {
    } 
    
     private Categoria categoria = new Categoria();

    public Categoria getCliente() {
        return categoria;
    }

    public void setCliente(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    public List<Categoria> getCategorias() {
        AccessCategoria categoria = new AccessCategoria();
        Categoria= categoria.getCategoria();
        return Categoria;
    }
    public List<Categoria> busqCategoria(){
         AccessCategoria categoria = new AccessCategoria();
         Categoria= categoria.getCategoria();
        return Categoria;
    }      
}
