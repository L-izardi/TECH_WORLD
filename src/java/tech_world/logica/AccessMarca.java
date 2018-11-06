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
import tech_world.dao.Marca;
import tech_world.utils.HibernateUtil;
/**
 *
 * @author Lizardi Alarcon
 */
public class AccessMarca {
    Session session = null;
    public AccessMarca(){
        if(session==null){
            this.session=HibernateUtil
                    .getSessionFactory()
                    .getCurrentSession();
        }
    }
    public List getMarca(){       
       List<Marca>listMarca=null;
       try{
       Transaction tx= session.beginTransaction();
       Query q=session.createQuery("from Marca");
       listMarca=q.list();
       tx.commit();
       }catch(Exception e){
           e.printStackTrace();
       }
       return listMarca;
    }
}
