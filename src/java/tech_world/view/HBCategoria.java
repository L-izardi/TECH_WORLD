/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.view;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import tech_world.dao.Categoria;
import tech_world.logica.AccessCategoria;

/**
 *
 * @author Lizardi Alarcon
 */
@ManagedBean(name = "mbcategoria")
@SessionScoped
public class HBCategoria {
    
    private List<SelectItem> listCategoria;
    private List<Categoria> Categoria;
    private int categoriaId = 0;
    /**
     * Creates a new instance of HBCategoria
    */
    public HBCategoria() {
               
    } 
    
     private Categoria categoria = new Categoria();

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    public List<Categoria> getCategorias() {
        AccessCategoria aCategoria = new AccessCategoria();
        Categoria = aCategoria.getCategoria();
        return Categoria;
    }
    public List<Categoria> busqCategoria(){
         AccessCategoria aCategoria = new AccessCategoria();
         Categoria= aCategoria.getCategoria();
        return Categoria;
    }      
    
    public List<SelectItem> getListCategoria() {        
        this.listCategoria = new ArrayList<>();
        AccessCategoria aCategoria = new AccessCategoria();
        List<Categoria> p= aCategoria.getCategoria();
        listCategoria.clear();
        
        for(Categoria lc:p){
            SelectItem categoriaItem= new SelectItem(lc.getCategoriaCod(),lc.getCategoriaDescripcion());
            this.listCategoria.add(categoriaItem);
        }
        
        return listCategoria;
    }
    public void nuevaCategoria(){
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String categoriaDescripcion = request.getParameter("formCategoria:categoriaNombre");
        AccessCategoria accessCategoria= new AccessCategoria();
        Categoria c= new Categoria();
        c.setCategoriaCod(null);
        c.setCategoriaDescripcion(categoriaDescripcion);
        accessCategoria.insertarCategoria(c);
    }
}
