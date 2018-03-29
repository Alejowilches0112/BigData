/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigdata.servicios;

import com.bigdata.dbconexion.conexionDB;
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
public class tweetServicio {
    private final String tabla ="twitter";
    
    public void guardar(Connection cnx,tweet tweeter)throws SQLException{
        try {
            PreparedStatement consulta;
            String query="INSERT INTO"+this.tabla+" VALUES(?,?,?,?,)";
            if(tweeter.getId_tweet()!= null){
                consulta = cnx.prepareStatement("INSERT INTO"+this.tabla+"VALUES (?,?,?,?,)");
                consulta.setString(1, tweeter.getId_tweet());
                consulta.setString(2, tweeter.getUser());
                consulta.setString(3, tweeter.getTexto());
                consulta.setString(4, tweeter.getLocalizacion());
                //consulta.executeUpdate();
            } else {
                System.err.println("Es necesario el ID");
            }
        } catch (SQLException e) {
            //System.err.println("Error en SQL: "+e.getMessage());
            throw new SQLException(e);
        }
    }
    public tweet listar(Connection cnx,String id_twit)throws SQLException{
        tweet Tweet = null;
        try {
            PreparedStatement consulta=cnx.prepareStatement("SELECT user_twit,texto,localizacion FROM "+this.tabla+" WHERE id_twit = ?");
            consulta.setString(1, id_twit);
            ResultSet resultado=consulta.executeQuery();
            while(resultado.next()){
                Tweet =new tweet(id_twit,resultado.getString("user_twit"),resultado.getString("texto"), resultado.getString("localizacion"));
            }
        } catch (SQLException e) {
            System.out.println("Error con la base de datos"+e.getMessage());
        }
        return Tweet;
    }
    
    public List<tweet> listarAll(Connection cnx) throws SQLException{
        List<tweet> Twit= new ArrayList<>();
        try {
            try{
         PreparedStatement consulta = cnx.prepareStatement("SELECT id_twit, user_twit, texto , localizacion FROM " + this.tabla + " ORDER BY id_twit");
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            Twit.add(new tweet(resultado.getString("id_twit"), resultado.getString("user_twit"), resultado.getString("texto"), resultado.getString("localizacion")));
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
        } catch (Exception e) {
        }
        return Twit;
    }
    
    public static void main(String args[]) throws SQLException, ClassNotFoundException{
        Connection con=null;
        conexionDB cnx= new conexionDB(con);
        tweetServicio ts= new tweetServicio();
        tweet T;
        tweet T1;
        //T = new tweet("979260958572007424", "RafaelsvriveraS", "RT @JoseCuelloB: 🔴⚫️🔵 \"El que vote por Gustavo Petro está loco. Si quieren pasar hambre, entonces, que se vayan para Venezuela. Dios nos am…", null);
        List<tweet> eje;
        eje = ts.listarAll(cnx.getConeccion());
        T=ts.listar(cnx.getConeccion(), "2147483647");
        T1=new tweet("979153310862192642 ","rosalindameza3 ","RT @cauca_humana: \"El día que un campesino en Colombia diga: soy un granjero y mi hija estudia medicina en la universidad, ese día llegará…",null);
        //ts.guardar(cnx.getConeccion(), T1);
        System.out.println(eje.toString()+" : "+T.toString());
        
    }
}
