package tech_world.dao;
// Generated 29/10/2018 09:18:53 PM by Hibernate Tools 4.3.1



/**
 * DetallePedido generated by hbm2java
 */
public class DetallePedido  implements java.io.Serializable {


     private Integer dpCod;
     private Pedido pedido;
     private Producto producto;
     private Integer dpCantidad;
     private String dpGarantiainicio;
     private String dpGarantiafinal;

    public DetallePedido() {
    }

	
    public DetallePedido(Pedido pedido, Producto producto) {
        this.pedido = pedido;
        this.producto = producto;
    }
    public DetallePedido(Pedido pedido, Producto producto, Integer dpCantidad, String dpGarantiainicio, String dpGarantiafinal) {
       this.pedido = pedido;
       this.producto = producto;
       this.dpCantidad = dpCantidad;
       this.dpGarantiainicio = dpGarantiainicio;
       this.dpGarantiafinal = dpGarantiafinal;
    }
   
    public Integer getDpCod() {
        return this.dpCod;
    }
    
    public void setDpCod(Integer dpCod) {
        this.dpCod = dpCod;
    }
    public Pedido getPedido() {
        return this.pedido;
    }
    
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Integer getDpCantidad() {
        return this.dpCantidad;
    }
    
    public void setDpCantidad(Integer dpCantidad) {
        this.dpCantidad = dpCantidad;
    }
    public String getDpGarantiainicio() {
        return this.dpGarantiainicio;
    }
    
    public void setDpGarantiainicio(String dpGarantiainicio) {
        this.dpGarantiainicio = dpGarantiainicio;
    }
    public String getDpGarantiafinal() {
        return this.dpGarantiafinal;
    }
    
    public void setDpGarantiafinal(String dpGarantiafinal) {
        this.dpGarantiafinal = dpGarantiafinal;
    }




}


