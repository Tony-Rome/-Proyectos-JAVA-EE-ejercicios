/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import mx.com.gm.sga.domain.Usuario;

/**
 *
 * @author tony
 */
@Stateless
public class UsuarioDaoImpl implements UsuarioDao{

    @PersistenceContext(unitName="PersonaPU") //No importa el nombre, persistence es para conexion con DDBB general
    EntityManager em;
    
    @Override
    public List<Usuario> findAllUsuarios() {
       return em.createNamedQuery("Usuario.findAll").getResultList();

    }
    
}
