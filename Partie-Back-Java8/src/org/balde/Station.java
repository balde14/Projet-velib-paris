package org.balde;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Station {
	
	 Object[] records;
	 //records geometry;
	 private String nom_station; // nom de la station
	 private String code_station; //code la station
	 private BigDecimal borne_en_station; //nbre de borne en station
	 private BigDecimal borne_disponible; // nbre de borne dispo
	 private BigDecimal velo_electrique; // velo electrique
	 private BigDecimal velo_mecanique; //velo mecanique
	 private BigDecimal lat;
	 private BigDecimal longe;
	 private String paymentcb;
	public Station() {
	}
	public Station(String nom_station, String code_station, BigDecimal borne_en_station, BigDecimal borne_disponible,
			BigDecimal velo_electrique, BigDecimal velo_mecanique, BigDecimal lat, BigDecimal longe,String paymentcb) {
		
		String certificatesTrustStorePath = "C:\\Program Files\\AdoptOpenJDK\\jdk-8.0.232.09-hotspot\\jre\\lib\\security\\cacerts";
		System.setProperty("javax.net.ssl.trustStore", certificatesTrustStorePath);
		this.nom_station = nom_station;
		this.code_station = code_station;
		this.borne_en_station = borne_en_station;
		this.borne_disponible = borne_disponible;
		this.velo_electrique = velo_electrique;
		this.velo_mecanique = velo_mecanique;
		this.lat = lat;
		this.longe = longe;
		this.paymentcb=paymentcb;
	}
	public Object[] getRecords() {
		return records;
	}
	public void setRecords(Object[] records) {
		this.records = records;
	}
	public String getNom_station() {
		return nom_station;
	}
	public void setNom_station(String nom_station) {
		this.nom_station = nom_station;
	}
	public String getCode_station() {
		return code_station;
	}
	public void setCode_station(String code_station) {
		this.code_station = code_station;
	}
	public BigDecimal getBorne_en_station() {
		return borne_en_station;
	}
	public void setBorne_en_station(BigDecimal borne_en_station) {
		this.borne_en_station = borne_en_station;
	}
	public BigDecimal getBorne_disponible() {
		return borne_disponible;
	}
	public void setBorne_disponible(BigDecimal borne_disponible) {
		this.borne_disponible = borne_disponible;
	}
	public BigDecimal getVelo_electrique() {
		return velo_electrique;
	}
	public void setVelo_electrique(BigDecimal velo_electrique) {
		this.velo_electrique = velo_electrique;
	}
	public BigDecimal getVelo_mecanique() {
		return velo_mecanique;
	}
	public void setVelo_mecanique(BigDecimal velo_mecanique) {
		this.velo_mecanique = velo_mecanique;
	}
	public BigDecimal getLat() {
		return lat;
	}
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}
	public BigDecimal getLonge() {
		return longe;
	}
	public void setLonge(BigDecimal longe) {
		this.longe = longe;
	}
	public String getPaymentcb() {
		return paymentcb;
	}
	public void setPaymentcb(String paymentcb) {
		this.paymentcb = paymentcb;
	}
	@Override
	public String toString() {
		return "Station [nom_station=" + nom_station + ", code_station=" + code_station + ", borne_en_station="
				+ borne_en_station + ", borne_disponible=" + borne_disponible + ", velo_electrique=" + velo_electrique
				+ ", velo_mecanique=" + velo_mecanique + ", lat=" + lat + ", longe=" + longe + ", Payment-Cb="
				+ paymentcb + "]";
	}
	
	 
}
