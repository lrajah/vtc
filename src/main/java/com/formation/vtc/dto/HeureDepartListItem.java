package com.formation.vtc.dto;

import com.formation.vtc.persistence.entity.Heure;

public class HeureDepartListItem {

	private Long heureDepart;
	private int prix;
	
	public HeureDepartListItem(Heure heures) {
		this.setHeureDepart(heures.getHeureDepart());
		this.setPrix(heures.getPrix());


	
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public Long getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(Long heureDepart) {
		this.heureDepart = heureDepart;
	}
}