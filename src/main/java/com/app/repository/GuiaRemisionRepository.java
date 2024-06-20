package com.app.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.GuiaRemision;

@Repository
public interface GuiaRemisionRepository extends JpaRepository<GuiaRemision, Integer>{

	@Query("SELECT COUNT(g) FROM GuiaRemision g WHERE DATE(g.fechaCreacion) = CURRENT_DATE")
    long countGuiasRemisionRegistradasHoy();
	
	@Query(value = "SELECT DATE_FORMAT(fecha_creacion, '%m') AS mes, COUNT(*) AS cantidad_guias " +
            "FROM guia_remision " +
            "WHERE fecha_creacion >= DATE_FORMAT(CURDATE() - INTERVAL 6 MONTH, '%Y-%m-01') " +
            "  AND fecha_creacion < DATE_FORMAT(CURDATE() + INTERVAL 1 MONTH, '%Y-%m-01') " +
            "GROUP BY DATE_FORMAT(fecha_creacion, '%m') " +
            "ORDER BY mes DESC", nativeQuery = true)
	List<Map<String, Object>> countGuiasRemisionPorMes();
	
	@Query(value = "SELECT DATE_FORMAT(fecha_creacion, '%m-%d') AS fecha, COUNT(*) AS cantidad_guias " +
            "FROM guia_remision " +
            "WHERE fecha_creacion >= CURDATE() - INTERVAL 30 DAY " +
            "  AND fecha_creacion < CURDATE() + INTERVAL 1 DAY " +
            "GROUP BY DATE_FORMAT(fecha_creacion, '%m-%d') " +
            "ORDER BY fecha DESC", nativeQuery = true)
	List<Map<String, Object>> countGuiasRemisionUltimos30Dias();
}
