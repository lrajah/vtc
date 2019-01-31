package com.formation.vtc.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.formation.vtc.persistence.entity.Reservation;
import com.formation.vtc.persistence.entity.Trajet;

public class ReservationItem {
	
	private int nbPlaces;
	private String etatResa;
	private Trajet trajet;
	private String date;
	private double prix;
	private String nom;
	private String prenom;
	private String email;
	
	public ReservationItem() {
		
	}
	
	public ReservationItem(Reservation resa, Trajet trajet, Date date) {
		
		this.setNom("");
		this.setPrenom("");
		this.setEmail("");
		this.setNbPlaces(resa.getNbPlaces());
		
		
		Date dateTrans = date; 
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
	    String strDate = dateFormat.format(dateTrans);  
		this.setDate(strDate);
		
		this.setEtatResa(resa.getEtatResa());
		this.setPrix(resa.getPrix());
		this.setTrajet(trajet);
		
		}
	
	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public String getEtatResa() {
		return etatResa;
	}

	public void setEtatResa(String etatResa) {
		this.etatResa = etatResa;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String strDate) {
		this.date = strDate;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
