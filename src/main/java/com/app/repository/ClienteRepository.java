package com.app.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

    @Query("SELECT COUNT(c) FROM Cliente c WHERE DATE(c.fechaCreacion) = CURRENT_DATE")
    long countClientesRegistradosHoy();
    
    Long countClientesByFechaCreacionBefore(LocalDateTime fecha);
    
    @Query(value = "SELECT c.id_cliente AS idCliente, c.nombre_razon_social AS nombreRazonSocial, COUNT(gr.id_guia_remision) AS cantidadGuias " +
            "FROM cliente c " +
            "LEFT JOIN guia_remision gr ON c.id_cliente = gr.id_cliente_remitente " +
            "GROUP BY c.id_cliente, c.nombre_razon_social " +
            "ORDER BY cantidadGuias DESC " +
            "LIMIT 5", nativeQuery = true)
     List<Map<String, Object>> findTopClientesByGuiasGeneradas();
    
    @Query(value ="SELECT c.id_cliente AS idCliente, c.nombre_razon_social AS nombreRazonSocial, COUNT(m.id_mercancia) AS cantidadMercancias " +
            "FROM cliente c " +
            "LEFT JOIN mercancia m ON c.id_cliente = m.id_cliente " +
            "GROUP BY c.id_cliente, c.nombre_razon_social " +
            "ORDER BY cantidadMercancias DESC " +
            "LIMIT 5", nativeQuery = true)
    List<Map<String, Object>> findTopClientesByMercancias();
}
