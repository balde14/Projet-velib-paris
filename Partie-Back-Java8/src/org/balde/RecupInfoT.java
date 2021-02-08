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

public class RecupInfoT {

	public List<Station> Inforeel() {
		String certificatesTrustStorePath = "C:\\Program Files\\AdoptOpenJDK\\jdk-8.0.232.09-hotspot\\jre\\lib\\security\\cacerts";
		System.setProperty("javax.net.ssl.trustStore", certificatesTrustStorePath);
		
		Client client =ClientBuilder.newClient();
		WebTarget hostStation= client.target("https://opendata.paris.fr/api/records/1.0/search/?dataset=velib-disponibilite-en-temps-reel&rows=1398&facet=overflowactivation&facet=creditcard&facet=kioskstate&facet=station_state");
		Response response= hostStation.request(MediaType.APPLICATION_JSON).get();
		Station station= response.readEntity(Station.class);
		
		Object [] elements= station.getRecords();
		List<Station> details=new ArrayList<>();
		
		for(int i=0;i<elements.length;i++)
		{
		Map<String,Object> records= (Map<String, Object>) elements[i];
		Map<String, Object> fields=(Map<String, Object>) records.get("fields");
		String statione=(String) fields.get("station_name");
		String code=(String)fields.get("station_code");
		BigDecimal borne=(BigDecimal) fields.get("nbedock");
		BigDecimal dispo=(BigDecimal) fields.get("nbfreeedock");
		BigDecimal elec=(BigDecimal) fields.get("nbebike");
		BigDecimal meca= (BigDecimal) fields.get("nbbike");
		List<BigDecimal> corrd=(List<BigDecimal>) fields.get("geo");
		BigDecimal latitude=(BigDecimal)corrd.get(0);
		BigDecimal longitude=(BigDecimal)corrd.get(1);
		String cb=(String)fields.get("creditcard");
		
		Station stat=new Station(statione,code,borne,dispo,elec,meca,latitude,longitude,cb);
		details.add(stat);
		}
		return details;
	}
}
