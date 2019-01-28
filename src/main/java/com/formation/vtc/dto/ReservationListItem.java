package com.formation.vtc.dto;

import com.formation.vtc.persistence.entity.Reservation;

public class ReservationListItem {
	
	
	private String nom;
	private String prenom;
	private String numResa;
	private int nbPlaces;
	private double prix;
	
	public ReservationListItem(Reservation reservations) {
		this.setNom(reservations.getNom());
		this.setPrenom(reservations.getPrenom());
		this.setNumResa(reservations.getNumResa());
		this.setNbPlaces(reservations.getNbPlaces());
		this.setPrix(reservations.getPrix());
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
