/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.componentes.vo;

import java.util.Date;

/**
 *
 * @author Lizardi Alarcon
 */
public class Orden_Compra {
    
    private int oc_cod;
    private int oc_empleado_cod;
    private int oc_proveedor_cod;
    private Date oc_fecha;
    private float oc_precioTotal;

    public Orden_Compra(){

    }
    public Orden_Compra(int oc_cod, int oc_empleado_cod, int oc_proveedor_cod, Date oc_fecha, float oc_precioTotal){
    	this.oc_cod=oc_cod;
    	this.oc_empleado_cod=oc_empleado_cod;
    	this.oc_proveedor_cod=oc_proveedor_cod;
    	this.oc_fecha=oc_fecha;
    	this.oc_precioTotal=oc_precioTotal;
    }

    public int getOc_cod() {
        return oc_cod;
    }

    public void setOc_cod(int oc_cod) {
        this.oc_cod = oc_cod;
    }

    public int getOc_empleado_cod() {
        return oc_empleado_cod;
    }

    public void setOc_empleado_cod(int oc_empleado_cod) {
        this.oc_empleado_cod = oc_empleado_cod;
    }

    public int getOc_proveedor_cod() {
        return oc_proveedor_cod;
    }

    public void setOc_proveedor_cod(int oc_proveedor_cod) {
        this.oc_proveedor_cod = oc_proveedor_cod;
    }

    public Date getOc_fecha() {
        return oc_fecha;
    }

    public void setOc_fecha(Date oc_fecha) {
        this.oc_fecha = oc_fecha;
    }

    public float getOc_precioTotal() {
        return oc_precioTotal;
    }

    public void setOc_precioTotal(float oc_precioTotal) {
        this.oc_precioTotal = oc_precioTotal;
    }
    
}
