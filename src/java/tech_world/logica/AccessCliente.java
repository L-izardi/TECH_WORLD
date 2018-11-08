/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.logica;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tech_world.dao.Cliente;
import tech_world.utils.HibernateUtil;

/**
 *
 * @author soporte
 */
public class AccessCliente {
    
    private Session session = null;
    
    public AccessCliente(){
        if(session==null){
            this.session=HibernateUtil
                    .getSessionFactory()
                    .getCurrentSession();
        }
    }
    
    public Cliente verificarDatos(Cliente cliente) throws Exception{
        Cliente cli = null; 
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            String hql ="FROM Cliente WHERE cliente_email = '" + cliente.getClienteEmail()
                        +"' and cliente_pass = '" + cliente.getClientePass() + "'";
           
            Query query = session.createQuery(hql);

            if(!query.list().isEmpty()){
                cli = (Cliente) query.list().get(0);
            

        }}catch(Exception e){
                throw e;
            }
        return cli;
    }
    
    public Cliente getClientePorCorreo(String correo)
    {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql ="FROM Cliente WHERE cliente_email = '" + correo + "'";
            Cliente cliente = (Cliente)session.createQuery(hql).uniqueResult();
            return cliente;
        }
        catch(HibernateException ex){
            throw new HibernateException(ex);
        }
        finally{
            if(session!=null){
                session.close();
            }
        }  
    }
    
    public void insertarCliente(Cliente nuevoCliente){
        try{
        Transaction tx= session.beginTransaction();

        session.save(nuevoCliente);
        tx.commit();
        }catch(Exception e){
           e.printStackTrace();
       }
   }
        
       public void modificarCliente(Cliente editarCliente){
           try{
            Transaction tx= session.beginTransaction();

            session.update(editarCliente);
            tx.commit();
            }catch(Exception e){
               e.printStackTrace();
           }
       }
       
       public boolean editar(Cliente cliente){
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(cliente);
            session.getTransaction().commit();
            return true;
        }
        catch(HibernateException ex){
            return false;
        }
        finally{
            if(session!=null){
                session.close();
            }
        }
    }
       
        public boolean validarCorreo(String correo) throws Exception{
            try{
                session = HibernateUtil.getSessionFactory().openSession();
                String hql ="FROM Cliente WHERE cliente_email = '" + correo + "'";

                Query query = session.createQuery(hql);

                if(!query.list().isEmpty()){                    
                    return true;
                }
                else{
                    return false;
                }
            }
            catch(HibernateException e){
                return false;
            }
        }
       
}
