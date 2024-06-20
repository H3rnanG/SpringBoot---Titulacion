package com.app.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

    @Query("SELECT COUNT(c) FROM Cliente c WHERE DATE(c.fechaCreacion) = CURRENT_DATE")
    long countClientesRegistradosHoy();
    
    Long countClientesByFechaCreacionBefore(LocalDateTime fecha);
}
