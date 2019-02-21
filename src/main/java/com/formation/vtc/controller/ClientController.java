package com.formation.vtc.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.vtc.dto.ReservationItem;
import com.formation.vtc.dto.ReservationListItem;
import com.formation.vtc.dto.TrajetListItem;
import com.formation.vtc.exception.InvalidOperationException;
import com.formation.vtc.exception.NotFoundException;
import com.formation.vtc.service.IReservationService;
import com.formation.vtc.service.ITrajetService;

@CrossOrigin
@RestController
@RequestMapping(value="/api/client")
public class ClientController {
	
	@Autowired
	IReservationService reservationServ;
	@Autowired
	ITrajetService trajetServ;

	
	@PostMapping
	@ResponseBody
	public List<ReservationListItem> findByNumResa(@RequestBody List<String> numRes){
		
		List<ReservationListItem> opt = reservationServ.findByNumResa(numRes);
		if(opt==null) throw new NotFoundException("Vous avez aucune réservation en cours");
		return opt;
	}
	
	@DeleteMapping(value="/{numRes}")
	@ResponseBody
	public String deleteResa(@PathVariable String numRes) throws ParseException{
		//TODO gérer parse exception
		return reservationServ.deleteResa(numRes);
	}
	
	@GetMapping(value="/{date}")
	@ResponseBody
	public List<TrajetListItem> findByDate(@PathVariable String date) throws ParseException{
		//TODO exception gérer
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		
		Date date1=format.parse(date);
		
		Date now=new Date();
		DateFormat formatNow=new SimpleDateFormat("yyyy-MM-dd");
		String strDate = formatNow.format(now);
		
		format.setLenient(false);
		Date now2=format.parse(strDate);
		if(date1.compareTo(now2)>=0)return trajetServ.findByDate(date1);
		else throw new InvalidOperationException("La jour demandé est antérieur au jour d'aujourd'hui" );
		
		
	}
	
	@GetMapping(value="/choose")
	@ResponseBody
	public ReservationItem chooseMySit(@RequestParam String date, @RequestParam int place) throws ParseException{
		
		SimpleDateFormat formatDate=new SimpleDateFormat("yyyy-MM-dd-HH-mm");
		formatDate.setLenient(false);
		
		//TODO exception gérer
		Date dateTrans=formatDate.parse(date);
		
		return reservationServ.selectMySit(dateTrans, place);
		
	}
	
	@PostMapping(value="/reservation")
	@ResponseBody
	public ReservationItem reservation(@RequestBody ReservationItem reservationItem) throws ParseException {
		return reservationServ.saveReservationTmp(reservationItem);
	}
	@GetMapping(value="/reservation/confirm/{numResa}")
	@ResponseBody
	public ReservationItem reservationConfirm(@PathVariable String numResa) throws ParseException {
		return reservationServ.saveReservation(numResa);
	}

}
