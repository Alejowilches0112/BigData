/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigdataredessociales;

import twitter4j.TwitterException;
import com.bigdata.buscar.twit;
import java.io.IOException;

/**
 *
 * @author Alejo
 */
public class BigDataRedesSociales{
    /*
    * Declaracion de los objetos para la busqueda 
    */
    public static twit Twitter;
    public static twit Twitter1;
    public static twit Twitter2;
    public static twit Twitter3;
    public static twit Twitter4;
    
    public static void main(String[] args) throws TwitterException, IOException, InterruptedException {
        Twitter = new twit();
        Twitter1 = new twit();
        Twitter2 = new twit();
        Twitter3 = new twit();
        Twitter4 = new twit();
        
        while(true){
            Twitter.buscar("Sergio Fajardo");
        }
          
    }
    
    private static void dormir(int seg) {
        try {
            Thread.sleep(seg * 1000);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
