package com.formation.vtc.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@Column (name = "numResa", unique = true, nullable=true)
	private String numResa;
	
	@Column (name = "nbPlaces", nullable=false)
	private int nbPlaces;
	
	@Column (name = "prix", nullable=true)
	private double prix;
	
	@Column (name = "mail", length = 50, nullable=true)
	private String mail;
	
	@Column (name = "etatResa", length = 20, nullable=true)
	private String etatResa;
	
	@ManyToOne
	@JoinColumn(name = "IdTrajet", referencedColumnName = "id")
	private Trajet trajet;

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

	public double getPrix() {
		return prix;
	}

	public void setPrix(double d) {
		this.prix = d;
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

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

		
}
