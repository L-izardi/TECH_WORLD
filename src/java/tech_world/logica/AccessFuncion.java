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
import tech_world.dao.Funcion;
import tech_world.utils.HibernateUtil;

/**
 *
 * @author Lizardi Alarcon
 */
public class AccessFuncion {
    Session session = null;
    public AccessFuncion(){
        if(session==null){
            this.session=HibernateUtil
                    .getSessionFactory()
                    .getCurrentSession();
        }
    }
    public List getFuncion(){       
       List<Funcion>listFuncion=null;
       try{
       Transaction tx= session.beginTransaction();
       Query q=session.createQuery("from Funcion");
       listFuncion=q.list();
       tx.commit();
       }catch(Exception e){
           e.printStackTrace();
       }
       return listFuncion;
    }
}
