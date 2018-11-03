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
import tech_world.logica.AccessPais;

/**
 *
 * @author Lizardi Alarcon
 */
@ManagedBean(name = "mbpais")
@SessionScoped
public class HBPais {
     
    private List<SelectItem> listpais;
    private Pais pais;

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    public HBPais() {
       pais = new Pais();
    }
    public List<SelectItem> getListPaises() {        
        this.listpais= new ArrayList<SelectItem>();
        AccessPais pais = new AccessPais();
        List<Pais> p= pais.getPais();
        listpais.clear();
        
        for(Pais paises:p){
            SelectItem paisItem= new SelectItem(paises.getPaisCod(),paises.getPaisNombre());
            this.listpais.add(paisItem);
        }
        
        return listpais;
    }
    public void nuevoPais(){
       HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
       String paisNombre = request.getParameter("formPais:paisNombre");
       AccessPais accessPais= new AccessPais();
       Pais p= new Pais();
       p.setPaisCod(null);
       p.setPaisNombre(paisNombre);
       accessPais.insertar(p);
                
    }
       
}
