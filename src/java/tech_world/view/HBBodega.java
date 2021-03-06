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
import tech_world.dao.Bodega;
import tech_world.dao.Pais;
import tech_world.logica.AccessBodega;

/**
 *
 * @author Lizardi Alarcon
 */
@ManagedBean(name = "mbbodega")
@SessionScoped
public class HBBodega {
    
    private List<Bodega> Listbodega;
    private Bodega  bodega = new Bodega();
    /**
     * Creates a new instance of HBBodega
     */
    public HBBodega() {
    }
    
    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }
    public List<Bodega> getBodegas() {
        AccessBodega bdBodega = new AccessBodega();
        Listbodega= bdBodega.getBodegas();
        return Listbodega;
    }
    
    public void nuevaBodega(){
       HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
       String bodegaNombre = request.getParameter("formBodega:txtNombre");
       String bodegaDireccion  = request.getParameter("formBodega:txtDireccion"); 
       String bodegaTelefono = request.getParameter("formBodega:txtTelefono");
       int bodegaPais  = Integer.parseInt(request.getParameter("formBodega:idpais"));
        AccessBodega accessBodega= new AccessBodega();
        Bodega b= new Bodega();
        b.setBodegaCod(null);
        b.setBodegaNombre(bodegaNombre);
        b.setBodegaDireccion(bodegaDireccion);
        b.setBodegaTelefono(bodegaTelefono);
        Pais pais= new Pais();
        pais.setPaisCod(bodegaPais);        
        b.setPais(pais);
        accessBodega.insertarBodega(b);
        
    }
}
