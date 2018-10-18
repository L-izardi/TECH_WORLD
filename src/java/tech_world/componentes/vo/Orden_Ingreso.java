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
public class Orden_Ingreso {
    
    private int oi_cod;
    private int oi_bodega_cod;
    private Date oi_fechaIngreso;

    public Orden_Ingreso(){

    }
    public Orden_Ingreso(int oi_cod, int oi_bodega_cod, Date oi_fechaIngreso){
    	this.oi_cod=oi_cod;
    	this.oi_bodega_cod=oi_bodega_cod;
    	this.oi_fechaIngreso=oi_fechaIngreso;
    }

    public int getOi_cod() {
        return oi_cod;
    }

    public void setOi_cod(int oi_cod) {
        this.oi_cod = oi_cod;
    }

    public int getOi_bodega_cod() {
        return oi_bodega_cod;
    }

    public void setOi_bodega_cod(int oi_bodega_cod) {
        this.oi_bodega_cod = oi_bodega_cod;
    }

    public Date getOi_fechaIngreso() {
        return oi_fechaIngreso;
    }

    public void setOi_fechaIngreso(Date oi_fechaIngreso) {
        this.oi_fechaIngreso = oi_fechaIngreso;
    }
    
}
