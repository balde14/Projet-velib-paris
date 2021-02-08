package org.balde.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.balde.Coordonnées;
import org.balde.Emplacement;
import org.balde.NomStation;
import org.balde.RecupInfoT;
import org.balde.Station;

@Path("velib")
public class VelibRS {

	@GET @Path("emplacement")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<Coordonnées> emplacement() {
		Emplacement em=new Emplacement();
		List<Coordonnées> list=new ArrayList<>();
		list.addAll(em.emplacement());
	
		return list;
		
	}
	
	@GET @Path("temp-reel")
	public List<Station> information(){
		
		RecupInfoT r=new RecupInfoT();
        List<Station> list=new ArrayList<>();
        list.addAll(r.Inforeel());
        return list;
	}
	
	@POST @Path("recherche")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<Station> recherche(@FormParam("name") String nom) {
		Station s=new Station();
		RecupInfoT r=new RecupInfoT();
        List<Station> list=new ArrayList<>();
        for(Station c: r.Inforeel()) {
        	if(c.getNom_station().contains(nom)) {
        		s=c;
        		list.add(s);
        	}
        }
        return list;
        
	}
	
}
