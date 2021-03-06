package tech_world.dao;
// Generated 31/10/2018 08:33:28 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Producto generated by hbm2java
 */
public class Producto  implements java.io.Serializable {


     private Integer productoCod;
     private Categoria categoria;
     private Marca marca;
     private String productoNombre;
     private String productoImagen;
     private Float productoPrecio;
     private String productoGarantia;
     private Set detalleOrdens = new HashSet(0);
     private Set detallePedidos = new HashSet(0);
     private Set detalleIngresos = new HashSet(0);
     private Set productoBodegas = new HashSet(0);
     private Set productoProveedors = new HashSet(0);

    public Producto() {
    }

	
    public Producto(Categoria categoria, Marca marca) {
        this.categoria = categoria;
        this.marca = marca;
    }
    public Producto(Categoria categoria, Marca marca, String productoNombre, String productoImagen, Float productoPrecio, String productoGarantia, Set detalleOrdens, Set detallePedidos, Set detalleIngresos, Set productoBodegas, Set productoProveedors) {
       this.categoria = categoria;
       this.marca = marca;
       this.productoNombre = productoNombre;
       this.productoImagen = productoImagen;
       this.productoPrecio = productoPrecio;
       this.productoGarantia = productoGarantia;
       this.detalleOrdens = detalleOrdens;
       this.detallePedidos = detallePedidos;
       this.detalleIngresos = detalleIngresos;
       this.productoBodegas = productoBodegas;
       this.productoProveedors = productoProveedors;
    }
   
    public Integer getProductoCod() {
        return this.productoCod;
    }
    
    public void setProductoCod(Integer productoCod) {
        this.productoCod = productoCod;
    }
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public Marca getMarca() {
        return this.marca;
    }
    
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    public String getProductoNombre() {
        return this.productoNombre;
    }
    
    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }
    public String getProductoImagen() {
        return this.productoImagen;
    }
    
    public void setProductoImagen(String productoImagen) {
        this.productoImagen = productoImagen;
    }
    public Float getProductoPrecio() {
        return this.productoPrecio;
    }
    
    public void setProductoPrecio(Float productoPrecio) {
        this.productoPrecio = productoPrecio;
    }
    public String getProductoGarantia() {
        return this.productoGarantia;
    }
    
    public void setProductoGarantia(String productoGarantia) {
        this.productoGarantia = productoGarantia;
    }
    public Set getDetalleOrdens() {
        return this.detalleOrdens;
    }
    
    public void setDetalleOrdens(Set detalleOrdens) {
        this.detalleOrdens = detalleOrdens;
    }
    public Set getDetallePedidos() {
        return this.detallePedidos;
    }
    
    public void setDetallePedidos(Set detallePedidos) {
        this.detallePedidos = detallePedidos;
    }
    public Set getDetalleIngresos() {
        return this.detalleIngresos;
    }
    
    public void setDetalleIngresos(Set detalleIngresos) {
        this.detalleIngresos = detalleIngresos;
    }
    public Set getProductoBodegas() {
        return this.productoBodegas;
    }
    
    public void setProductoBodegas(Set productoBodegas) {
        this.productoBodegas = productoBodegas;
    }
    public Set getProductoProveedors() {
        return this.productoProveedors;
    }
    
    public void setProductoProveedors(Set productoProveedors) {
        this.productoProveedors = productoProveedors;
    }




}


