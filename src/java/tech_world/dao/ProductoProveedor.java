package tech_world.dao;
// Generated 29/10/2018 09:18:53 PM by Hibernate Tools 4.3.1



/**
 * ProductoProveedor generated by hbm2java
 */
public class ProductoProveedor  implements java.io.Serializable {


     private ProductoProveedorId id;
     private Producto producto;
     private Proveedor proveedor;

    public ProductoProveedor() {
    }

    public ProductoProveedor(ProductoProveedorId id, Producto producto, Proveedor proveedor) {
       this.id = id;
       this.producto = producto;
       this.proveedor = proveedor;
    }
   
    public ProductoProveedorId getId() {
        return this.id;
    }
    
    public void setId(ProductoProveedorId id) {
        this.id = id;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Proveedor getProveedor() {
        return this.proveedor;
    }
    
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }




}

