package com.app.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.Vehiculo;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer>{

	@Query(value = "SELECT " +
            "  SUM(CASE WHEN estado = 'Disponible' THEN 1 ELSE 0 END) AS Disponible, " +
            "  SUM(CASE WHEN estado = 'Ocupado' THEN 1 ELSE 0 END) AS Ocupado " +
            "FROM vehiculo", nativeQuery = true)
	Map<String, BigDecimal> countByEstado();
	
	@Query(value = "SELECT v.placa AS placa, COUNT(gr.id_guia_remision) AS numero_viajes " +
            "FROM vehiculo v " +
            "LEFT JOIN guia_remision gr ON v.id_vehiculo = gr.id_vehiculo " +
            "WHERE gr.fecha_emision >= DATE_FORMAT(CURDATE(), '%Y-%m-01') " +
            "AND gr.fecha_emision < DATE_FORMAT(DATE_ADD(CURDATE(), INTERVAL 1 MONTH), '%Y-%m-01') " +
            "GROUP BY v.id_vehiculo, v.placa " +
            "ORDER BY numero_viajes DESC", nativeQuery = true)
    List<Object[]> findVehiculoViajes();
	
}