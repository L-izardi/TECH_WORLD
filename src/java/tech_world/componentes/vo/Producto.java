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
public class Producto {
    
    private int producto_cod;
    private String producto_nombre;
    private int producto_categoria_cod;
    private int producto_marca_cod;
    private String producto_imagen;
    private float producto_precio;
    private String producto_garantia;

    public Producto(){

    }
    public Producto(int producto_cod, String producto_nombre,int producto_categoria_cod,int producto_marca_cod,String producto_imagen, float producto_precio, String producto_garantia){
    	this.producto_cod=producto_cod;
    	this.producto_nombre=producto_nombre;
    	this.producto_categoria_cod=producto_categoria_cod;
    	this.producto_marca_cod=producto_marca_cod;
    	this.producto_imagen=producto_imagen;
    	this.producto_precio=producto_precio;
    	this.producto_garantia=producto_garantia;
    }

    public int getProducto_cod() {
        return producto_cod;
    }

    public void setProducto_cod(int producto_cod) {
        this.producto_cod = producto_cod;
    }

    public String getProducto_nombre() {
        return producto_nombre;
    }

    public void setProducto_nombre(String producto_nombre) {
        this.producto_nombre = producto_nombre;
    }

    public int getProducto_categoria_cod() {
        return producto_categoria_cod;
    }

    public void setProducto_categoria_cod(int producto_categoria_cod) {
        this.producto_categoria_cod = producto_categoria_cod;
    }

    public int getProducto_marca_cod() {
        return producto_marca_cod;
    }

    public void setProducto_marca_cod(int producto_marca_cod) {
        this.producto_marca_cod = producto_marca_cod;
    }

    public String getProducto_imagen() {
        return producto_imagen;
    }

    public void setProducto_imagen(String producto_imagen) {
        this.producto_imagen = producto_imagen;
    }

    public float getProducto_precio() {
        return producto_precio;
    }

    public void setProducto_precio(float producto_precio) {
        this.producto_precio = producto_precio;
    }

    public String getProducto_garantia() {
        return producto_garantia;
    }

    public void setProducto_garantia(String producto_garantia) {
        this.producto_garantia = producto_garantia;
    }
    
}
