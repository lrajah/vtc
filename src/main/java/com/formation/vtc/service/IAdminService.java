package com.formation.vtc.service;

import com.formation.vtc.dto.ReservationItem;
import com.formation.vtc.dto.TrajetListItem;

public interface IAdminService {
	TrajetListItem cancelTournee(long id);
	ReservationItem findResa(String resa);
}
