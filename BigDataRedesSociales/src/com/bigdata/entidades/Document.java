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
public class Document {
    public String id, text , language;

    /*public Document(String id, String text){
        this.id = id;
        this.text = text;
    }*/
    public Document(String id, String language ,String text){
        this.id = id;
        this.language = language;
        this.text = text;
    }
}
