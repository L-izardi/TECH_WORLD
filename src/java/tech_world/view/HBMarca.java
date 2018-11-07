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
    private List<Marca> Marca;
    private Marca marca = new Marca();

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
      
    public List<Marca> getMarcas() {
        AccessMarca m = new AccessMarca();
        Marca= m.getMarca();
        return Marca;
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
    public void nuevaMarca(){
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String marcaNombre = request.getParameter("formMarca:marcaNombre");
        AccessMarca accessMarca= new AccessMarca();
        Marca m= new Marca();
        m.setMarcaCod(null);
        m.setNombre(marcaNombre);
        accessMarca.insertarMarca(m);
    }
}