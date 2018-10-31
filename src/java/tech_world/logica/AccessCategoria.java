/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.logica;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;
import tech_world.dao.Categoria;
import org.hibernate.Session;
import tech_world.utils.HibernateUtil;

/**
 *
 * @author Lizardi Alarcon
 */
public class AccessCategoria {
      
    Session session=null;
    //Acceso A categoria

    public AccessCategoria() {
        if(this.session==null){
            this.session=HibernateUtil
                    .getSessionFactory()
                    .getCurrentSession();
        }
    }
        
    public List getCategoria(){
       List<Categoria>listCategoria=null;
       try{
       Transaction tx= session.beginTransaction();
       Query q=session.createQuery("from Categoria");
       listCategoria=(List<Categoria>)q.list();
       tx.commit();
       }catch(Exception e){
           e.printStackTrace();
       }
       return listCategoria;
    }
    
    public List busCategoria(Categoria categoria){
        List<Categoria>listCategoria=null;
       try{
       Transaction tx= session.beginTransaction();
       Query q=session.createQuery("from Categoria where '"+categoria.getCategoriaDescripcion()+ "'");
       listCategoria=(List<Categoria>)q.list();
       tx.commit();
       }catch(Exception e){
           e.printStackTrace();
       }
       return listCategoria;
    }
}
