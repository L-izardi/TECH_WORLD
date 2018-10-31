/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.logica;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import tech_world.dao.Cliente;
import tech_world.utils.HibernateUtil;

/**
 *
 * @author soporte
 */
public class AccessCliente {
    
    private Session session = null;
    
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
}
