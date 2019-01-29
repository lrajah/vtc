package com.formation.vtc.service;

import java.util.List;

import com.formation.vtc.dto.ReservationListItem;
import com.formation.vtc.dto.TrajetListItem;

public interface ITrajetService {

	List<TrajetListItem> findAll();
	List<ReservationListItem> findByNumResa(List<String> numRes);
	String deleteResa(String numRes);
}
