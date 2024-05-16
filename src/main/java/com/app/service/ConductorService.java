package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.app.dto.ConductorDTO;
import com.app.entity.Conductor;
import com.app.repository.ConductorRepository;

@Service
public class ConductorService {

    @Autowired
    ConductorRepository conductorRepository;

    @Autowired
    ModelMapper mapper;

    public List<Conductor> getConductores() {
        return conductorRepository.findAll();
    }

    public Conductor getConductor(Integer id) {
        return conductorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conductor no encontrado"));
    }


    public void saveConductor(ConductorDTO conductorDTO) {
        Conductor conductor = mapper.map(conductorDTO, Conductor.class);
        conductorRepository.saveAndFlush(conductor);
    }

    public void updateConductor(Integer id, ConductorDTO conductorDTO) {
        Conductor conductorFromDb = conductorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conductor no encontrado"));
        mapper.map(conductorDTO, conductorFromDb);
        conductorRepository.saveAndFlush(conductorFromDb);
    }

    public void deleteConductor(Integer id) {
        conductorRepository.deleteById(id);
    }
}