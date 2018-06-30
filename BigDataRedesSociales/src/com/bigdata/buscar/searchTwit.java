/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigdata.buscar;


import java.io.IOException;

import java.sql.SQLException;
import java.util.Date;
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
    private Date date;
    
    //variables locales
    private long n=0;
    private String word;
    
           
        
    public ConfigurationBuilder config() throws TwitterException, IOException {
        ConfigurationBuilder ct = new ConfigurationBuilder();
        ct.setDebugEnabled(true).setOAuthConsumerKey("")
                .setOAuthConsumerSecret("")
                .setOAuthAccessToken("")
                .setOAuthAccessTokenSecret("");
        return ct;
    }

    public void buscar(String word) throws TwitterException, IOException, InterruptedException, ClassNotFoundException, SQLException {
        twit = new TwitterFactory(config().build()).getInstance();
        //FileWriter archivo = null;
        //PrintWriter pw = null;
        
        try {
            Query buscar = new Query(word+" +exclude:retweets");
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
                    date = (tweet.getCreatedAt());
                    
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