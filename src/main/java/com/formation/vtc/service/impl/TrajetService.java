package com.formation.vtc.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.activity.InvalidActivityException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.vtc.dto.ReservationListItem;
import com.formation.vtc.dto.TrajetListItem;
import com.formation.vtc.exception.InvalidOperationException;
import com.formation.vtc.exception.NotFoundException;
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
	
<<<<<<< HEAD
=======


	@Override
	public List<ReservationListItem> findByNumResa(List<String> numRes) {
		return numRes.stream().map(c-> new ReservationListItem(trajetRepo.findByNumResaList(c))).collect(Collectors.toList());
	}



	@Override
	public String deleteResa(String numRes) {
		Reservation opt= trajetRepo.findByNumResaList(numRes);
		if(opt==null) throw new NotFoundException("La reservation: "+numRes+" n'existe pas");
		if(opt.getEtatResa()=="Annulée") throw new InvalidOperationException("La reservation: "+numRes+" a déjà été annulée");
		opt.setEtatResa("La reservation: "+numRes+" a été annulé");
		return null;
	}
	
>>>>>>> refs/heads/devLo
	
}
