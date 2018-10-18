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
public class Detalle_Ingreso {
    private int di_cod;
    private int di_oi_cod;
    private int di_producto_cod;
    private int di_cantidad;
    private String di_variacion;

    public Detalle_Ingreso(){

    }
    public Detalle_Ingreso(int di_cod, int di_oi_cod,int di_producto_cod,int di_cantidad,String di_variacion){
    	this.di_cod=di_cod;
    	this.di_oi_cod=di_oi_cod;
    	this.di_producto_cod=di_producto_cod;
    	this.di_cantidad=di_cantidad;
    	this.di_variacion=di_variacion;

    }

    public int getDi_cod() {
        return di_cod;
    }

    public void setDi_cod(int di_cod) {
        this.di_cod = di_cod;
    }

    public int getDi_oi_cod() {
        return di_oi_cod;
    }

    public void setDi_oi_cod(int di_oi_cod) {
        this.di_oi_cod = di_oi_cod;
    }

    public int getDi_producto_cod() {
        return di_producto_cod;
    }

    public void setDi_producto_cod(int di_producto_cod) {
        this.di_producto_cod = di_producto_cod;
    }

    public int getDi_cantidad() {
        return di_cantidad;
    }

    public void setDi_cantidad(int di_cantidad) {
        this.di_cantidad = di_cantidad;
    }

    public String getDi_variacion() {
        return di_variacion;
    }

    public void setDi_variacion(String di_variacion) {
        this.di_variacion = di_variacion;
    }
    
}
