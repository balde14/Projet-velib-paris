package org.balde;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Emplacement {

	public List<Coordonnées> emplacement(){
		String certificatesTrustStorePath = "C:\\Program Files\\AdoptOpenJDK\\jdk-8.0.232.09-hotspot\\jre\\lib\\security\\cacerts";
		System.setProperty("javax.net.ssl.trustStore", certificatesTrustStorePath);
		Client client2 =ClientBuilder.newClient();
		WebTarget hostStation2=client2.target("https://opendata.paris.fr/api/records/1.0/search/?dataset=velib-emplacement-des-stations&rows=1398");
		
		Response response2=hostStation2.request(MediaType.APPLICATION_JSON).get();
		Coordonnées cordone=response2.readEntity(Coordonnées.class);
		Object[] elements2=cordone.getRecords();
		
		List<Coordonnées> details2=new ArrayList<>();
		
		for(int i=0;i<elements2.length;i++) {
        	Map<String,Object> records2= (Map<String, Object>) elements2[i];
        	Map<String,Object> fields2=(Map<String, Object>)records2.get("fields");
        	String nom=(String)fields2.get("name");
        	List<BigDecimal> corrd=(List<BigDecimal>)fields2.get("xy");
        	
        	Coordonnées cord=new Coordonnées(nom,corrd);
        	details2.add(cord);
        }
		return details2;
	}
}
