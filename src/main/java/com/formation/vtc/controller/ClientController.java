package com.formation.vtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.vtc.dto.ReservationListItem;
import com.formation.vtc.service.IReservationService;

@RestController
@RequestMapping(value="/api/client")
public class ClientController {
	
	@Autowired
	IReservationService reservationServ;
	
	@GetMapping
	@ResponseBody
	public List<ReservationListItem> findByNumResa(List<String> numRes){
		return reservationServ.findByResa(numRes);
	}
	

}
