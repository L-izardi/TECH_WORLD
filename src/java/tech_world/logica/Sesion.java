/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.logica;

import org.hibernate.Session;
import tech_world.utils.HibernateUtil;

/**
 *
 * @author Lizardi Alarcon
 */
public class Sesion {
    
    Session session = null;

    public Sesion() {
        if(this.session==null){
            this.session=HibernateUtil
                    .getSessionFactory()
                    .getCurrentSession();
        }
    }
}
