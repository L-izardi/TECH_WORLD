/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import tech_world.dao.Cliente;
import tech_world.logica.AccessCliente;

/**
 *
 * @author soporte
 */
@ManagedBean(name = "mbcliente")
@RequestScoped
public class HBCliente {

    private Cliente cliente = new Cliente();

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public String verificarDatos() throws Exception{
        AccessCliente AccessCliente = new AccessCliente();
        Cliente cli;
        String resultado = null;
        
        try{
            cli = AccessCliente.verificarDatos(this.cliente);
            if(cli !=null){
                FacesContext.getCurrentInstance().getExternalContext()
                        .getSessionMap().put("cliente", cli);
                 return "inicio.xhtml?faces-redirect=true";
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
    public HBCliente() {
    }
    
    public boolean verificarSesion(){
        boolean estado;
        
        if(FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("cliente") == null){
            
            estado = false;
        }else{
            this.cliente = (Cliente)FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("cliente");
            estado = true;
        }
        return estado;
    }
    
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext()
                .invalidateSession();
        return "index?faces-redirect=true";
    }
}

