package com.formation.vtc.service.impl;

import java.text.ParseException;
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
import com.formation.vtc.persistence.entity.Trajet;
import com.formation.vtc.persistence.repository.TrajetRepository;
import com.formation.vtc.service.ITrajetService;

@Service
@Transactional
public class TrajetService implements ITrajetService {

	@Autowired
	private TrajetRepository trajetRepo;
	
	
	@Override
	public List<TrajetListItem> findAll() {
		List<Trajet> trajets = trajetRepo.findAll();
		return trajets.stream().map(t -> new TrajetListItem(t))
				.collect(Collectors.toList());
	}


	
	
	@Override
	public List<TrajetListItem> findByDate(Date date) throws ParseException {
		
		ArrayList<Trajet>opt=new ArrayList<Trajet>();
		//TODO Ecrire dans la BD
		Long heure[]= {new Long(28800000),new Long(39600000),new Long(50400000),new Long(61200000)};
		
		for(Long h:heure) {
			
			Date horaire= new Date(date.getTime()+h);
			Optional<Trajet> opt2= trajetRepo.findByDate(horaire);
			
			if(opt2.isPresent()) {
				opt.add(opt2.get());
			}
			else {
				Trajet trajet=new Trajet();
				trajet.setDateCreation(new Date());
				
				//TODO Faire la vérif de si c'est passé ou pas
				trajet.setEtatTrajet("Disponible");

				trajet.setHoraire(horaire);
				Navette navette=new Navette();
				trajet.setNavette(navette);
				//TODO navette.getSiege
				trajet.setPlaceDispo(8);
				//TODO table parametre en vrac
				trajet.setPrix(8);
				
				opt.add(trajet);
			}
			
		}
		return opt.stream().map(c-> new TrajetListItem(c)).collect(Collectors.toList());
	}

}
