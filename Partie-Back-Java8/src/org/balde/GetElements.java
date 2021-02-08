package org.balde;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class GetElements {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String certificatesTrustStorePath = "C:\\Program Files\\AdoptOpenJDK\\jdk-8.0.232.09-hotspot\\jre\\lib\\security\\cacerts";
		System.setProperty("javax.net.ssl.trustStore", certificatesTrustStorePath);
		
		//------------- 1) recuperation des informations en temps réel-------------||
		
        RecupInfoT r=new RecupInfoT();
        List<Station> list=new ArrayList<>();
        list.addAll(r.Inforeel());
        list.forEach(c->System.out.println(c));
        
        //------------ 2) recuperation de lemeplacment des sations---------------||
        Emplacement em=new Emplacement();
        List<Coordonnées> list2=new ArrayList<>();
        list2.addAll(em.emplacement());
       
        //--------------3) recuperation des noms de station--------------------||
        
        NomStation nom=new NomStation();
        List<String> list3=new ArrayList<>();
        list3.addAll(nom.StationNom());
	}

}
