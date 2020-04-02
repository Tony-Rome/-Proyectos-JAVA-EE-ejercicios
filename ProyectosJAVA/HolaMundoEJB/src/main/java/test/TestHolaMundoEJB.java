/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.HolaMundoEJVRemote;
import javax.naming.*;

/**
 *
 * @author tony
 */
public class TestHolaMundoEJB {
    public static void main(String[] args){
        System.out.println("Iniciando llamado al EJB desde el cliente\n");
        try{
            //Ubica componente lado servidor
            Context jndi = new InitialContext();
            
            //Lado del cliente
            //Se rescata el REMOTE del servidor, ruta en verde
            //Se debe hacer un casteo ya que el PATH devuelve un Object
            //Path accede a los archivos paquete beans a través de la apliccaion glassfish (lado servidor)
            HolaMundoEJVRemote holaMundoEJB = (HolaMundoEJVRemote) jndi.lookup("java:global/HolaMundoEJB/HolaMundoEJVImpl!beans.HolaMundoEJVRemote");
            int resultado = holaMundoEJB.sumar(5, 8);
            System.out.println("Resultado EJB suma de 5 + 8: " + resultado);
        }
        catch(NamingException e){
            e.printStackTrace(System.out);
        }
    }
            
}
