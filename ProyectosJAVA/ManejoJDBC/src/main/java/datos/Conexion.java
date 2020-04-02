/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.*;


/**
 *
 * @author tony
 */
public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost/test?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "1qaz2wsx3e";
    
    public static Connection getConnection() throws SQLException{
        //Conexion base de datos
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
    }
    
    //Cierra sentencia SELECT
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    //Cierra sentencia DDL DML
    public static void close(PreparedStatement stat){
        try {
            stat.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    //Cierra conexion
    public static void close(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
