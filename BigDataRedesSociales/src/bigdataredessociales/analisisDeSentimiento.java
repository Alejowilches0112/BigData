/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigdataredessociales;

import com.bigdata.dbconexion.conexionDB;
import com.bigdata.entidades.Documents;
import com.bigdata.entidades.analisis;
import com.bigdata.entidades.tweet;
import com.bigdata.servicios.GetSentiment;
import com.bigdata.servicios.analisisServicio;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Alejo
 */
public class analisisDeSentimiento extends Thread {
    
    public static void main (String [] args) throws SQLException, ClassNotFoundException, Exception{
        String host = "https://eastus.api.cognitive.microsoft.com";
        String path = "/text/analytics/v2.0/sentiment";
        GetSentiment sent = new GetSentiment(host,path);
        
        analisisServicio as = new analisisServicio();
        analisis a;
        conexionDB c = new conexionDB();
        Connection cnx = c.getConeccion();
        List<tweet> lista = as.listarAll(cnx);
        String id="3";
        //System.err.println(lista.size());
        float res;
        int i=13726;
        //int limi=i+100;
        while( i < lista.size()){
            //System.out.println(i+" "+limi);
            try {
                Documents d = new Documents();
                d.add(id,"es",lista.get(i).getTexto());
                //System.out.println(i+" "+d);
                String response = sent.getSentiment(d);
                //System.err.println(response);
                String map[]=response.split(":");
                String f[]=map[2].split(",");
                res= Float.parseFloat(f[0])*100;
                System.out.println(i);
                
                if(res < 41.0){
                    a= new analisis(res, "NEGATIVO",lista.get(i));
                    as.guardar(cnx, a);
                }
                else if(res >= 41.0 || res < 71.0){
                    a= new analisis(res, "NEUTRO", lista.get(i));
                    as.guardar(cnx, a);
                }            
                else if(res >= 71.0){
                    a= new analisis(res, "POSITIVO", lista.get(i));
                    as.guardar(cnx, a);
                    System.out.println("POSITIVO");
                }
                i++;
            } catch (Exception e) {
                System.out.println("Consultas excedidas a dormir 60 segundos");
                Thread.sleep(60*1000);
            }
            
            //s++; SELECT * from analisis where porcentaje between 71.01126098632812 and 100;
            
            //c.cerrar();
            /*SET SQL_SAFE_UPDATES = 0;
update analisis set favorabilidad = "positivo" where porcentaje between '71.01126098632812' and '100';
SET SQL_SAFE_UPDATES = 1;*/
        }
            
    }
}
