package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Conductor;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor, Integer>{

}
