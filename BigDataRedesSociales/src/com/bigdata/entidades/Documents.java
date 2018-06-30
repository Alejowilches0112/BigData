/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigdata.entidades;


import java.util.ArrayList;
import java.util.List;

import com.bigdata.entidades.Document;
/**
 *
 * @author Alejo
 */
public class Documents {
    
    public List<Document> documents;

    public Documents() {
        this.documents = new ArrayList<Document>();
    }
    /*public void add(String id, String text) {
        this.documents.add (new Document (id, text));
    }*/
    public void add(String id, String language ,String text ) {
        this.documents.add (new Document (id, language, text));
    }
}
