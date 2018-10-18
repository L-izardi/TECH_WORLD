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
public class Usuario {
    
    private int usuario_cod;
    private int usuario_funcion_cod;
    private String usuario_nombre;
    private String usuario_apellido;
    private String usuario_nick;
    private String usuario_pass;

    public Usuario(){

    }
    public Usuario(int usuario_cod, int usuario_funcion_cod, String usuario_nombre, String usuario_apellido, String usuario_nick, String usuario_pass){
    	this.usuario_cod=usuario_cod;
    	this.usuario_funcion_cod=usuario_funcion_cod;
    	this.usuario_nombre=usuario_nombre;
    	this.usuario_apellido=usuario_apellido;
    	this.usuario_nick=usuario_nick;
    	this.usuario_pass=usuario_pass;
    }

    public int getUsuario_cod() {
        return usuario_cod;
    }

    public void setUsuario_cod(int usuario_cod) {
        this.usuario_cod = usuario_cod;
    }

    public int getUsuario_funcion_cod() {
        return usuario_funcion_cod;
    }

    public void setUsuario_funcion_cod(int usuario_funcion_cod) {
        this.usuario_funcion_cod = usuario_funcion_cod;
    }

    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    public String getUsuario_apellido() {
        return usuario_apellido;
    }

    public void setUsuario_apellido(String usuario_apellido) {
        this.usuario_apellido = usuario_apellido;
    }

    public String getUsuario_nick() {
        return usuario_nick;
    }

    public void setUsuario_nick(String usuario_nick) {
        this.usuario_nick = usuario_nick;
    }

    public String getUsuario_pass() {
        return usuario_pass;
    }

    public void setUsuario_pass(String usuario_pass) {
        this.usuario_pass = usuario_pass;
    }
    
}
