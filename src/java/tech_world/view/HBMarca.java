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
import javax.faces.model.SelectItem;
import tech_world.dao.Marca;
import tech_world.logica.AccessMarca;

/**
 *
 * @author Lizardi Alarcon
 */
@ManagedBean(name = "mbmarca")
@SessionScoped
public class HBMarca {

    /**
     * Creates a new instance of HBMarca
     */
    public HBMarca() {
    }
    private List<SelectItem> listMarca;
    private List<Marca> marca;
    private Marca m;

    public Marca getMarca() {
        return m;
    }

    public void setMarca(Marca marca) {
        this.m = marca;
    }
      
    public List<Marca> getMarcas() {
        AccessMarca m = new AccessMarca();
        marca= m.getMarca();
        return marca;
    }
    
    public List<SelectItem> getListMarca() {        
        this.listMarca= new ArrayList<SelectItem>();
        AccessMarca m = new AccessMarca();
        List<Marca> p= m.getMarca();
        listMarca.clear();
        
        for(Marca marcas:p){
            SelectItem marcaItem= new SelectItem(marcas.getMarcaCod(),marcas.getNombre());
            this.listMarca.add(marcaItem);
        }
        
        return listMarca;
    }
}
