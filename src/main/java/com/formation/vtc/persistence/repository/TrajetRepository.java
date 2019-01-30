package com.formation.vtc.persistence.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.formation.vtc.persistence.entity.Trajet;

public interface TrajetRepository extends JpaRepository<Trajet, Long> { 

	@Query (value = "SELECT * FROM trajet WHERE horaire > NOW() AND placeDispo > 0 ORDER BY horaire ASC", nativeQuery = true)
	List<Trajet> findAll();
	

	@Query(value= "SELECT * FROM trajet WHERE horaire= DATE_FORMAT(?1,\"%Y-%m-%d %T\")", nativeQuery = true)
	Optional<Trajet> findDateHourSit(Date date);

	@Query(value= "SELECT * FROM trajet WHERE horaire= DATE_FORMAT(?1,\"%Y-%m-%d\") AND placeDispo > 0 ORDER BY horaire ASC", nativeQuery = true)
	Optional<Trajet> findByDate(Date date);
	//@Query(value= "SELECT * FROM trajet WHERE horaire= DATE_FORMAT(?1,\"%Y-%M-%d\") AND placeDispo > 0  AND heure=?2 ORDER BY horaire ASC", nativeQuery = true)
	//Optional<Trajet> findByDateAndHour(Date date, Long heure);
}
