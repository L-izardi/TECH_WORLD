/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.logica;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tech_world.dao.Proveedor;
import tech_world.utils.HibernateUtil;

/**
 *
 * @author Lizardi Alarcon
 */
public class AccessProveedor {
    
    Session session = null;
    public AccessProveedor(){
        if(session==null){
            this.session=HibernateUtil
                    .getSessionFactory()
                    .getCurrentSession();
        }
    }
    public List getProveedores(){
       
     
       List<Proveedor>listProveedor=null;
       try{
       Transaction tx= session.beginTransaction();
       Query q=session.createQuery("from Proveedor");
       listProveedor=(List<Proveedor>)q.list();
       tx.commit();
       }catch(Exception e){
           e.printStackTrace();
       }
       return listProveedor;
    }
    public void eliminarProveedor(){
        try{
       Transaction tx= session.beginTransaction();
       Query q=session.createQuery("from Proveedor");
       tx.commit();
       }catch(Exception e){
           e.printStackTrace();
       }
    } 
    
    public void insertarProveedor(Proveedor nuevoProveedor){
        try{
        Transaction tx= session.beginTransaction();
        
        session.save(nuevoProveedor);
        tx.commit();
        }catch(Exception e){
           e.printStackTrace();
       }
    }
}
