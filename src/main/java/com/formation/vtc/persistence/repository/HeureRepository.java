package com.formation.vtc.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.formation.vtc.persistence.entity.Heure;

public interface HeureRepository extends JpaRepository<Heure,Long>{
	@Query(value="SELECT * FROM heure WHERE heureDepart=?1", nativeQuery = true)
	Heure findByHeure(Long heure);
}
