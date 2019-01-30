package com.formation.vtc.service;

import java.text.ParseException;
import java.util.List;

import com.formation.vtc.dto.ReservationListItem;
import com.formation.vtc.persistence.entity.Reservation;

public interface IReservationService {
	
	Reservation save(Reservation resa);
	List<ReservationListItem> findByNumResa(List<String> numRes);
	String deleteResa(String numRes) throws ParseException;
}
