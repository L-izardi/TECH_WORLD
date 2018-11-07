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
import tech_world.dao.Pais;
import tech_world.dao.Proveedor;
import tech_world.logica.AccessProveedor;

/**
 *
 * @author Lizardi Alarcon
 */
@ManagedBean(name = "mbproveedor")
@SessionScoped
public class HBProveedor {
    
    private List<Proveedor> ListProveedor;
    private Proveedor  proveedor = new Proveedor();
    /**
     * Creates a new instance of HBProveedor
     */
    public HBProveedor() {
    }
    
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    public List<Proveedor> getListProveedor() {
        AccessProveedor bdProveedor = new AccessProveedor();
        ListProveedor= bdProveedor.getProveedores();
        return ListProveedor;
    }

    public void setListProveedor(List<Proveedor> ListProveedor) {
        this.ListProveedor = ListProveedor;
    }
    public void nuevoProveedor(){
       HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
       String proveedor_nombre = request.getParameter("formProveedor:proveedor_nombre");
       String proveedor_telefono  = request.getParameter("formProveedor:proveedor_telefono");
       int proveedor_pais_cod  = Integer.parseInt(request.getParameter("formProveedor:proveedor_pais_cod"));
        AccessProveedor bdProveedor= new AccessProveedor();
        Proveedor p= new Proveedor();
        p.setProveedorCod(null);
        p.setProveedorNombre(proveedor_nombre);
        p.setProveedorTelefono(proveedor_telefono);
        Pais pais= new Pais();
        pais.setPaisCod(proveedor_pais_cod);        
        p.setPais(pais);
        bdProveedor.insertarProveedor(p);
        
    }
    
    
}
