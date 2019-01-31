package com.formation.vtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.vtc.dto.TrajetListItem;
import com.formation.vtc.persistence.entity.Reservation;
import com.formation.vtc.service.IReservationService;
import com.formation.vtc.service.ITrajetService;

@RestController
@RequestMapping(value="/api/trajet")
public class TrajetController {


	@Autowired
	private ITrajetService trajetService;
	
	
	@GetMapping
	@ResponseBody
	public List<TrajetListItem> findAll() {
		
		return trajetService.findAll();
	}
	
	
}