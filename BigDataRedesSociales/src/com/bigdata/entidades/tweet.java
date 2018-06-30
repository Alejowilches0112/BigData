/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigdata.entidades;

import java.sql.Date;
import twitter4j.GeoLocation;


/**
 *
 * @author Alejo
 */
public class tweet {
    private final String id_tweet;
    private String user;
    private String texto;
    private String Localizacion;
    private Date fecha;
    private final String palabra;
    
    public tweet(){
        this.id_tweet=null;
        this.user=null;
        this.texto=null;
        this.Localizacion=null;
        this.fecha=null;
        this.palabra=null;
    }
    public tweet(String id, String user, String texto, GeoLocation georef, int d, int m, int y, String p){
        this.id_tweet=id;
        this.user=user;
        this.texto=texto;
        this.Localizacion=georef+"";
        this.fecha=new Date(y,m,d);
        this.palabra=p;
    }
    public tweet(String id, String user, String texto, String georef, Date f, String p){
        this.id_tweet=id;
        this.user=user;
        this.texto=texto;
        this.Localizacion=georef+"";
        this.fecha=f;
        this.palabra=p;
    }
    public String getId_tweet() {
        return id_tweet;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getLocalizacion() {
        return Localizacion;
    }

    public void setLocalizacion(String Localizacion) {
        this.Localizacion = Localizacion;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPalabra() {
        return palabra;
    }
    
 @Override
    public String toString(){
    return "tweet{"+id_tweet+" "+user+" "+texto+" "+Localizacion+" "+fecha+" "+palabra+'}';
    } 
}
