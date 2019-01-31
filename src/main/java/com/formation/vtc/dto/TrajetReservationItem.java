package com.formation.vtc.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.formation.vtc.persistence.entity.Trajet;

public class TrajetReservationItem {
	
	private Long id;
	private String horaire;
	private int placeReser;
	private double prix;
	private String etatTrajet;
	
	
	
	
	
	public TrajetReservationItem(Trajet t) {
		
	    Date date = t.getHoraire(); 
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
	    String strDate = dateFormat.format(date);
		this.setHoraire(strDate);
		this.setPlaceReser(t.getPlaceDispo());
		this.setPrix(t.getPrix());
		this.setEtatTrajet(t.getEtatTrajet());
		this.setId(t.getId());
	}

	


	

	public Long getId() {
		return id;
	}






	public void setId(Long id) {
		this.id = id;
	}






	public String getHoraire() {
		return horaire;
	}


	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}


	


	public int getPlaceReser() {
		return placeReser;
	}






	public void setPlaceReser(int placeReser) {
		this.placeReser = placeReser;
	}






	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public String getEtatTrajet() {
		return etatTrajet;
	}


	public void setEtatTrajet(String etatTrajet) {
		this.etatTrajet = etatTrajet;
	}

}
