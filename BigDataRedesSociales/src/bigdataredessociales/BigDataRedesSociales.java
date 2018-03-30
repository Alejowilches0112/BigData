/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigdataredessociales;

import twitter4j.TwitterException;
import com.bigdata.buscar.searchTwit;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Alejo
 */
public class BigDataRedesSociales{
    /*
    * Declaracion de los objetos para la busqueda 
    */
    public static searchTwit Twitter;
    
    public static void main(String[] args) throws TwitterException, IOException, InterruptedException, SQLException, ClassNotFoundException {
        Twitter = new searchTwit();
 
        
        while(true){
            Twitter.buscar("de la Calle");
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
