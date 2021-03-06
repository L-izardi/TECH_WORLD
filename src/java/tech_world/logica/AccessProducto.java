/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.logica;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tech_world.dao.Categoria;
import tech_world.dao.Producto;
import tech_world.utils.HibernateUtil;

/**
 *
 * @author Lizardi Alarcon
 */
public class AccessProducto {
    
    Session session=null;
    //Acceso A productoss

    public AccessProducto() {
        if(this.session==null){
            this.session=HibernateUtil
                    .getSessionFactory()
                    .getCurrentSession();
        }
    }
        
    public List getProducto(){
       List<Producto>listProductos=null;
       try{
            this.session=HibernateUtil
                    .getSessionFactory().openSession();
       Transaction tx= session.beginTransaction();
       
       Query q=session.createQuery("from Producto");
       listProductos=(List<Producto>)q.list();
       tx.commit();
       }catch(Exception e){
           e.printStackTrace();
       }
       return listProductos;
    }
    
    public List selectCategoria(int ct){
        List<Producto>listProductos=null;
       try{
            this.session=HibernateUtil
                    .getSessionFactory().openSession();
            Transaction tx= session.beginTransaction();
       
            Query q=session.createQuery("from Producto where producto_categoria_cod = " + ct);
            listProductos=(List<Producto>)q.list();
            tx.commit();
       }catch(Exception e){
           e.printStackTrace();
       }
       return listProductos;
    }
     public void insertarProducto(Producto producto){
        try{
        Transaction tx= session.beginTransaction();
        
        session.save(producto);
        tx.commit();
        }catch(Exception e){
           e.printStackTrace();
       }
    }
}
