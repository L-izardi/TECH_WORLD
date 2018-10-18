/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.componentes.vo;

/**
 *
 * @author Lizardi Alarcon
 */
public class Cliente {
    private int cliente_cod;
    private String cliente_nombre;
    private String cliente_apellido;
    private int cliente_dpi;
    private String cliente_nick;
    private String cliente_pass;
    private String cliente_email;
    
    public Cliente(){
        
    }
    public Cliente(int cliente_cod,String cliente_nombre,String cliente_apellido,int cliente_dpi,String cliente_nick,String cliente_pass,String cliente_email){
        this.cliente_cod=cliente_cod;
        this.cliente_nombre=cliente_nombre;
        this.cliente_apellido=cliente_apellido;
        this.cliente_dpi=cliente_dpi;
        this.cliente_nick=cliente_nick;
        this.cliente_pass=cliente_pass;
        this.cliente_email=cliente_email;
    }

    public int getCliente_cod() {
        return cliente_cod;
    }
     
    public void setCliente_cod(int cliente_cod) {
        this.cliente_cod = cliente_cod;
    }

    public String getCliente_nombre() {
        return cliente_nombre;
    }
     
    public void setCliente_nombre(String cliente_nombre) {
        this.cliente_nombre = cliente_nombre;
    }

    public String getCliente_apellido() {
        return cliente_apellido;
    }
     
    public void setCliente_apellido(String cliente_apellido) {
        this.cliente_apellido = cliente_apellido;
    }

    public int getCliente_dpi() {
        return cliente_dpi;
    }
     
    public void setCliente_dpi(int cliente_dpi) {
        this.cliente_dpi = cliente_dpi;
    }

    public String getCliente_nick() {
        return cliente_nick;
    }
     
    public void setCliente_nick(String cliente_nick) {
        this.cliente_nick = cliente_nick;
    }

    public String  getCliente_pass() {
        return cliente_pass;
    }
     
    public void setCliente_pass(String cliente_pass) {
        this.cliente_pass = cliente_pass;
    }

    public String getCliente_email() {
        return cliente_email;
    }
     
    public void setCliente_email(String cliente_email) {
        this.cliente_email = cliente_email;
    }
}
