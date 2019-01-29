package com.formation.vtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.vtc.dto.ReservationListItem;
import com.formation.vtc.exception.NotFoundException;
import com.formation.vtc.service.ITrajetService;

@RestController
@RequestMapping(value="/api/client")
public class ClientController {
	
	@Autowired
	ITrajetService trajetServ;
	
	@GetMapping
	@ResponseBody
	public List<ReservationListItem> findByNumResa(List<String> numRes){
		
		List<ReservationListItem> opt = trajetServ.findByNumResa(numRes);
		if(opt==null) throw new NotFoundException("Vous avez aucune réservation en cours");
		return opt;
	}
	
	@GetMapping
	@ResponseBody
	
	public String deleteResa(String numRes){
		return trajetServ.deleteResa(numRes);
	}
	
	

}
