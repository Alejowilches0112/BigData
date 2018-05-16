/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigdata.buscar;


import com.bigdata.controlador.controladorDB;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.sql.SQLException;
import java.util.List;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Alejo
 */

public class searchTwit extends Thread {
    // variables de las busqueda
    private Twitter twit;
    private List<Status> busqueda;
    //variables de entidad
    private String usuario;
    private String texto;
    private GeoLocation ubicacion;
    private long id;
    private String date;
    
    //variables locales
    private long n=0;
    private String word;
    //entidad y conexion a DB
    private controladorDB ctb;

           
        
    public ConfigurationBuilder config() throws TwitterException, IOException {
        ConfigurationBuilder ct = new ConfigurationBuilder();
        ct.setDebugEnabled(true).setOAuthConsumerKey("UTO1qpbHGuT3JTqWd5KFOjk61")
                .setOAuthConsumerSecret("TH0fXIhkeA55KiBtZzMihTxbJaIA0XrL8eyBsmTHreN8Gy0CaS")
                .setOAuthAccessToken("162496007-CUuJHs97MjjZ5qTIi0lC30uGZWTXOnKovzjJ1JZV")
                .setOAuthAccessTokenSecret("JmrqRPaIH593T41JeuUz9ETg6HCo8mCnXhXn7ThqrTNWa");
        return ct;
    }

    public void buscar(String word) throws TwitterException, IOException, InterruptedException, ClassNotFoundException, SQLException {
        twit = new TwitterFactory(config().build()).getInstance();
        //FileWriter archivo = null;
        //PrintWriter pw = null;
        ctb = new controladorDB();         
        
        try {
            Query buscar = new Query(word);
            buscar.count(100);
            QueryResult resultado;
            
            //archivo = new FileWriter("C:/Users/Alejo/Documents/BIG DATA/BigDataRedesSociales/src/twitter.txt");
            //archivo = new FileWriter("/home/familia/Documentos/BigData/BigDataRedesSociales/"
                                //+ "archivos/"+word+".txt");

            do {
                resultado = twit.search(buscar);
                busqueda = resultado.getTweets();
                //pw = new PrintWriter(archivo);               
                for (Status tweet : busqueda) {
                    id=tweet.getId();
                    usuario = (tweet.getUser().getScreenName());
                    texto = tweet.getText();
                    ubicacion = tweet.getGeoLocation();
                    date = tweet.getCreatedAt().toString();
                    ctb.crearTweet(id,usuario,texto,ubicacion,date,word);
                    n++;
                }
            } while ((buscar = resultado.nextQuery()) != null);
            long a=System.currentTimeMillis();
            dormir();
            long b=(System.currentTimeMillis()-a);
            //searchTwit Twitter = new searchTwit();
            //Twitter.buscar(word);
        } catch (TwitterException e) {
            //long a=System.currentTimeMillis();
            System.err.println("Fallo busqueda de tweets: "+'\n');
            Thread.sleep(940 * 1000);
            //long b=(System.currentTimeMillis()-a);
            //System.err.println("tiempo: "+b/1000);
            //searchTwit Twitter = new searchTwit();
            //Twitter.buscar(word); 
        }
        catch (NullPointerException e) {
            long a=System.currentTimeMillis();
            //System.err.println("Error desconocido : " + e.getMessage());
            //Thread.sleep(60 * 1000);
            //long b=(System.currentTimeMillis()-a);
            //System.err.println("tiempo: "+b/1000);
        //throw new NullPointerException(e.getMessage());
        }
    }

    private void dormir() {
        try {
            Thread.sleep(60 * 1000);
        } catch (Exception e) {
                    System.err.println(e.getMessage());
        }

    }
}