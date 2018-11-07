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
import tech_world.dao.Bodega;
import tech_world.utils.HibernateUtil;

/**
 *
 * @author Lizardi Alarcon
 */
public class AccessBodega {
    
    Session session = null;
    public AccessBodega(){
        if(session==null){
            this.session=HibernateUtil
                    .getSessionFactory()
                    .getCurrentSession();
        }
    }
    public List getBodegas(){
       
     
       List<Bodega>listBodegas=null;
       try{
           this.session=HibernateUtil
                    .getSessionFactory().openSession();
       Transaction tx= session.beginTransaction();
       Query q=session.createQuery("from Bodega");
       listBodegas=(List<Bodega>)q.list();
       tx.commit();
       }catch(Exception e){
           e.printStackTrace();
       }
       return listBodegas;
    }
    public void eliminarBodega(){
        try{
       Transaction tx= session.beginTransaction();
       Query q=session.createQuery("from Bodega");
       tx.commit();
       }catch(Exception e){
           e.printStackTrace();
       }
    } 
    
    public void insertarBodega(Bodega nuevaBodega){
        try{
        Transaction tx= session.beginTransaction();
        
        session.save(nuevaBodega);
        tx.commit();
        }catch(Exception e){
           e.printStackTrace();
       }
    }
}
