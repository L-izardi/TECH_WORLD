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
public class Producto_Bodega {
 	
 	private int pb_producto_cod;
 	private int pb_bodega_cod;
 	private int pb_cantidad;

 	public Producto_Bodega(){

 	}
 	public Producto_Bodega(int pb_producto_cod,int pb_bodega_cod, int pb_cantidad){
 	this.pb_producto_cod=pb_producto_cod;
 	this.pb_bodega_cod=pb_bodega_cod;
 	this.pb_cantidad=pb_cantidad;
 	}

    public int getPb_producto_cod() {
        return pb_producto_cod;
    }

    public void setPb_producto_cod(int pb_producto_cod) {
        this.pb_producto_cod = pb_producto_cod;
    }

    public int getPb_bodega_cod() {
        return pb_bodega_cod;
    }

    public void setPb_bodega_cod(int pb_bodega_cod) {
        this.pb_bodega_cod = pb_bodega_cod;
    }

    public int getPb_cantidad() {
        return pb_cantidad;
    }

    public void setPb_cantidad(int pb_cantidad) {
        this.pb_cantidad = pb_cantidad;
    }
        
}
