package com.formation.vtc.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.formation.vtc.dto.TrajetListItem;

public interface ITrajetService {

	List<TrajetListItem> findAll();
	List<TrajetListItem> findByDate(Date date) throws ParseException;
}
