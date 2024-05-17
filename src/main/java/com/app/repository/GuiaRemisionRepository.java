package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.GuiaRemision;

@Repository
public interface GuiaRemisionRepository extends JpaRepository<GuiaRemision, Integer>{

}
