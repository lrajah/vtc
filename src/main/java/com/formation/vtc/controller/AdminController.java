package com.formation.vtc.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.vtc.dto.HeureDepartListItem;
import com.formation.vtc.dto.TrajetListItem;
import com.formation.vtc.persistence.entity.Heure;
import com.formation.vtc.service.IAdminService;
import com.formation.vtc.service.IHeureService;

@RestController
@RequestMapping(value="/api/admin")
public class AdminController {

	
	@Autowired
	private IHeureService heureServ;
	
	@Autowired
	private IAdminService adminServ;
	


	@PostMapping(value="/save")
	@ResponseBody
	public Heure save(@RequestBody Heure heureDepart){
		return heureServ.save( heureDepart);
	}
	
	@GetMapping(value="/tournee")
	@ResponseBody
	public List<HeureDepartListItem> findAll() {
		
		return heureServ.findAll();
	}
	
	@PostMapping(value="/modify")
	@ResponseBody
	public Heure modify(@RequestBody List<Heure> heureToModify){
		return heureServ.modify(heureToModify.get(0),heureToModify.get(1) );
	}
	
	//Annuler l'etat d'une tournee
	@DeleteMapping(value="/tournee")
	@ResponseBody
	public TrajetListItem cancelTournee(@RequestParam long id) throws ParseException{
		
		return adminServ.cancelTournee(id);
	}
}
