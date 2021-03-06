package tech_world.dao;
// Generated 31/10/2018 08:33:28 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Marca generated by hbm2java
 */
public class Marca  implements java.io.Serializable {


     private Integer marcaCod;
     private String nombre;
     private Set productos = new HashSet(0);

    public Marca() {
    }

    public Marca(String nombre, Set productos) {
       this.nombre = nombre;
       this.productos = productos;
    }
   
    public Integer getMarcaCod() {
        return this.marcaCod;
    }
    
    public void setMarcaCod(Integer marcaCod) {
        this.marcaCod = marcaCod;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getProductos() {
        return this.productos;
    }
    
    public void setProductos(Set productos) {
        this.productos = productos;
    }




}


