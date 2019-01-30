package com.formation.vtc.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.formation.vtc.persistence.entity.Reservation;

public class ReservationListItem {
	
	
	private String nom;
	private String prenom;
	private String numResa;
	private int nbPlaces;
	private double prix;
	private String horaire;
	
	public ReservationListItem(Reservation reservations) {
		this.setNom(reservations.getNom());
		this.setPrenom(reservations.getPrenom());
		this.setNumResa(reservations.getNumResa());
		this.setNbPlaces(reservations.getNbPlaces());
		this.setPrix(reservations.getPrix());
		
		 Date date = reservations.getTrajet().getHoraire(); 
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
		 String strDate = dateFormat.format(date);
		this.setHoraire(strDate);
	}
	
	
	
	public String getHoraire() {
		return horaire;
	}



	public void setHoraire(String horaire) {
		this.horaire = horaire;
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
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
	

}
