/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigdata.servicios;

import com.bigdata.dbconexion.conexionDB;
import com.bigdata.entidades.tweet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Alejo
 */
public class searchID {
      public ConfigurationBuilder config() throws TwitterException, IOException {
        ConfigurationBuilder ct = new ConfigurationBuilder();
        ct.setDebugEnabled(true).setOAuthConsumerKey("UTO1qpbHGuT3JTqWd5KFOjk61")
                .setOAuthConsumerSecret("TH0fXIhkeA55KiBtZzMihTxbJaIA0XrL8eyBsmTHreN8Gy0CaS")
                .setOAuthAccessToken("162496007-CUuJHs97MjjZ5qTIi0lC30uGZWTXOnKovzjJ1JZV")
                .setOAuthAccessTokenSecret("JmrqRPaIH593T41JeuUz9ETg6HCo8mCnXhXn7ThqrTNWa");
        return ct;
    }
      public void buscar (String id) throws TwitterException, IOException{
         Twitter twit = new TwitterFactory(config().build()).getInstance();
          try {
              Status status = twit.showStatus(Long.parseLong(id));
            if (status == null) { // 
            // don't know if needed - T4J docs are very bad
            } else {
            System.out.println(status.getCreatedAt().toString()+status.getText());
            }
          } catch (TwitterException e) {
              System.err.println("Error");
          }
 
      }
      public static void main (String args[]) throws TwitterException, IOException, SQLException, ClassNotFoundException{
          searchID s=new searchID();
          s.buscar("985354546657538048");
          System.err.println("inico");
          
      }
}
