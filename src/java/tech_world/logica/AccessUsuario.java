/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.logica;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import tech_world.dao.Usuario;
import tech_world.utils.HibernateUtil;

/**
 *
 * @author soporte
 */
public class AccessUsuario {
    
    private Session session = null;
    
    public Usuario verificarDatos(Usuario usuario) throws Exception{
    Usuario usu = null; 
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            String hql ="FROM usuario WHERE usuario_nick = '" + usuario.getUsuarioNick()
                        +"' and usuario_pass = '" + usuario.getUsuarioPass()+ "'";
           
            Query query = session.createQuery(hql);

            if(!query.list().isEmpty()){
                usu = (Usuario) query.list().get(0);
            

        }}catch(Exception e){
                throw e;
            }
        return usu;
    }
}
