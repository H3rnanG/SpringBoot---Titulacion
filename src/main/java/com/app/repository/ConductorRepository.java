package com.app.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.dto.ConductorViajesDTO;
import com.app.entity.Conductor;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor, Integer>{

	@Query(value = "SELECT CONCAT(c.nombre, ' ', c.apellido) AS nombre_completo, COUNT(gr.id_guia_remision) AS numero_viajes " +
            "FROM conductor c " +
            "LEFT JOIN guia_remision gr ON c.id_conductor = gr.id_conductor " +
            "WHERE gr.fecha_emision >= DATE_FORMAT(CURDATE(), '%Y-%m-01') " +
            "AND gr.fecha_emision < DATE_FORMAT(DATE_ADD(CURDATE(), INTERVAL 1 MONTH), '%Y-%m-01') " +
            "GROUP BY c.id_conductor, c.nombre, c.apellido " +
            "ORDER BY numero_viajes DESC", nativeQuery = true)
	List<Object[]> findConductorViajes();
	
	@Query(value = "SELECT " +
            "  SUM(CASE WHEN estado = 'Disponible' THEN 1 ELSE 0 END) AS Disponible, " +
            "  SUM(CASE WHEN estado = 'Ocupado' THEN 1 ELSE 0 END) AS Ocupado " +
            "FROM conductor", nativeQuery = true)
	Map<String, BigDecimal> countByEstado();
}
