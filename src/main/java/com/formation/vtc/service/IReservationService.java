package com.formation.vtc.service;

import java.util.List;

import com.formation.vtc.dto.ReservationListItem;
import com.formation.vtc.persistence.entity.Reservation;

public interface IReservationService {
	
	Reservation save(Reservation resa);
	public List<ReservationListItem> findByResa(List<String> numResa);
}
