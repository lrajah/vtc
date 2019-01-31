package com.formation.vtc.persistence.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.formation.vtc.dto.TrajetListItem;

@Entity
@Table(name="trajet")
public class Trajet {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column (name = "dateCreation", nullable=false)
	private Date dateCreation;
	
	@Column (name = "horaire", nullable=false)
	private Date horaire;

	@Column (name = "placeDispo", nullable=false)
	private int placeDispo;
	
	@Column (name = "prix", nullable=false)
	private double prix;
	
	@Column (name = "etatTrajet", length = 20, nullable=false)
	private String etatTrajet;
	

	@ManyToOne
	@JoinColumn(name = "IdNavette", referencedColumnName = "id")
	private Navette navette;

	
	
	public Trajet trajetItemToTrajet(TrajetListItem trajetItem) throws ParseException {
		this.setId(trajetItem.getId());
		this.setDateCreation(new Date());
		SimpleDateFormat formatDate=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		formatDate.setLenient(false);
		
		//TODO exception gérer
		Date horaire=formatDate.parse(trajetItem.getHoraire());
		this.setHoraire(horaire);
		this.setPlaceDispo(trajetItem.getPlaceDispo());
		this.setPrix(trajetItem.getPrix());
		this.setEtatTrajet(trajetItem.getEtatTrajet());
		return this;
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getHoraire() {
		return horaire;
	}

	public void setHoraire(Date horaire) {
		this.horaire = horaire;
	}

	public int getPlaceDispo() {
		return placeDispo;
	}

	public void setPlaceDispo(int placeDispo) {
		this.placeDispo = placeDispo;
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


	public Navette getNavette() {
		return navette;
	}

	public void setNavette(Navette navette) {
		this.navette = navette;
	}

	
}
