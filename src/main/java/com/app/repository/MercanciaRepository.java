package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.Mercancia;

@Repository
public interface MercanciaRepository extends JpaRepository<Mercancia, Integer> {
	
	@Query("SELECT COUNT(m) FROM Mercancia m WHERE DATE(m.fechaCreacion) = CURRENT_DATE")
    long countMercanciaRegistradosHoy();
	
}