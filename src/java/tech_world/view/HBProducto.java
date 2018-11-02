/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.view;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tech_world.dao.Producto;
import tech_world.logica.AccessProducto;

/**
 *    
 * @author Lizardi Alarcon
 */
@ManagedBean(name = "mbproducto")
@SessionScoped
public class HBProducto {

    private List<Producto> productos;
    private Producto  producto = new Producto(); 
    /**
     * Creates a new instance of HBProducto
     */
    public HBProducto() { 
       
    }
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public List<Producto> getProductos() {
        AccessProducto bdProducto = new AccessProducto();
        productos= bdProducto.getProducto();
        return productos;
    }
}
