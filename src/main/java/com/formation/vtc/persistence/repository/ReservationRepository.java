package com.formation.vtc.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.formation.vtc.persistence.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> { 
	@Query (value = "SELECT * FROM reservation WHERE numResa =?1 ", nativeQuery = true)
	Optional<Reservation> findByNumResaList(String numResa);
	@Query (value = "SELECT * FROM reservation WHERE IdTrajet =?1 ", nativeQuery = true)
	List<Reservation> findByTrajetId(Long id);
}
