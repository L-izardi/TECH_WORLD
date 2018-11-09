/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.view;

import javax.faces.application.FacesMessage;
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
                 return "categorias.xhtml?faces-redirect=true";
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Datos incorrectos.",""));
                return "index.xhtml?faces-redirect=false";
                
            }
        }catch(Exception e){
            throw e;
        }
        //return resultado;
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
    
    public String recuperarPassword(){
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        
        String Correo = request.getParameter("formRecuperarPass:correo");
        AccessCliente accessCliente = new AccessCliente();
        FacesContext context = FacesContext.getCurrentInstance();
        try{            
            context.getExternalContext().getFlash().setKeepMessages(true);
            if(accessCliente.validarCorreo(Correo)){
                EnviarCorreo correo = new EnviarCorreo();
                String usuario = "soporte.techworld@gmail.com";
                String password = "Tech-World2019";
                String smtpHost = "smtp.gmail.com";
                String puerto = "587"; 
                String asunto = "Recuperar contraseña Tech-World";
                String nuevoPassword = "123456789";
                Cliente c = accessCliente.getClientePorCorreo(Correo);
                c.setClientePass(nuevoPassword);
                if(accessCliente.editar(c)){
                    String mensaje = "Hola " +c.getClienteNick()+"!! Tu nueva contraseña es " + nuevoPassword;
                    correo.enviarCorreo(usuario , password, smtpHost, puerto, Correo, "", "", asunto, mensaje, "");
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Se envió correo con su nueva contraseña.",""));
                    return "index.xhtml?faces-redirect=true";
                }
                else{
                    System.out.println("No se pudo editar el cliente");
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "No se pudo reestablecer la contraseña.",""));
                    return "Recuperar_Password.xhtml?faces-redirect=true";
                } 
            }
            else{
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Correo invalido.",""));
                return "Recuperar_Password.xhtml?faces-redirect=true";
            }
        }
        catch(Exception ex){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "No se pudo reestablecer la contraseña.",""));
            ex.printStackTrace();
            return "Recuperar_Password.xhtml?faces-redirect=true";
        }
    }
    
    public void modificarCliente(){
       try{
       HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
       
       int ClienteCod = Integer.parseInt(request.getParameter("formUpdateCliente:txtId"));       
       String ClienteUsuario = request.getParameter("formUpdateCliente:txtNick");
       String ClienteNombre = request.getParameter("formUpdateCliente:txtNombre");
       String ClienteApellido = request.getParameter("formUpdateCliente:txtApellido");
       long ClienteDPI = Long.valueOf(request.getParameter("formUpdateCliente:txtDpi"));
       String ClienteCorreo = request.getParameter("formUpdateCliente:txtEmail");
       String ClientePassword = request.getParameter("formUpdateCliente:txtContraseña");
       
       AccessCliente accessCliente = new AccessCliente();
       Cliente cli = new Cliente();
       cli.setClienteCod(ClienteCod);
       cli.setClienteNick(ClienteUsuario);
       cli.setClienteNombre(ClienteNombre);
       cli.setClienteApellido(ClienteApellido);
       cli.setClienteDpi(ClienteDPI);
       cli.setClienteEmail(ClienteCorreo);
       cli.setClientePass(ClientePassword);
       accessCliente.editar(cli);
       
       }catch(Exception e){
           
       }
    }
    
}

