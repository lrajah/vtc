package com.formation.vtc.service.impl;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.vtc.dto.TrajetListItem;
import com.formation.vtc.exception.InvalidOperationException;
import com.formation.vtc.persistence.entity.Trajet;
import com.formation.vtc.persistence.repository.TrajetRepository;
import com.formation.vtc.service.IAdminService;

@Service
@Transactional
public class AdminService implements IAdminService{
	
	@Autowired
	TrajetRepository trajetRepo;
	
	@Override
	public TrajetListItem cancelTournee(long id) {
		
		Optional<Trajet> opt = trajetRepo.findById(id);
		
		if(opt.isPresent()) {
			
			if(opt.get().getEtatTrajet().equals("Annulée")) throw new InvalidOperationException("Le trajet : "+id+" a déjà été annulé");
			Date now=new Date();
			
			//TODO limite heure annulation à mettre dans la DB
		    Date now2=new Date(now.getTime());
		    
		   Date dateTrajetDate=new Date(opt.get().getHoraire().getTime()-3600*1000);
			if(now2.compareTo(dateTrajetDate)>0) throw new InvalidOperationException("Le trajet : "+id+" ne peut plus être annulé");
			opt.get().setEtatTrajet("Annulée");
			
		} else throw new InvalidOperationException("Le trajet : "+id+" n'a pas été trouvé");
		
		return new TrajetListItem(opt.get());
	}
	
}