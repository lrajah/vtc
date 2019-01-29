package com.formation.vtc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.vtc.dto.TrajetListItem;
import com.formation.vtc.persistence.entity.Navette;
import com.formation.vtc.persistence.entity.Reservation;
import com.formation.vtc.persistence.entity.Trajet;
import com.formation.vtc.persistence.repository.TrajetRepository;
import com.formation.vtc.service.ITrajetService;

@Service
@Transactional
public class TrajetService implements ITrajetService{

	@Autowired
	private TrajetRepository trajetRepo;
	
	@Override
	public List<TrajetListItem> findAll() {
		List<Trajet> trajets = trajetRepo.findAll();
		return trajets.stream().map(t -> new TrajetListItem(t))
				.collect(Collectors.toList());
	}

	@Override
	public List<TrajetListItem> findByDate(Date date) {
		
		ArrayList<Trajet>opt=new ArrayList<Trajet>();
		
		int heure[]= {8,11,14,17};
		
		for(int i=0;i< heure.length;i++) {
			
			Optional<Trajet> opt2= trajetRepo.findByDateAndHour(date,heure[i]);
			
			if(opt2.isPresent()) {
				opt.add(opt2.get());
			}
			else {
				Trajet trajet=new Trajet();
				trajet.setDateCreation(new Date());
				
				//TODO Faire la vérif de si c'est passé ou pas
				trajet.setEtatTrajet("Disponible");
				trajet.setHeure(heure[i]);
				trajet.setHoraire(date);
				Navette navette=new Navette();
				trajet.setNavette(navette);
				//TODO navette.getSiege
				trajet.setPlaceDispo(8);
				//TODO table parametre en vrac
				trajet.setPrix(8);
				List<Reservation> reservation=null;
				trajet.setReservation(reservation);
				
				opt.add(trajet);
			}
			
		}
//		opt.stream()
//			.map(t -> new TrajetListItem(t))
//			.
//			.collect(Collectors.toList());
//		
		
		// TODO Auto-generated method stub
		return opt.stream().map(c-> new TrajetListItem(c)).collect(Collectors.toList());
	}
	

}
