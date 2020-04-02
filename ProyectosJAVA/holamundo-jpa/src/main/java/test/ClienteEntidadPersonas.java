/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.persistence.*;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

/**
 *
 * @author tony
 */
public class ClienteEntidadPersonas {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Inicia transaccion
        tx.begin();
        
        //No se debe especificar ID de la DDBB
        Persona persona1 = new Persona("Maria","Gutierrez","mgutierrez@email.com","33333333");
        log.debug("Objeto a persistir: " + persona1);
        
        //Persisitir objeto a base de datos
        em.persist(persona1);
        
        //Se termina cuando se hace commit
        //Se genera la llave privada
        tx.commit();
        log.debug("Objeto persistido: " + persona1);
        
        //llama em para ceerrar
        em.close();
    }
}
