/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigdata.buscar;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Alejo
 */

public class searchTwit extends Thread {
	// variables
	private Twitter twit;
	private List<Status> busqueda;
	private String usuario;
	private String texto;
	private GeoLocation ubicacion;
        private long n=0;
        private String word;
        //private CsvWriter write;
        
	public ConfigurationBuilder config() throws TwitterException, IOException {
		ConfigurationBuilder ct = new ConfigurationBuilder();
		ct.setDebugEnabled(true).setOAuthConsumerKey("UTO1qpbHGuT3JTqWd5KFOjk61")
				.setOAuthConsumerSecret("TH0fXIhkeA55KiBtZzMihTxbJaIA0XrL8eyBsmTHreN8Gy0CaS")
				.setOAuthAccessToken("162496007-CUuJHs97MjjZ5qTIi0lC30uGZWTXOnKovzjJ1JZV")
				.setOAuthAccessTokenSecret("JmrqRPaIH593T41JeuUz9ETg6HCo8mCnXhXn7ThqrTNWa");
		return ct;
	}

	public void buscar(String word) throws TwitterException, IOException, InterruptedException {
		twit = new TwitterFactory(config().build()).getInstance();
		FileWriter archivo = null;
		PrintWriter pw = null;
                
		//write = new file();
		try {
			Query buscar = new Query(word);
                        buscar.count(100);
			QueryResult resultado;
                        
                        //archivo = new FileWriter("/home/familia/Documentos/BigData/BigDataRedesSociales/"
                              //  + "src/"+word+".txt");
                        archivo = new FileWriter("C:/Users/Alejo/Documents/BIG DATA/BigDataRedesSociales/src/twitter.txt");
			pw = new PrintWriter(archivo);
			do {
				resultado = twit.search(buscar);
				busqueda = resultado.getTweets();
                                
				for (Status tweet : busqueda) {
					usuario = tweet.getUser().getScreenName();
					ubicacion = tweet.getGeoLocation();
					
					pw.write(n+" "+tweet.getId() + " : "+ usuario +" : " + 
                                                tweet.getText() + " : " + ubicacion + "\n");
					
                                        System.out.println(n+" "+tweet.getId() + " : "+ usuario +" : " + 
                                                tweet.getText() + " : " + ubicacion + "\n");
                                        n++;
				}
			} while ((buscar = resultado.nextQuery()) != null);
			dormir();
                        searchTwit Twitter = new searchTwit();
                        Twitter.buscar(word);
		} catch (TwitterException e) {
			System.err.println("Fallo busqueda de tweets : " + e.getMessage());
			Thread.sleep(940 * 1000);
                     
		}
		catch (NullPointerException e) {
			System.err.println("Error desconocido"+e.getMessage());
		}
	}

	private void dormir() {
		try {
			Thread.sleep(3600 * 1000);
		} catch (Exception e) {
                    System.err.println(e.getMessage());
		}

	}
}
