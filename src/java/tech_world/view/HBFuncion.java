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
import tech_world.dao.Funcion;
import tech_world.logica.AccessFuncion;

/**
 *
 * @author Lizardi Alarcon
 */
@ManagedBean(name = "mbfuncion")
@SessionScoped
public class HBFuncion {

    private List<SelectItem> listFuncion;
    private Funcion  funcion = new Funcion();
    /**
     * Creates a new instance of HBBodega
     */
    public HBFuncion() {
    }
    
    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }
     public List<SelectItem> getListFuncion() {        
        this.listFuncion= new ArrayList<SelectItem>();
        AccessFuncion funcion = new AccessFuncion();
        List<Funcion> f= funcion.getFuncion();
        listFuncion.clear();
        
        for(Funcion funciones:f){
            SelectItem funcionItem= new SelectItem(funciones.getFuncionCod(),funciones.getFuncionDescripcion());
            this.listFuncion.add(funcionItem);
        }
        
        return listFuncion;
    }
   
}
