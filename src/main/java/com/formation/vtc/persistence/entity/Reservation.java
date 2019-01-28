package com.formation.vtc.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column (name = "nom", length = 50, nullable=false)
	private String nom;
	
	@Column (name = "prenom", length = 50, nullable=false)
	private String prenom;
	
	@Column (name = "numResa", unique = true, nullable=false)
	private String numResa;
	
	@Column (name = "nbPlaces", nullable=false)
	private int nbPlaces;
	
	@Column (name = "prix", nullable=false)
	private int prix;
	
	@Column (name = "mail", length = 50, nullable=false)
	private String mail;
	
	@Column (name = "etatResa", length = 20, nullable=false)
	private String etatResa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getEtatResa() {
		return etatResa;
	}

	public void setEtatResa(String etatResa) {
		this.etatResa = etatResa;
	}
	
}
