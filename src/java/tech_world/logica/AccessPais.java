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
import tech_world.dao.Pais;
import tech_world.utils.HibernateUtil;

/**
 *
 * @author Lizardi Alarcon
 */
public class AccessPais {
 
     Session session = null;
    public AccessPais(){
        if(session==null){
            this.session=HibernateUtil
                    .getSessionFactory()
                    .getCurrentSession();
        }
    }
    public List getPais(){       
       List<Pais>listPais=null;
       try{
       Transaction tx= session.beginTransaction();
       Query q=session.createQuery("from Pais");
       listPais=q.list();
       tx.commit();
       }catch(Exception e){
           e.printStackTrace();
       }
       return listPais;
    }
    
    public void insertar(Pais nuevoPais){
        try{
        Transaction tx= session.beginTransaction();
        
        session.save(nuevoPais);
        tx.commit();
        }catch(Exception e){
           e.printStackTrace();
       }
    }
}
