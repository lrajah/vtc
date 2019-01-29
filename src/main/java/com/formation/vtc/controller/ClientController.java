package com.formation.vtc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.vtc.dto.ReservationListItem;
import com.formation.vtc.exception.NotFoundException;
import com.formation.vtc.service.IReservationService;


@RestController
@RequestMapping(value="/api/client")
public class ClientController {
	
	@Autowired
	IReservationService reservationServ;

	
	@PostMapping
	@ResponseBody
	public List<ReservationListItem> findByNumResa(@RequestBody List<String> numRes){
		
		List<ReservationListItem> opt = reservationServ.findByNumResa(numRes);
		if(opt==null) throw new NotFoundException("Vous avez aucune réservation en cours");
		return opt;
	}
	
	@DeleteMapping(value="/{numRes}")
	@ResponseBody
	public String deleteResa(@PathVariable String numRes){
		return reservationServ.deleteResa(numRes);
	}
	
	

}
