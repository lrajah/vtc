package com.formation.vtc.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.vtc.dto.ReservationListItem;
import com.formation.vtc.dto.TrajetListItem;
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
	
	
}
