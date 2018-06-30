/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigdataredessociales;

import twitter4j.TwitterException;
import com.bigdata.buscar.searchTwitId;
import com.bigdata.dbconexion.conexionDB;
import com.bigdata.entidades.twit;
import com.bigdata.servicios.tweetServicio;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author Alejo
 */
public class BigDataRedesSociales{
    /*
    * Declaracion de los objetos para la busqueda 
    */
    //public static searchTwit Twitter;
    
    public static void main(String[] args) throws TwitterException, IOException, InterruptedException, SQLException, ClassNotFoundException, ParseException {
        //Twitter = new searchTwit();
 
        //#MejorVargasLleras, @sergio_fajardo, @petrogustavo, @IvanDuque, @german_vargasll, @DeLaCalleHum
        //Gustavo Petro, Sergio Fajardo, Humberto de la Calle, German Vargas Lleras, Ivan Duque
        /*while(true){
            Twitter.buscar("@sergio_fajardo");
        }*/
        searchTwitId se= new searchTwitId();
        conexionDB cnx=new conexionDB();
        tweetServicio s= new tweetServicio();
        List<twit> t = s.listarAll(cnx.getConeccion());
        cnx.cerrar();
        System.out.println(t.size());
        //+820
        for (int i = 13190; i < t.size(); i++) {
            if(s.existeTweet(cnx.getConeccion(),t.get(i).getId_tweet()) > 0){
                System.err.println("existe");
                //buscar 987278432152190977
                cnx.cerrar();
                continue;
            }else if(s.existeTweet(cnx.getConeccion(),t.get(i).getId_tweet()) == 0){
                se.buscar(t.get(i).getId_tweet(),t.get(i).getPalabra());
                cnx.cerrar();
            }
        }
    }
}
///Wed Apr 18 19:51:18 COT 2018.