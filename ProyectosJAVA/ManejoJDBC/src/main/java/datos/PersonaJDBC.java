/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Persona;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 */
public class PersonaJDBC {
    
    //Se define las constantes queries
    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido, email, telefono) VALUES(?, ? ,? ,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=?, email=?, telefono=? WHERE id_persona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";
    
    public List<Persona> select(){
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Persona persona = null;
        //Lista de personas
        List<Persona> personas = new ArrayList<Persona>();
        
        try {
            //Retorna un DM desde clase conexion.getConnection()
            conn = Conexion.getConnection();
            
            //Inicializa sentencia
            stm = conn.prepareStatement(SQL_SELECT);
            
            //Ejecuta sentencia
            rs = stm.executeQuery();
            
            while(rs.next()){
                //Se puede especificar tanto la columna como su numero (posicion desde el 1) o su nombre
                int id_persona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                
                persona = new Persona();
                persona.setId_persona(id_persona);
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                persona.setEmail(email);
                persona.setTelefono(telefono);
                personas.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        //Bloque finally siempre se ejecuta sin excepcion
        finally{
            Conexion.close(rs);
            Conexion.close(stm);
            Conexion.close(conn);
        }
        
        return personas;
    }
    
    //El int indica n de registros afectados
    public int insert(Persona persona){
        Connection conn = null;
        PreparedStatement stm = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_INSERT);
            //Se proporcionan los valores para el insert
            //.setString(columna, valor);
            //A traves de la funcion -getAtributo() obtiene los valores definidos en el paquete test
            stm.setString(1, persona.getNombre());
            stm.setString(2, persona.getApellido());
            stm.setString(3, persona.getEmail());
            stm.setString(4, persona.getTelefono());
            
            System.out.println("Ejecutando query: " + SQL_INSERT);
            
            //Cantidad de registros afectados
            rows = stm.executeUpdate(); //No se debe llamar a la sentencia denuevo, ay que ya esta contenida
            System.out.println("Registros afectados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        finally{
            Conexion.close(stm);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int update(Persona persona){
        Connection conn = null;
        PreparedStatement stm = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando Query: " + SQL_UPDATE);
            
            //A traves de la funcion -getAtributo() obtiene los valores definidos en el paquete test
            //LOs parametros van en orden como se establecen en la QUERY independiente de la sintaxis
            //EJ: UPDATE personaSET nombre=?(!), apellido=?(2), email=?(3), telefono=?(4) WHERE id_persona = ?(5)
            stm = conn.prepareStatement(SQL_UPDATE);
            stm.setString(1, persona.getNombre());
            stm.setString(2, persona.getApellido());
            stm.setString(3, persona.getEmail());
            stm.setString(4, persona.getTelefono());
            //Recupera la id de la persona a UPDATE
            stm.setInt(5, persona.getId_persona());
            
            rows = stm.executeUpdate();
            System.out.println("Registros actualizados: " + rows);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stm);
            Conexion.close(conn);
        }        
        
                    return rows;

    }
    
    public int delete(Persona persona){
        Connection conn = null;
        PreparedStatement stm = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_DELETE);
            stm = conn.prepareStatement(SQL_DELETE);
            stm.setInt(1, persona.getId_persona());
            rows = stm.executeUpdate();
            System.out.println("Registros eliminados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
       finally{
            Conexion.close(stm);
            Conexion.close(conn);
        }        
        
        return rows;
    }
}
