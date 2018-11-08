/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.view;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import tech_world.dao.ProductoBodega;

/**
 *
 * @author Lizardi Alarcon
 */
@ManagedBean(name = "mbdisponible")
@RequestScoped
public class HBDisponible {

    /**
     * Creates a new instance of HBDisponible
     */
    public HBDisponible() {
    }
    private List <ProductoBodega> disponibilidad;

    public List<ProductoBodega> getDisponibilidad() {
        
        return disponibilidad;
    }

    
}
