package org.balde;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Coordonnées {

	Object[] records;
	String name;
	List<BigDecimal> xy;
	public Coordonnées() {
	}
	public Coordonnées(String name, List<BigDecimal> xy) {
		String certificatesTrustStorePath = "C:\\Program Files\\AdoptOpenJDK\\jdk-8.0.232.09-hotspot\\jre\\lib\\security\\cacerts";
		System.setProperty("javax.net.ssl.trustStore", certificatesTrustStorePath);
		this.name = name;
		this.xy = xy;
	}
	public Object[] getRecords() {
		return records;
	}
	public void setRecords(Object[] records) {
		this.records = records;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<BigDecimal> getXy() {
		return xy;
	}
	public void setXy(List<BigDecimal> xy) {
		this.xy = xy;
	}
	@Override
	public String toString() {
		return "Coordonnées [name=" + name + ", xy=" + xy + "]";
	}
	
}
