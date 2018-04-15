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
 
        //#MejorVargasLleras, @sergio_fajardo, @petrogustavo, @IvanDuque, @german_vargasll, @DeLaCalleHum
        //Gustavo Petro, Sergio Fajardo, Humberto de la Calle, German Vargas Lleras, Ivan Duque
        while(true){
            Twitter.buscar("@sergio_fajardo");
        }
    }
}
