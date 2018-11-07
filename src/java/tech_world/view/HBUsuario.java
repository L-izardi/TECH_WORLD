/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.view;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import tech_world.dao.Funcion;
import tech_world.dao.Usuario;
import tech_world.logica.AccessUsuario;

/**
 *
 * @author Mynor
 */
@ManagedBean(name = "mbusuario")
@RequestScoped
public class HBUsuario {

    private List<Usuario> ListUsuario;
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
    
    public List<Usuario> getUsuarios() {
        AccessUsuario accessUsuario = new AccessUsuario();
        ListUsuario= accessUsuario.getUsuario();
        return ListUsuario;
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
        return "login.xhtml?faces-redirect=true";
    } 
    public void nuevoUsuario(){
       HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
       String usuarioNombre = request.getParameter("formUsuario:nombre");
       String usuarioApellido  = request.getParameter("formUsuario:apellido"); 
       String usuarioNick = request.getParameter("formUsuario:nick");
       String usuarioPass  = request.getParameter("formUsuario:pass");
       int idFuncion  = Integer.parseInt(request.getParameter("formUsuario:idFuncion"));
       AccessUsuario accessUsuario = new AccessUsuario();
       Usuario u= new Usuario();
       u.setUsuarioNombre(usuarioNombre);
       u.setUsuarioApellido(usuarioApellido);
       u.setUsuarioNick(usuarioNick);
       u.setUsuarioPass(usuarioPass);
       Funcion funcion= new Funcion();
       funcion.setFuncionCod(idFuncion);
       u.setFuncion(funcion);
       
       accessUsuario.insertarUsuario(u);
        
    }
}
