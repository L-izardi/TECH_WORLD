/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.view;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
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
    private Part file; 
    int categoriaId = 0;
    /**
     * Creates a new instance of HBProducto
     */
    public HBProducto() { 
       try{
            categoriaId = 
                Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext()
                    .getRequestParameterMap().get("id"));
        }
        catch(NumberFormatException ex){
            categoriaId = 0;
        } 
    }
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public List<Producto> getProductos() {
        try{
            categoriaId = 
                Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext()
                    .getRequestParameterMap().get("id"));
        }
        catch(NumberFormatException ex){
            categoriaId = 0;
        }
        AccessProducto bdProducto = new AccessProducto();
        if(categoriaId == 0)
            productos = bdProducto.getProducto();
        else
            productos = bdProducto.selectCategoria(categoriaId);
        return productos;
    }
    
    public List<Producto> getProductoCategoria() {               
        return productos;
    }
    
    public void selectCategoria(int cod){
        AccessProducto bdProducto = new AccessProducto();
        productos= bdProducto.selectCategoria(cod ); 
    }
    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    
    public void nuevoProducto() throws IOException{       
       
       HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
       String productoNombre = request.getParameter("fmrProductos:nombre");
       int idCategoria  = Integer.parseInt(request.getParameter("fmrProductos:idCategoria")); 
       int idMarca  = Integer.parseInt(request.getParameter("fmrProductos:idMarca"));
       float productoPrecio  = Float.parseFloat(request.getParameter("fmrProductos:precio"));
       String productoGarantia  = request.getParameter("fmrProductos:garantia");
       
       InputStream input = file.getInputStream();
       Files.copy(input, new File("C:\\Users\\Lizardi Alarcon\\Documents\\NetBeansProjects\\Tech_World\\web\\img\\productos", file.getSubmittedFileName()).toPath());
     
       String img= "img/productos/"+file.getSubmittedFileName();
       
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
       p.setProductoImagen(img);
       p.setProductoGarantia(productoGarantia);
       
       accessProducto.insertarProducto(p);
        
    }    
}
