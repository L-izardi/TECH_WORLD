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
public class Detalle_Orden {
    private int do_cod;
    private int do_oc_cod;
    private int do_producto_cod;
    private int do_cantidad;
    private float do_precio;

    public Detalle_Orden(){

    }
    public Detalle_Orden(int do_cod, int do_oc_cod, int do_producto_cod, int do_cantidad, float do_precio){
    	this.do_cod=do_cod;
    	this.do_oc_cod=do_oc_cod;
    	this.do_producto_cod=do_producto_cod;
    	this.do_cantidad=do_cantidad;
    	this.do_precio=do_precio;
    }

    public int getDo_cod() {
        return do_cod;
    }

    public void setDo_cod(int do_cod) {
        this.do_cod = do_cod;
    }

    public int getDo_oc_cod() {
        return do_oc_cod;
    }

    public void setDo_oc_cod(int do_oc_cod) {
        this.do_oc_cod = do_oc_cod;
    }

    public int getDo_producto_cod() {
        return do_producto_cod;
    }

    public void setDo_producto_cod(int do_producto_cod) {
        this.do_producto_cod = do_producto_cod;
    }

    public int getDo_cantidad() {
        return do_cantidad;
    }

    public void setDo_cantidad(int do_cantidad) {
        this.do_cantidad = do_cantidad;
    }

    public float getDo_precio() {
        return do_precio;
    }

    public void setDo_precio(float do_precio) {
        this.do_precio = do_precio;
    }
    
}
