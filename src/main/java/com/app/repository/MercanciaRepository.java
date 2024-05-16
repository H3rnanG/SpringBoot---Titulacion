package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Mercancia;

@Repository
public interface MercanciaRepository extends JpaRepository<Mercancia, Integer> {

}