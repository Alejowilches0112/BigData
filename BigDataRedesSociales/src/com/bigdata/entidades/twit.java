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
public class twit {
    private String id_tweet;
    private String user;
    private String texto;

    private String fecha;
    private String palabra;
    
    public twit(){
        this.id_tweet=null;
        this.user=null;
        this.texto=null;
        this.fecha=null;
        this.palabra=null;
    }
    
    public twit(String id, String user, String texto, String fecha,String p){
        this.id_tweet= id;
        this.user=user;
        this.texto=texto;
        this.fecha=fecha;
        this.palabra=p;
    }

 

    public String getId_tweet() {
        return id_tweet;
    }
    
    public void setId_tweet(String id_tweet) {
        this.id_tweet = id_tweet;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
    
 @Override
    public String toString(){
    return "tweet{"+id_tweet+" "+user+" "+texto+" "+fecha+" "+palabra+'}';
    } 
}    

