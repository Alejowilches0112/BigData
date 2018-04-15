/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigdata.dbconexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alejo
 */
public class conexionDB {
    private Connection cnx;
    Statement stm;
    public conexionDB(){
        
    }
    public Connection getConeccion() throws SQLException, ClassNotFoundException{
        
        if(cnx==null){
            cnx=obtener();
        }
        return cnx;
    }
   private Connection obtener() throws SQLException, ClassNotFoundException {
         try {
            Class.forName("com.mysql.jdbc.Driver");
             //cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/bigdata?user=root&password=root");
             cnx=DriverManager.getConnection("jdbc:mysql://192.168.0.7:3306/bigdata?user=alejo&password"); 
            //System.out.println("Coneccion exitosa");
         } catch (SQLException ex) {
             System.err.println("Fallo coneccion");
            throw new SQLException(ex);
            
         } catch (ClassNotFoundException ex) {
             System.err.println("Error Desconocido");
            throw new ClassCastException(ex.getMessage());
         }
      
      return cnx;
   }
   public  void cerrar() throws SQLException {
      if (cnx != null) {
         cnx.close();
      }
   }
}
