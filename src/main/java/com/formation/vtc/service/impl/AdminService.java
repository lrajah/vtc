package com.formation.vtc.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.vtc.dto.ReservationItem;
import com.formation.vtc.dto.TrajetListItem;
import com.formation.vtc.exception.InvalidOperationException;
import com.formation.vtc.persistence.entity.Reservation;
import com.formation.vtc.persistence.entity.Trajet;
import com.formation.vtc.persistence.repository.ReservationRepository;
import com.formation.vtc.persistence.repository.TrajetRepository;
import com.formation.vtc.service.IAdminService;
import com.formation.vtc.utils.MailSender;

@Service
@Transactional
public class AdminService implements IAdminService{
	
	@Autowired
	TrajetRepository trajetRepo;
	
	@Autowired
	ReservationRepository reservationRepo;

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
		MailSender email = new MailSender();
		
		List<Reservation> reservations= reservationRepo.findByTrajetId(id);
		if(reservations==null) return new TrajetListItem(opt.get());
		
		TrajetListItem res=new TrajetListItem(opt.get());
		String from="lokulen@gmail.com";
		String subject="Trajet Proxair annulé";
		String msg="<h1>Le trajet du : "+res.getHoraire()+"  a été annulé par Proxair</h1>";
		
		for(Reservation r:reservations) {
			email.sendMail(r.getMail(), from, subject, msg);
		}
		
		return new TrajetListItem(opt.get());
	}
	
	@Override
	public ReservationItem findResa(String numResa) {
		Optional<Reservation> opt = reservationRepo.findByNumResaList(numResa);
		
		if(opt.isPresent()) {
			if(opt.get().getEtatResa().equals("Valide")) return new ReservationItem(opt.get());
			if(!opt.get().getEtatResa().equals("Valide")) throw new InvalidOperationException("Le numéro de réservation : "+numResa+" n'a pas encore été validé");
		} else throw new InvalidOperationException("Le numéro de réservation : "+numResa+" n'existe pas");
		return null;
	}
	
}
