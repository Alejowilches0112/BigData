/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigdata.controlador;

import java.sql.Connection;
import java.sql.SQLException;

import com.bigdata.dbconeccion.conexionDB;
import com.bigdata.entidades.tweet;
import com.bigdata.servicios.tweetServicio;
import java.util.List;

import twitter4j.GeoLocation;

public class controladorDB {
	private tweet T;
	private tweet T1;
        private List<tweet> lt;
	private conexionDB cnx;
	private Connection ct;
	private tweetServicio ts;

//	public  controladorDB() {
//		cnx = new conexionDB();
//	}
	
	public void crearTweet(long id, String user, String text, GeoLocation geo) throws ClassNotFoundException, SQLException {
		String id_t=id+"";
		String geoL=geo+"";
		T = new tweet(id_t, user, text, geoL);
		save(T);
	}
	private void save (tweet T) throws ClassNotFoundException, SQLException {
                cnx=new conexionDB();
                ct=cnx.getConeccion();
                ts=new tweetServicio();
                
                System.out.println("1 : ");
                ts.guardar(ct, T);
                System.out.println("Tweet guardado");
                cnx.cerrar();
                
        }
}