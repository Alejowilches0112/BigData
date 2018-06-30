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
public class analisis {
    private double porcentaje;
    private String sentimiento;
    private tweet t;
    
    public analisis(){
        
    }
    
    public analisis(double p, String s, tweet tw){
        this.porcentaje = p;
        this.sentimiento = s;
        this.t = tw;
    }
    
    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getSentimiento() {
        return sentimiento;
    }

    public void setSentimiento(String sentimiento) {
        this.sentimiento = sentimiento;
    }

    public tweet getT() {
        return t;
    }

    public void setT(tweet t) {
        this.t = t;
    }
    
    
}
