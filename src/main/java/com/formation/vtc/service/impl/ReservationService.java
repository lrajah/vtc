package com.formation.vtc.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.vtc.dto.ReservationListItem;
import com.formation.vtc.exception.InvalidOperationException;
import com.formation.vtc.exception.NotFoundException;
import com.formation.vtc.persistence.entity.Reservation;
import com.formation.vtc.persistence.repository.ReservationRepository;
import com.formation.vtc.service.IReservationService;

@Service
@Transactional
public class ReservationService implements IReservationService {

	@Autowired
	private ReservationRepository reservationRepo;

	@Override
	public Reservation save(Reservation resa) {

		Reservation resaTemp = new Reservation();

		resaTemp.setNom(resa.getNom());
		resaTemp.setPrenom(resa.getPrenom());
		resaTemp.setNumResa(makeNumResa(10));
		resaTemp.setPrix(resa.getNbPlaces() * 8);
		resaTemp.setNbPlaces(resa.getNbPlaces());
		resaTemp.setEtatResa("valide");
		resaTemp.setMail("toto@test.com");
		return reservationRepo.save(resaTemp);
	}

	private String makeNumResa(int count) {
		
		int a = 0;
		
		String alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		
		String numResaMade=null;
		boolean stop = true;
		
		while (stop) {
			StringBuilder builder = new StringBuilder();
			// Count va de 10 à 0
			
			
			
			while (count-- != 0) {

				int character = (int) (Math.random() * alphaNumeric.length());

				builder.append(alphaNumeric.charAt(character));

			}
			
			count=10;
			numResaMade = builder.toString();
			
			if(a == 0) {
				a++;
				numResaMade = "VFT6N4PXIC";
			}
			
			if((uniqueVerif(numResaMade))) stop=false;
			
			
		}
		System.out.println(numResaMade);
		return numResaMade;
	}

	private boolean uniqueVerif(String numResaMade) {
		List<Reservation> reservationsEnregistrees = reservationRepo.findAll();

		for (int i = 0; i < reservationsEnregistrees.size(); i++) {
			
			if(reservationRepo.findByNumResaList(numResaMade).isPresent()) {
				return false;
			}

//			if ((reservationsEnregistrees.get(i).getNumResa().equals(numResaMade))) {
//				return false;
//			}
			
		}
		return true;
	}
	
	public List<ReservationListItem> findByResa(List<String> numResa){
		return numResa.stream().map(c-> new ReservationListItem(reservationRepo.findByNumResaList(c).get())).collect(Collectors.toList());
	}
	
	@Override
	public List<ReservationListItem> findByNumResa(List<String> numRes) {
		return numRes.stream().map(c-> new ReservationListItem(reservationRepo.findByNumResaList(c).get())).collect(Collectors.toList());
	}



	@Override
	public String deleteResa(String numRes) {
		Optional<Reservation> opt= reservationRepo.findByNumResaList(numRes);
		if(!(opt.isPresent())) throw new NotFoundException("La reservation: "+numRes+" n'existe pas");
		if(opt.get().getEtatResa().equals("Annulée")) throw new InvalidOperationException("La reservation: "+numRes+" a déjà été annulée");
		opt.get().setEtatResa("Annulée");
		return "La reservation: "+numRes+" a été annulé";
	}
}
