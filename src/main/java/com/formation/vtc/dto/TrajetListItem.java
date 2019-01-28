package com.formation.vtc.dto;

import java.util.Date;

import com.formation.vtc.persistence.entity.Trajet;

public class TrajetListItem {
	private Date horaire;
	private int PlaceDispo;
	private double prix;
	private String etatTrajet;
	
	
	public TrajetListItem() {
		
	}
	
	
	public TrajetListItem(Trajet t) {
		this.setHoraire(t.getHoraire());
		this.setPlaceDispo(t.getPlaceDispo());
		this.setPrix(t.getPrix());
		this.setEtatTrajet(t.getEtatTrajet());
		
	}


	public Date getHoraire() {
		return horaire;
	}


	public void setHoraire(Date horaire) {
		this.horaire = horaire;
	}


	public int getPlaceDispo() {
		return PlaceDispo;
	}


	public void setPlaceDispo(int placeDispo) {
		PlaceDispo = placeDispo;
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
