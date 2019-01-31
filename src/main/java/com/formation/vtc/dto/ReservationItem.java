package com.formation.vtc.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.formation.vtc.persistence.entity.Reservation;
import com.formation.vtc.persistence.entity.Trajet;

public class ReservationItem {
	private Long id;
	private int nbPlaces;
	private String etatResa;
	private TrajetListItem trajetItem;
	private String date;
	private double prix;
	private String nom;
	private String prenom;
	private String email;
	private String numResa;
	
	public ReservationItem() {
		
	}
	
	public ReservationItem(Reservation resa) {
		
		this.setNom(resa.getNom());
		this.setPrenom(resa.getPrenom());
		this.setEmail(resa.getMail());
		this.setNbPlaces(resa.getNbPlaces());
		
		
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
	    String strDate = dateFormat.format(resa.getTrajet().getHoraire());  
		this.setDate(strDate);
		
		this.setEtatResa(resa.getEtatResa());
		this.setPrix(resa.getPrix());
		TrajetListItem trajetItem=new TrajetListItem(resa.getTrajet());
		this.setTrajetItem(trajetItem);
		this.setNumResa(resa.getNumResa());
		this.setId(resa.getId());
		
		}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumResa() {
		return numResa;
	}

	public void setNumResa(String numResa) {
		this.numResa = numResa;
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

	

	public TrajetListItem getTrajetItem() {
		return trajetItem;
	}

	public void setTrajetItem(TrajetListItem trajetItem) {
		this.trajetItem = trajetItem;
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
