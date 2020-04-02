/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.PersonaJDBC;
import domain.Persona;
import java.util.List;

/**
 *
 * @author tony
 */
public class ManejoPersonas {
    
    public static void main(String[] args) {
        
        PersonaJDBC personaJDBC = new PersonaJDBC();
        //Se retorna una lista personas
        List<Persona> personas = personaJDBC.select();
        
        for (Persona persona: personas){
            //Se ejecuta automatico funcion .toString();
            System.out.println("Persona: " + persona);
        }
        
        //Define los valores al objeto y estos valores son rescatados en la funcion INSERT a traves de .getAtributo();
        
        //PRUEBA DE INSERCION
//        Persona persona = new Persona();
//        persona.setNombre("Mariano");
//        persona.setApellido("Laro");
//        persona.setEmail("mlaro@email.com");
//        persona.setTelefono("55555555");
//        
//        personaJDBC.insert(persona);


           //PRUEBA DE ACTUALIZAR
           
//          Persona persona = new Persona();
//          //Se define la ID para buscarla en DDBB y modificar
//          persona.setId_persona(3);
//          persona.setNombre("Ronaldinho");
//          persona.setApellido("Gutierrez");
//          persona.setEmail("rgutierres@email.com");
//          persona.setTelefono("33333333");
//          
//          personaJDBC.update(persona);

            //PRUEBA DE DELETE
            Persona persona = new Persona();
            persona.setId_persona(3);
            personaJDBC.delete(persona);
    }
}
