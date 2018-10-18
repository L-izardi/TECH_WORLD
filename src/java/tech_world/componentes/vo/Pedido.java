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
public class Pedido {
    
    private int pedido_cod;
    private int pedido_cliente_cod;
    private int pedido_empleado_cod;
    private int pedido_sucursal_cod;
    private Date pedido_fechaCompra;
    private float pedido_precioTotal;

    public Pedido(){

    }
    public Pedido(int pedido_cod,int pedido_cliente_cod, int pedido_empleado_cod, int pedido_sucursal_cod, Date pedido_fechaCompra, float pedido_precioTotale){
    	this.pedido_cod=pedido_cod;
    	this.pedido_cliente_cod=pedido_cliente_cod;
    	this.pedido_empleado_cod=pedido_empleado_cod;
    	this.pedido_sucursal_cod=pedido_sucursal_cod;
    	this.pedido_fechaCompra=pedido_fechaCompra;
    	this.pedido_precioTotal=pedido_precioTotal;
    }

    public int getPedido_cod() {
        return pedido_cod;
    }

    public void setPedido_cod(int pedido_cod) {
        this.pedido_cod = pedido_cod;
    }

    public int getPedido_cliente_cod() {
        return pedido_cliente_cod;
    }

    public void setPedido_cliente_cod(int pedido_cliente_cod) {
        this.pedido_cliente_cod = pedido_cliente_cod;
    }

    public int getPedido_empleado_cod() {
        return pedido_empleado_cod;
    }

    public void setPedido_empleado_cod(int pedido_empleado_cod) {
        this.pedido_empleado_cod = pedido_empleado_cod;
    }

    public int getPedido_sucursal_cod() {
        return pedido_sucursal_cod;
    }

    public void setPedido_sucursal_cod(int pedido_sucursal_cod) {
        this.pedido_sucursal_cod = pedido_sucursal_cod;
    }

    public Date getPedido_fechaCompra() {
        return pedido_fechaCompra;
    }

    public void setPedido_fechaCompra(Date pedido_fechaCompra) {
        this.pedido_fechaCompra = pedido_fechaCompra;
    }

    public float getPedido_precioTotal() {
        return pedido_precioTotal;
    }

    public void setPedido_precioTotal(float pedido_precioTotal) {
        this.pedido_precioTotal = pedido_precioTotal;
    }
    
}
