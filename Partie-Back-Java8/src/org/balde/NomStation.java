package org.balde;

import java.util.ArrayList;
import java.util.List;

public class NomStation {

	public List<String> StationNom()
	{
		String certificatesTrustStorePath = "C:\\Program Files\\AdoptOpenJDK\\jdk-8.0.232.09-hotspot\\jre\\lib\\security\\cacerts";
		System.setProperty("javax.net.ssl.trustStore", certificatesTrustStorePath);
		Emplacement em=new Emplacement();
        List<Coordonnées> list=new ArrayList<>();
        list.addAll(em.emplacement());
        List<String> list2=new ArrayList<>();
         for(Coordonnées c: list) {
        	 list2.add(c.getName());
         }
         return list2;
	}
}
