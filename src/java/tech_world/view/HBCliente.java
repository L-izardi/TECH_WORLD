/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import tech_world.dao.Cliente;
import tech_world.logica.AccessCliente;
import tech_world.logica.EnviarCorreo;

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
    
    public void nuevoCliente(){
       HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
       
       String ClienteNombre = request.getParameter("formCliente:nombre");
       String ClienteApellido = request.getParameter("formCliente:apellido");
       long ClienteDPI = Long.valueOf(request.getParameter("formCliente:DPI"));
       String ClienteUsuario = request.getParameter("formCliente:usuario");
       String ClienteCorreo = request.getParameter("formCliente:correo");
       String ClientePassword = request.getParameter("formCliente:password");
       
       AccessCliente accessCliente = new AccessCliente();
       Cliente cli = new Cliente();
       cli.setClienteCod(null);
       cli.setClienteNombre(ClienteNombre);
       cli.setClienteApellido(ClienteApellido);
       cli.setClienteDpi(ClienteDPI);
       cli.setClienteNick(ClienteUsuario);
       cli.setClienteEmail(ClienteCorreo);
       cli.setClientePass(ClientePassword);
       accessCliente.insertarCliente(cli);
    }
    
    public void recuperarPassword(){
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        
        String Correo = request.getParameter("formRecuperarPass:correo");
        EnviarCorreo correo = new EnviarCorreo();
        
        String usuario = "soporte.techworld@gmail.com";
        String password = "Tech-World2018";
        String smtpHost = "smtp.gmail.com";
        String puerto = "587"; 
        String asunto = "Recuperar contraseña";
        String mensaje = "Este es un correo de prueba";
        
        correo.enviarCorreo(usuario , password, smtpHost, puerto, Correo, "", "", asunto, mensaje, "");
        
    }
    
}

