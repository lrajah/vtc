package com.formation.vtc.service;

import java.util.List;

import com.formation.vtc.dto.HeureDepartListItem;
import com.formation.vtc.persistence.entity.Heure;

public interface IHeureService {
	Heure modify(Heure initiale, Heure nouvelle);

	Heure save(Heure heureDepart);
	
	List<HeureDepartListItem> findAll();

}
