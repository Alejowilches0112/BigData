/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigdata.servicios;

import com.bigdata.dbconexion.conexionDB;
import com.bigdata.entidades.tweet;
import com.bigdata.entidades.twit;
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
public class tweetServicio extends conexionDB{
    private final String tabla ="twit";
    private final String tabla1 ="twitter";
    
    public void guardar(Connection cn,tweet tweeter)throws SQLException, ClassNotFoundException{
        try {
            PreparedStatement consulta;
            String query="INSERT INTO "+this.tabla1+" VALUES(?,?,?,?,?,?)";
            if(tweeter.getId_tweet()!= null){
                consulta = cn.prepareStatement(query);
                consulta.setString(1, tweeter.getId_tweet());
                consulta.setString(2, tweeter.getUser());
                consulta.setString(3, tweeter.getTexto());
                consulta.setString(4, tweeter.getLocalizacion());
                consulta.setDate(5, tweeter.getFecha());
                consulta.setString(6, tweeter.getPalabra());
                consulta.executeUpdate();
            } else {
                System.err.println("Es necesario el ID");
            }
        } catch (SQLException e) {
            System.err.println("Error en SQL: "+e.getMessage());
            //throw new SQLException(e);
        }
    }
    
    public int existeTweet (Connection cn,String id) throws SQLException{
        int a=0;
        ResultSet rs;
        try {     
            PreparedStatement consulta = cn.prepareStatement("select count(*) from "+this.tabla1+ " where idtwitter = ?");
            consulta.setString(1, id);
            rs = consulta.executeQuery();
            if(rs.next()){
                a=rs.getInt(1);
            }
        } catch (Exception e) {
        }
        this.cerrar();
        return a;
    }
    
    /*public twit listar(Connection cnx,String id_twit)throws SQLException{
        twit Tweet = new twit("","","","","","");
        try {
            PreparedStatement consulta=cnx.prepareStatement("SELECT user_twit,texto,localizacion,fecha,clave FROM "+this.tabla+" WHERE id_twit = ?");
            consulta.setString(1, id_twit);
            ResultSet resultado=consulta.executeQuery();
            while(resultado.next()){
                Tweet = new twit(id_twit,resultado.getString("user_twit"),resultado.getString("texto"), resultado.getString("localizacion"),resultado.getString("fecha"),resultado.getString("clave"));
            }
        } catch (SQLException e) {
            System.out.println("Error con la base de datos " + e.getMessage());
        }
        return Tweet;
    }*/
    
    
    public List<twit> listarAll(Connection cnx) throws SQLException{
        List<twit> Twit= new ArrayList<>();
        try {
            try{
         PreparedStatement consulta = cnx.prepareStatement("SELECT id_twit, Usuario, texto , fecha , palabra_clave FROM " + this.tabla + " ORDER BY fecha");
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            Twit.add(new twit(resultado.getString("id_twit"), resultado.getString("Usuario"), resultado.getString("texto"), resultado.getString("fecha"), resultado.getString("palabra_clave")));
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
        } catch (Exception e) {
        }
        return Twit;
    }
    /*public static void main(String args[]) throws SQLException{
        tweetServicio s= new tweetServicio();
        System.out.println(s.existeTweet("984983516571209728"));
    }*/
}
