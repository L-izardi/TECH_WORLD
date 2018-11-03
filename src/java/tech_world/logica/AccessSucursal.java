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
import tech_world.dao.Sucursal;
import tech_world.utils.HibernateUtil;

/**
 *
 * @author Lizardi Alarcon
 */
public class AccessSucursal {
    
    
    Session session=null;
    //Acceso A categoria

    public AccessSucursal() {
        if(this.session==null){
            this.session=HibernateUtil
                    .getSessionFactory()
                    .getCurrentSession();
        }
    }
        
    public List getSucursal(){
       List<Sucursal>listSucursal=null;
       try{
       Transaction tx= session.beginTransaction();
       Query q=session.createQuery("from Sucursal");
       listSucursal=(List<Sucursal>)q.list();
       tx.commit();
       }catch(Exception e){
           e.printStackTrace();
       }
       return listSucursal;
    }

public void insertar(Sucursal nuevaSucursal){
        try{
        Transaction tx= session.beginTransaction();
        
        session.save(nuevaSucursal);
        tx.commit();
        }catch(Exception e){
           e.printStackTrace();
       }
    }
}
