package com.formation.vtc.service.impl;


import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.vtc.dto.ReservationItem;
import com.formation.vtc.dto.ReservationListItem;
import com.formation.vtc.exception.InvalidOperationException;
import com.formation.vtc.exception.NotFoundException;
import com.formation.vtc.persistence.entity.Reservation;
import com.formation.vtc.persistence.entity.Trajet;
import com.formation.vtc.persistence.repository.ReservationRepository;
import com.formation.vtc.persistence.repository.TrajetRepository;
import com.formation.vtc.service.IReservationService;
import com.formation.vtc.utils.MailSender;

@Service
@Transactional
public class ReservationService implements IReservationService {

	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	private TrajetRepository trajetRepo;

	@Override
	public ReservationItem saveReservationTmp(ReservationItem resa) throws ParseException {
		
		//TODO faire vérif
		
		resa.setNumResa(makeNumResa(10));
		resa.setEtatResa("En attente");
		
		Reservation reservation= new Reservation();
		reservation.resaItemToResa(resa).getTrajet().setPlaceDispo(reservation.getTrajet().getPlaceDispo()-reservation.getNbPlaces());
		
		if((reservation.getTrajet().getId()==null) && !(trajetRepo.findById(reservation.getTrajet().getId()).isPresent())) {
			reservation.setTrajet(trajetRepo.save(reservation.getTrajet()));
		}
		
		return new ReservationItem(reservationRepo.save(reservation));
	}
	
	@Override
	public ReservationItem saveReservation(String numResa) throws ParseException {
		
		//TODO faire vérif si payment valide
		
		Optional<Reservation> opt= reservationRepo.findByNumResaList(numResa);
		
		//resa.setNumResa(makeNumResa(10));
		opt.get().setEtatResa("Valide");
		
		//opt.get().getTrajet().setPlaceDispo(opt.get().getTrajet().getPlaceDispo()-opt.get().getNbPlaces());
		//TODO gérer les mail et les messages d'envoi
		ReservationItem res=new ReservationItem(reservationRepo.save(opt.get()));
		if(reservationRepo.findById(res.getId()).get().getEtatResa().equals("Valide")) {
			MailSender email = new MailSender();
			String from="lokulen@gmail.com";
			String subject="Trajet Proxair validé";
			String msg="<h1>Votre trajet du : "+res.getDate()+" est validé</h1>";
			email.sendMail(res.getEmail(), from, subject, msg);
		}else throw new InternalError();
		
		return res;
	}


	public String makeNumResa(int count) {
		
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
	
	@Override
	public List<ReservationListItem> findByNumResa(List<String> numRes) {
		//return 
		
		List<String> opt = numRes.stream().
				filter(c-> reservationRepo.findByNumResaList(c).get().getEtatResa().equals("valide")).collect(Collectors.toList());
		return opt.stream().map(c-> new ReservationListItem(reservationRepo.findByNumResaList(c).get())).collect(Collectors.toList());
		
	}



	@Override
	public String deleteResa(String numRes) throws ParseException {
		Optional<Reservation> opt= reservationRepo.findByNumResaList(numRes);
		if(!(opt.isPresent())) throw new NotFoundException("La reservation: "+numRes+" n'existe pas");
		if(opt.get().getEtatResa().equals("Annulée")) throw new InvalidOperationException("La reservation: "+numRes+" a déjà été annulée");
		Date now=new Date();
		
		//TODO limite heure annulation à mettre dans la DB
	    Date now2=new Date(now.getTime());
	    
	   Date dateTrajetDate=new Date(opt.get().getTrajet().getHoraire().getTime()-3600*1000);
		if(now2.compareTo(dateTrajetDate)>0) throw new InvalidOperationException("La reservation: "+numRes+" ne pourras plus être annulée");
		opt.get().setEtatResa("Annulée");
		//TODO Faire remboursement et confirmer par mail l'annulation
		return "La reservation: "+numRes+" a été annulé";
	}
	
	@Override
	public ReservationItem selectMySit(Date date, int place) {
		
		if(date.compareTo(new Date()) >= 0) {
			
			//Création d'un objet Trajet
			Trajet trajet = new Trajet();
			
			/*On recherche dans la bdd un trajet répondant aux attentes de l'utilisateur*/
			Optional<Trajet> opt= trajetRepo.findDateHourSit(date);
			if(opt.isPresent()) {
				/*Si un trajet est trouvé..*/
				trajet = opt.get();
			
			} else {
				trajet.setDateCreation(new Date());
				trajet.setEtatTrajet("En cours");
				
				trajet.setHoraire(date);
				trajet.setNavette(null);
				trajet.setPlaceDispo(8-place);
				trajet.setPrix(8);
			}
			
			if(place <= 8 && place <= trajet.getPlaceDispo()) {
			
			Reservation resa = new Reservation();
			resa.setEtatResa("En cours");
			//TODO vérifier le nombre max de place sélectionnées
			resa.setNbPlaces(place);
			resa.setNom("Jean");
			resa.setPrenom("Jack");
			resa.setPrix(trajet.getPrix() * place);
			resa.setTrajet(trajet);
			return new ReservationItem(resa);
			
			} else throw new InvalidOperationException("Nombre de places disponible insuffisant");
			
		} else  throw new InvalidOperationException("La date est antérieur à la date actuelle");
		
		
	}

}
