/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.view;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tech_world.dao.Sucursal;
import tech_world.logica.AccessSucursal;

/**
 *
 * @author Lizardi Alarcon
 */
@ManagedBean(name = "mbsucursal")
@SessionScoped
public class HBSucursal {
    
    
    private List<Sucursal> Sucursal;
    /**
     * Creates a new instance of HBSucursal
     */
    public HBSucursal() {
    }
     public List<Sucursal> getSucursal() {
        AccessSucursal sucursal = new AccessSucursal();
        Sucursal= sucursal.getSucursal();
        return Sucursal;
    }
    
    
    
}
