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
import tech_world.dao.Pais;
import tech_world.dao.Sucursal;
import tech_world.logica.AccessSucursal;

/**
 *
 * @author Lizardi Alarcon
 */
@ManagedBean(name = "mbsucursal")
@SessionScoped
public class HBSucursal {
    
    
    private List<SelectItem> listsucursal;
    private List<Sucursal> sucursales;
    private Sucursal sucursal;
   
    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }   
    
    public HBSucursal() {
        sucursal = new Sucursal ();
    }
     public List<SelectItem> getListSucursal() {
         this.listsucursal = new ArrayList<SelectItem>();
        AccessSucursal sucursal = new AccessSucursal();
        List<Sucursal> s= sucursal.getSucursal();
        listsucursal.clear();
        
      for (Sucursal sucursales:s){
          SelectItem sucursalItem = new SelectItem (sucursales.getSucursalCod(), sucursales.getSucursalNombre());
          this.listsucursal.add(sucursalItem);
      } 
        return listsucursal;
        
     }
     public List<Sucursal> getSucursales() {
        AccessSucursal sucursal = new AccessSucursal();
        sucursales= sucursal.getSucursal();
        return sucursales;
    }
    
    public void nuevaSucursal (){
     HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
     String sucursalNombre = request.getParameter("formSucursal:txtNombre");
     String sucursalDireccion = request.getParameter("formSucursal:txtDireccion");
     String sucursalTelefono = request.getParameter("formSucursal:txtTelefono");
     int paisCod = Integer.parseInt(request.getParameter("formSucursal:idpais"));
     AccessSucursal accessSucursal = new AccessSucursal();
     Sucursal s= new Sucursal();
     s.setSucursalCod(null);
     s.setSucursalNombre(sucursalNombre);
     s.setSucursalDireccion(sucursalDireccion);
     s.setSucursalTelefono(sucursalTelefono);
     Pais pais= new Pais();
     pais.setPaisCod(paisCod);
     s.setPais(pais);
     
     accessSucursal.insertar(s);
    }
    
}
