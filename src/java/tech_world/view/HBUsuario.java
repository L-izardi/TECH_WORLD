/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import tech_world.dao.Usuario;
import tech_world.logica.AccessUsuario;

/**
 *
 * @author Mynor
 */
@ManagedBean(name = "mbusuario")
@RequestScoped
public class HBUsuario {

    /**
     * Creates a new instance of HBUsuario
     */
    public HBUsuario() {
    }
    
    private Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String verificarDatos() throws Exception{
        AccessUsuario accessUsuario = new AccessUsuario();
        Usuario usu;
        String resultado = null;
        
        try{
            //usu = AccessUsuario.verificarDatos(this.usuario);
            usu = accessUsuario.verificarDatos(this.usuario);
            if(usu !=null){
                FacesContext.getCurrentInstance().getExternalContext()
                        .getSessionMap().put("usuario", usu);
                 return "menu.xhtml?faces-redirect=true";
            }else{
                resultado = "error";
            }
        }catch(Exception e){
            throw e;
        }
        return resultado;
    }
    /**
     * Creates a new instance of HBcliente
     */
       
    public boolean verificarSesion(){
        boolean estado;
        
        if(FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("usuario") == null){
            
            estado = false;
        }else{
            this.usuario = (Usuario)FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("usuario");
            estado = true;
        }
        return estado;
    }
    
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext()
                .invalidateSession();
        return "menu.xhtml?faces-redirect=true";
    }
}
