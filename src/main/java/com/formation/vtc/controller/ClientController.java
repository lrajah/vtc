package com.formation.vtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.vtc.dto.ReservationListItem;
<<<<<<< HEAD
import com.formation.vtc.service.IReservationService;
=======
import com.formation.vtc.exception.NotFoundException;
import com.formation.vtc.service.ITrajetService;
>>>>>>> refs/heads/devLo

@RestController
@RequestMapping(value="/api/client")
public class ClientController {
	
	@Autowired
<<<<<<< HEAD
	IReservationService reservationServ;
=======
	ITrajetService trajetServ;
>>>>>>> refs/heads/devLo
	
	@GetMapping
	@ResponseBody
	public List<ReservationListItem> findByNumResa(List<String> numRes){
<<<<<<< HEAD
		return reservationServ.findByResa(numRes);
=======
		
		List<ReservationListItem> opt = trajetServ.findByNumResa(numRes);
		if(opt==null) throw new NotFoundException("Vous avez aucune réservation en cours");
		return opt;
>>>>>>> refs/heads/devLo
	}
	
	@GetMapping
	@ResponseBody
	
	public String deleteResa(String numRes){
		return trajetServ.deleteResa(numRes);
	}
	
	

}
