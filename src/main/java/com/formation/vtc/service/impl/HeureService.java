package com.formation.vtc.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.vtc.dto.HeureDepartListItem;
import com.formation.vtc.exception.InvalidOperationException;
import com.formation.vtc.persistence.entity.Heure;
import com.formation.vtc.persistence.repository.HeureRepository;
import com.formation.vtc.service.IHeureService;
@Service
@Transactional
public class HeureService implements IHeureService {
	
	@Autowired
	private HeureRepository heureRepo;
	
	@Override
	public  Heure save(Heure heureDepart) {
		
		if((heureDepart.getHeureDepart() < 0) ||(heureDepart.getHeureDepart()>=24*3600*1000) ) throw new InvalidOperationException("L'heure de départ n'est pas conforme");
		return heureRepo.save(heureDepart);
	}

	

	@Override
	public List<HeureDepartListItem> findAll() {
		List<Heure> heures = heureRepo.findAll();
		return heures.stream().map(h -> new HeureDepartListItem(h))
				.collect(Collectors.toList());
	
	}
	
	@Override
	public Heure modify(Heure initiale, Heure nouvelle) {

		Heure h = heureRepo.findByHeure(initiale.getHeureDepart());
		h.setHeureDepart(nouvelle.getHeureDepart());
		h.setPrix(nouvelle.getPrix());
		heureRepo.save(h);
		//TODO Verifier si save a fonctionné
		//heureRepo.save(heureRepo.findByHeure(initiale).setHeureDepart(nouvelle));
		return h;
	}
	
}
