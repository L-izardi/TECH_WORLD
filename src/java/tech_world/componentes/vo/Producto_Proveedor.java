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
public class Producto_Proveedor {
    
    private int pp_producto_cod;
    private int pp_proveedor_cod;

    public Producto_Proveedor(){

    }
    public Producto_Proveedor(int pp_producto_cod, int pp_proveedor_cod){
    	this.pp_producto_cod=pp_producto_cod;
    	this.pp_proveedor_cod=pp_proveedor_cod;
    }

    public int getPp_producto_cod() {
        return pp_producto_cod;
    }

    public void setPp_producto_cod(int pp_producto_cod) {
        this.pp_producto_cod = pp_producto_cod;
    }

    public int getPp_proveedor_cod() {
        return pp_proveedor_cod;
    }

    public void setPp_proveedor_cod(int pp_proveedor_cod) {
        this.pp_proveedor_cod = pp_proveedor_cod;
    }
    
}
