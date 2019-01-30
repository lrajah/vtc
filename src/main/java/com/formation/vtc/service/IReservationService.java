package com.formation.vtc.service;


import java.util.Date;

import java.text.ParseException;
import java.util.List;

import com.formation.vtc.dto.ReservationItem;
import com.formation.vtc.dto.ReservationListItem;
import com.formation.vtc.persistence.entity.Reservation;

public interface IReservationService {
	
	Reservation saveReservation(Reservation resa);
	List<ReservationListItem> findByNumResa(List<String> numRes);

	ReservationItem selectMySit(Date date, int place);

	String deleteResa(String numRes) throws ParseException;
}
