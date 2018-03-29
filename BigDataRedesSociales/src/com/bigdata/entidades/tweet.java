/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigdata.entidades;

/**
 *
 * @author Alejo
 */
public class tweet {
    private final String id_tweet;
    private String user;
    private String texto;
    private String Localizacion;
    public tweet(){
        this.id_tweet=null;
        this.user=null;
        this.texto=null;
        this.Localizacion=null;
    }
    public tweet(String id, String user, String texto, String georef){
        this.id_tweet=id;
        this.user=user;
        this.texto=texto;
        this.Localizacion=georef;
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
 @Override
    public String toString(){
    return "tweet{"+"id_tweet="+id_tweet+", user="+user+", texto="+texto+",Localizacion="+Localizacion+'}';
    } 
}
