/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.view;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import tech_world.dao.Categoria;
import tech_world.dao.Marca;
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
    public void nuevoProducto(){       
       HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
       String productoNombre = request.getParameter("fmrProductos:nombre");
       int idCategoria  = Integer.parseInt(request.getParameter("fmrProductos:idCategoria")); 
       int idMarca  = Integer.parseInt(request.getParameter("fmrProductos:idMarca"));
       float productoPrecio  = Float.parseFloat(request.getParameter("fmrProductos:precio"));
       String productoGarantia  = request.getParameter("fmrProductos:garantia");
       String imagen  = request.getParameter("fmrProductos:imagen");
      
        AccessProducto accessProducto= new AccessProducto();
        Categoria cat= new Categoria();
        Marca marca= new Marca();
        cat.setCategoriaCod(idCategoria);
        marca.setMarcaCod(idMarca);
        Producto p= new Producto();
        p.setProductoCod(null);
        p.setProductoNombre(productoNombre);
        p.setCategoria(cat);
        p.setMarca(marca);
        p.setProductoPrecio(productoPrecio);
       // p.setProductoImagen(imagen);
        p.setProductoGarantia(productoGarantia);
        
        accessProducto.insertarProducto(p);
        
    }
}
