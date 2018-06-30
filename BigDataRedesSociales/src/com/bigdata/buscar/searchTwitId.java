/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigdata.buscar;

import com.bigdata.dbconexion.conexionDB;
import com.bigdata.entidades.tweet;
import com.bigdata.servicios.tweetServicio;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import twitter4j.GeoLocation;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Alejo
 */
public class searchTwitId  extends Thread{
    private Twitter twit;
    private String id_t;
    private Date fecha;
    private GeoLocation localizacion;
    private String usuario;
    private String texto;
    private String clave;
    
    

    public ConfigurationBuilder config() throws TwitterException, IOException {
        ConfigurationBuilder ct = new ConfigurationBuilder();
        ct.setDebugEnabled(true).setOAuthConsumerKey("")
                .setOAuthConsumerSecret("")
                .setOAuthAccessToken("")
                .setOAuthAccessTokenSecret("");
        return ct;
    }
    public void buscar(String id,String palabra) throws TwitterException, IOException, SQLException, ClassNotFoundException, InterruptedException{
        twit = new TwitterFactory(config().build()).getInstance();
        tweet tw;
        tweetServicio ser = new tweetServicio();
        conexionDB cnx=new conexionDB();
        Connection ct;
        System.out.println(id);
        try {
            Status status = twit.showStatus(Long.parseLong(id));
            if (status == null) { // 
            // don't know if needed - T4J docs are very bad
            }else {
                //System.err.println(id+" "+status.getCreatedAt().toString());
                //#MejorVargasLleras, @sergio_fajardo, @petrogustavo, @IvanDuque, @german_vargasll, @DeLaCalleHum
                //Gustavo Petro, Sergio Fajardo, Humberto de la Calle, German Vargas Lleras, Ivan Duque
                ct=cnx.getConeccion();
                id_t=id;
                usuario=status.getUser().getScreenName();
                texto=status.getText();
                localizacion=status.getGeoLocation();
                fecha=status.getCreatedAt();
                int y=fecha.getYear();
                int m=fecha.getMonth();
                int d=fecha.getDate();
                clave=palabra;
                
                switch (clave){
                    case "#MejorVargasLleras":
                        tw=new tweet(id_t,usuario,texto,localizacion,d,m,y,"German Vargas Lleras");
                        System.err.println(tw.toString());
                        ser.guardar(ct,tw);
                        cnx.cerrar();
                        break;
                        
                    case "@sergio_fajardo":
                        tw=new tweet(id_t,usuario,texto,localizacion,fecha.getDate(),fecha.getMonth(),fecha.getYear(),"Sergio Fajardo");
                        System.err.println(tw.toString());
                        ser.guardar(ct,tw);
                        cnx.cerrar();
                        break;
                        
                    case "@petrogustavo":
                        tw=new tweet(id_t,usuario,texto,localizacion,fecha.getDate(),fecha.getMonth(),fecha.getYear(),"Gustavo Petro");
                        System.err.println(tw.toString());
                        ser.guardar(ct,tw);
                        cnx.cerrar();
                        break;
                        
                    case "@IvanDuque":
                        tw=new tweet(id_t,usuario,texto,localizacion,fecha.getDate(),fecha.getMonth(),fecha.getYear(),"Ivan Duque");
                        System.err.println(tw.toString());
                        ser.guardar(ct,tw);
                        cnx.cerrar();
                        break;
                        
                    case "@german_vargasll":
                        tw=new tweet(id_t,usuario,texto,localizacion,fecha.getDate(),fecha.getMonth(),fecha.getYear(),"German Vargas Lleras");
                        System.err.println(tw.toString());
                        ser.guardar(ct,tw);
                        cnx.cerrar();
                        break;
                        
                    case "@DeLaCalleHum":
                        tw=new tweet(id_t,usuario,texto,localizacion,fecha.getDate(),fecha.getMonth(),fecha.getYear(),"Humberto de la Calle");
                        System.err.println(tw.toString());
                        ser.guardar(ct,tw);
                        cnx.cerrar();
                        break;      
                }
            }
        } catch (TwitterException e) {
        System.err.print("Failed to search tweets: " + e.getMessage());
        Thread.sleep(60 * 1000);
        // e.printStackTrace();
        // DON'T KNOW IF THIS IS THROWN WHEN ID IS INVALID
        }
        
    }       
}
