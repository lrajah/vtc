package com.formation.vtc.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.formation.vtc.persistence.entity.Reservation;
import com.formation.vtc.persistence.entity.Trajet;

public class ReservationItem {
	
	private int nbPlace;
	private String etatResa;
	private long idTrajet;
	private String date;
	private double prixTotal;
	private double prixUnitaire;
	private String heure;
	
	public ReservationItem() {
		
	}
	
	public ReservationItem(Reservation resa, Trajet trajet, Date date) {
		this.setEtatResa(resa.getEtatResa());
		this.setIdTrajet(trajet.getId());
		this.setNbPlace(resa.getNbPlaces());
		this.setPrixUnitaire(trajet.getPrix());
		this.setPrixTotal(resa.getPrix());
		
		Date dateTrans = date; 
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	    String strDate = dateFormat.format(dateTrans);  
		this.setDate(strDate);
		
		DateFormat heureFormat = new SimpleDateFormat("HH:mm");  
	    String strHeure = heureFormat.format(dateTrans);
		this.setHeure(strHeure + "H");
	}
	
	public ReservationItem(Reservation resa, Date date) {
		this.setEtatResa(resa.getEtatResa());
		this.setNbPlace(resa.getNbPlaces());
		this.setPrixUnitaire(8);
		this.setPrixTotal(resa.getPrix());
		
		Date dateTrans = date; 
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	    String strDate = dateFormat.format(dateTrans); 
		this.setDate(strDate);

		DateFormat heureFormat = new SimpleDateFormat("HH:mm");  
	    String strHeure = heureFormat.format(dateTrans);
		this.setHeure(strHeure + "H");
	}
	
	public int getNbPlace() {
		return nbPlace;
	}
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}
	public String getEtatResa() {
		return etatResa;
	}
	public void setEtatResa(String etatResa) {
		this.etatResa = etatResa;
	}
	public long getIdTrajet() {
		return idTrajet;
	}
	public void setIdTrajet(long idTrajet) {
		this.idTrajet = idTrajet;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}
	
	
}
