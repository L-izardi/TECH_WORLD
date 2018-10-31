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
import tech_world.logica.AccessSucursales;

/**
 *
 * @author MARIO
 */

@ManagedBean(name = "mbsucursales")
@SessionScoped
public class HBSucursales {
    
private List<Sucursal> Sucursal;  

    /**
     * Creates a new instance of HBSucursales
     */
    public HBSucursales() {
    }
    //private Sucursal sucursal = new Sucursal();

    public List<Sucursal> getSucursal() {
        AccessSucursales sucursal = new AccessSucursales();
        Sucursal = sucursal.getSucursal();
        return Sucursal;
    }

    public void setSucursal(List<Sucursal> Sucursal) {
        this.Sucursal = Sucursal;
    }
/*
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
    */
    
    
}
