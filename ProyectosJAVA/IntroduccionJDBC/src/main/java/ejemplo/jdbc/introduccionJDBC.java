/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.jdbc;

import java.sql.*;


/**
 *
 * @author tony
 */
public class introduccionJDBC {
    
    public static void main(String[] args) {
        //aCadena conexion a DDBB MSQL
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
        
        try {
            //Crear objeto para mapeo
            Connection conexion = DriverManager.getConnection(url, "root","1qaz2wsx3e");
            
            //Crear objeto Statement
            Statement instruccion = conexion.createStatement();//creacion de sentencia
            
            //Creacion de query
            String sql = "select id_persona, nombre, apellido, email, telefono from persona";
            
            //ejecucion de query
            
            ResultSet resultado = instruccion.executeQuery(sql); 
            
            //Procesa resultado
            //Para moverse entre registros se ocpa .next() el cursor se mueve
            while(resultado.next()){
                System.out.print("Id_Personas: " + resultado.getInt(1));
                System.out.print("Nombre: " + resultado.getString(2));
                System.out.print("Apellido: " + resultado.getString(3));
                System.out.print("email: " + resultado.getString(4));
                System.out.println("Telefono: " + resultado.getString(5));              
                
            }
            //Cerramos cada objeto que se utiliza, N de objetos puede ser infinito lo que si no se cierra dara problemas
            //En orden
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (SQLException ex) {
             ex.printStackTrace(System.out);
        }
    }
}
