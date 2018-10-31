/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.view;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tech_world.dao.Cliente;
import tech_world.logica.AccessCliente;

/**
 *
 * @author Lizardi Alarcon
 */
@ManagedBean(name = "mbcliente")
@SessionScoped
public class HBCliente {
    private List<Cliente> cliente;
    /**
     * Creates a new instance of HBCliente
     */
    public HBCliente() {
    }
     public List<Cliente> getCliente() {
        AccessCliente Helper = new AccessCliente();
        cliente= Helper.getClientes();
        return cliente;
    }
    
}
