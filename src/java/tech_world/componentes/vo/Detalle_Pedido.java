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
public class Detalle_Pedido {
    
    private int dp_cod;
    private int dp_pedido_cod;
    private int dp_cantidad;
    private String dp_garantiaInicio;
    private String dp_garantiaFinal;

    public Detalle_Pedido(){

    }
    public Detalle_Pedido(int dp_cod, int dp_pedido_cod, int dp_cantidad, String dp_garantiaInicio,String dp_garantiaFinal){
    	this.dp_cod=dp_cod;
    	this.dp_pedido_cod=dp_pedido_cod;
    	this.dp_cantidad=dp_cantidad;
    	this.dp_garantiaInicio=dp_garantiaInicio;
    	this.dp_garantiaFinal=dp_garantiaFinal;
    }

    public int getDp_cod() {
        return dp_cod;
    }

    public void setDp_cod(int dp_cod) {
        this.dp_cod = dp_cod;
    }

    public int getDp_pedido_cod() {
        return dp_pedido_cod;
    }

    public void setDp_pedido_cod(int dp_pedido_cod) {
        this.dp_pedido_cod = dp_pedido_cod;
    }

    public int getDp_cantidad() {
        return dp_cantidad;
    }

    public void setDp_cantidad(int dp_cantidad) {
        this.dp_cantidad = dp_cantidad;
    }

    public String getDp_garantiaInicio() {
        return dp_garantiaInicio;
    }

    public void setDp_garantiaInicio(String dp_garantiaInicio) {
        this.dp_garantiaInicio = dp_garantiaInicio;
    }

    public String getDp_garantiaFinal() {
        return dp_garantiaFinal;
    }

    public void setDp_garantiaFinal(String dp_garantiaFinal) {
        this.dp_garantiaFinal = dp_garantiaFinal;
    }

}
