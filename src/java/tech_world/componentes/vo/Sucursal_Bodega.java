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
public class Sucursal_Bodega {
	
	private int sb_sucursal_cod;
	private int sb_bodega_cod;
	private int sb_producto_cod;
	private int sb_cantidad;

	public Sucursal_Bodega(){

	}   
	public Sucursal_Bodega(int sb_sucursal_cod,int sb_bodega_cod,int sb_producto_cod,int sb_cantidad){
		this.sb_sucursal_cod=sb_sucursal_cod;
		this.sb_bodega_cod=sb_bodega_cod;
		this.sb_producto_cod=sb_producto_cod;
		this.sb_cantidad=sb_cantidad;
	}

    public int getSb_sucursal_cod() {
        return sb_sucursal_cod;
    }

    public void setSb_sucursal_cod(int sb_sucursal_cod) {
        this.sb_sucursal_cod = sb_sucursal_cod;
    }

    public int getSb_bodega_cod() {
        return sb_bodega_cod;
    }

    public void setSb_bodega_cod(int sb_bodega_cod) {
        this.sb_bodega_cod = sb_bodega_cod;
    }

    public int getSb_producto_cod() {
        return sb_producto_cod;
    }

    public void setSb_producto_cod(int sb_producto_cod) {
        this.sb_producto_cod = sb_producto_cod;
    }

    public int getSb_cantidad() {
        return sb_cantidad;
    }

    public void setSb_cantidad(int sb_cantidad) {
        this.sb_cantidad = sb_cantidad;
    }
        
}
