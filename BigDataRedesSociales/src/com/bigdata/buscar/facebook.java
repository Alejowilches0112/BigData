/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigdata.buscar;

/*import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.devdom.influencer.util.Configuration;*/
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;
import facebook4j.internal.logging.Logger;
import facebook4j.internal.org.json.JSONException;
import facebook4j.internal.org.json.JSONObject;

/**
 *
 * @author Alejo
 */
public class facebook {
    /*private static final Logger logger = Logger.getLogger(facebook.class);
    private static final ConfigurationBuilder cb = Configuration.getFacebookConfig();
    private static Configuration configuration; // = cb.build();
    private AccessToken accessToken;*/
    
    
    /*private AccessToken getRawFacebookExchangeToken() throws FacebookException, JSONException{
	    String url = "https://graph.facebook.com/oauth/access_token?grant_type=fb_exchange_token";
	    String appId = configuration.getOAuthAppId(); 
	    String secret = configuration.getOAuthAppSecret(); 
	    String oldToken = configuration.getOAuthAccessToken(); 

	    url += "&client_id="+appId+
	           "&client_secret="+secret+
	           "&fb_exchange_token="+oldToken;

	    logger.info("entro a generar el nuevo token con el URL "+ url);
	    JSONObject json = getRawFacebookCall(url);

	    return new AccessToken(json.getString("access_token"), json.getLong("expires"));
	    
	}
        private JSONObject getRawFacebookCall(String url){
            logger.info("URL -> "+ url);
        try {
            Client client = Client.create();
            WebResource webResource = client.resource(url);
            ClientResponse response = webResource.accept("application/json")
                .get(ClientResponse.class);
            if (response.getStatus() != 200) {
                    throw new RuntimeException("HTTP error code : " + response.getStatus());
            }
            String output = response.getEntity(String.class); 
            output = "{"+output+"}";
            output = output.replace("&expires=", ",expires=");
            return new JSONObject(output);
        } catch (RuntimeException | JSONException ex) { 
            logger.error(ex.getMessage(),ex);
        }
        return null;
    }
    */
    @SuppressWarnings("empty-statement")
    public ConfigurationBuilder configurar(){
        ConfigurationBuilder ct= new ConfigurationBuilder();
        ct.setDebugEnabled(true)
                .setOAuthAppId("420022081780469")
                .setOAuthAppSecret("a85df0995c6b41273e06d37659524fee")
                .setOAuthAccessToken("02bb392620b9ace686b52bd541d7a189")
                .setOAuthPermissions("email,publish_stream");
     return ct;   
    }
    
    public void prueba() throws FacebookException{
        FacebookFactory ff = new FacebookFactory(configurar().build());
        Facebook face = ff.getInstance();
        try {
            face.postStatusMessage("Hello World from Facebook4J.");
            System.out.println(face.friends());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String [] args) throws FacebookException{
        facebook fa= new facebook();
        fa.prueba();
    }
}