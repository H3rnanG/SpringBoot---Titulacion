package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.app.dto.MercanciaDTO;
import com.app.entity.Mercancia;
import com.app.repository.MercanciaRepository;

@Service
public class MercanciaService {

    @Autowired
    MercanciaRepository mercanciaRepository;

    @Autowired
    ModelMapper mapper;

    public List<Mercancia> getMercancias() {
        return mercanciaRepository.findAll();
    }

    public Mercancia getMercancia(Integer id) {
        return mercanciaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mercancia no encontrada"));
    }


    public void saveMercancia(MercanciaDTO mercanciaDTO) {
        Mercancia mercancia = mapper.map(mercanciaDTO, Mercancia.class);
        mercanciaRepository.saveAndFlush(mercancia);
    }

    public void updateMercancia(Integer id, MercanciaDTO mercanciaDTO) {
        Mercancia mercanciaFromDb = mercanciaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mercancia no encontrada"));
        mapper.map(mercanciaDTO, mercanciaFromDb);
        mercanciaRepository.saveAndFlush(mercanciaFromDb);
    }

    public void deleteMercancia(Integer id) {
        mercanciaRepository.deleteById(id);
    }
}