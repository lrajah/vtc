package com.formation.vtc.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.formation.vtc.persistence.entity.Reservation;
import com.formation.vtc.persistence.entity.Trajet;

public interface TrajetRepository extends JpaRepository<Trajet, Long> { 

	@Query (value = "SELECT * FROM reservation WHERE numResa =?1 ", nativeQuery = true)
	Reservation findByNumResaList(String numResa);

	@Query (value = "SELECT * FROM trajet ORDER BY horaire ASC", nativeQuery = true)
	List<Trajet> findAll();
}
