package com.formation.vtc.dto;

import java.util.Date;

import com.formation.vtc.persistence.entity.Reservation;
import com.formation.vtc.persistence.entity.Trajet;

public class ReservationItem {
	
	private int nbPlaces;
	private String etatResa;
	private Trajet trajet;
	private Date date;
	private double prix;
	
	public ReservationItem() {
		
	}
	
	public ReservationItem(Reservation resa, Trajet trajet, Date date) {
		
		this.setNbPlaces(resa.getNbPlaces());
		this.setDate(date);
		this.setEtatResa(resa.getEtatResa());
		this.setPrix(resa.getPrix());
		this.setTrajet(trajet);
		
//		this.setEtatResa(resa.getEtatResa());
//		this.setIdTrajet(trajet.getId());
//		this.setNbPlace(resa.getNbPlaces());
//		this.setPrixUnitaire(trajet.getPrix());
//		this.setPrixTotal(resa.getPrix());
//		
//		Date dateTrans = date; 
//	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
//	    String strDate = dateFormat.format(dateTrans);  
//		this.setDate(strDate);
//		
//		DateFormat heureFormat = new SimpleDateFormat("HH:mm");  
//	    String strHeure = heureFormat.format(dateTrans);
//		this.setHeure(strHeure + "H");
	}
	
	public ReservationItem(Reservation resa, Date date) {
		/*this.setEtatResa(resa.getEtatResa());
		this.setNbPlace(resa.getNbPlaces());
		this.setPrixUnitaire(8);
		this.setPrixTotal(resa.getPrix());
		
		Date dateTrans = date; 
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	    String strDate = dateFormat.format(dateTrans); 
		this.setDate(strDate);

		DateFormat heureFormat = new SimpleDateFormat("HH:mm");  
	    String strHeure = heureFormat.format(dateTrans);
		this.setHeure(strHeure + "H");*/
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
}
