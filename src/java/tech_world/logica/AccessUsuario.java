/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.logica;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tech_world.dao.Usuario;
import tech_world.utils.HibernateUtil;

/**
 *
 * @author soporte
 */
public class AccessUsuario {
    
    private Session session = null;
    
    public AccessUsuario(){
        if(session==null){
            this.session=HibernateUtil
                    .getSessionFactory()
                    .getCurrentSession();
        }
    }
    public Usuario verificarDatos(Usuario usuario) throws Exception{
    Usuario usu = null; 
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            String hql ="FROM Usuario WHERE usuario_nick = '" + usuario.getUsuarioNick()
                        +"' and usuario_pass = '" + usuario.getUsuarioPass()+ "'";
           
            Query query = session.createQuery(hql);

            if(!query.list().isEmpty()){
                usu = (Usuario) query.list().get(0);
            

        }}catch(Exception e){
                throw e;
            }
        return usu;
    }
    public List getUsuario(){
       List<Usuario>listUsuarios=null;
       try{
           this.session=HibernateUtil
                    .getSessionFactory().openSession();
       Transaction tx= session.beginTransaction();
       Query q=session.createQuery("from Usuario");
       listUsuarios=(List<Usuario>)q.list();
       tx.commit();
       }catch(Exception e){
           e.printStackTrace();
       }
       return listUsuarios;
    }
    public void insertarUsuario(Usuario nuevoUsuario){
        try{
        Transaction tx= session.beginTransaction();        
        session.save(nuevoUsuario);
        tx.commit();
        }catch(Exception e){
           e.printStackTrace();
       }
    }
}
