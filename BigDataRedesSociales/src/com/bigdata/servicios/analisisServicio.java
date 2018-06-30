/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigdata.servicios;

import com.bigdata.dbconexion.conexionDB;
import com.bigdata.entidades.analisis;
import com.bigdata.entidades.tweet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejo
 */
public class analisisServicio {

    private final String tabla1 = "twitter";
    private final String tabla = "analisis";
    
    public void guardar(Connection cn,analisis a)throws SQLException, ClassNotFoundException{
        try {
            PreparedStatement consulta;
            //
            String query="INSERT INTO "+this.tabla+" (twit_id_twit,porcentaje,favorabilidad) VALUES(?,?,?)";
            if(a.getT()!= null){
                consulta = cn.prepareStatement(query);
                
                consulta.setString(1, a.getT().getId_tweet());
                //System.err.println(a.getT().getId_tweet());
                consulta.setDouble(2, a.getPorcentaje());
                consulta.setString(3, a.getSentimiento());
                consulta.executeUpdate();
            } else {
                System.err.println("Es necesario el ID");
            }
        } catch (SQLException e) {
            System.err.println("Error en SQL: "+e.getMessage());
            //throw new SQLException(e);
        }
    }
    public List<tweet> listarAll(Connection cnx) throws SQLException{
        List<tweet> Twit= new ArrayList<>();
        try {
            try{
         PreparedStatement consulta = cnx.prepareStatement("SELECT idtwitter, usuario, texto ,localizacion, fecha , palabra FROM twitter ORDER BY fecha");
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            Twit.add(new tweet(resultado.getString("idtwitter"), resultado.getString("usuario"), resultado.getString("texto"), resultado.getString("localizacion"),resultado.getDate("fecha"), resultado.getString("palabra")));
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
        } catch (Exception e) {
        }
        return Twit;
    }
    /*public static void main(String args[]) throws SQLException, ClassNotFoundException{
        analisisServicio a = new analisisServicio();
        conexionDB cn = new conexionDB();
        Connection c = cn.getConeccion();
        List<tweet> t = a.listarAll(c);
        System.out.println(t.size());
    }*/
}
