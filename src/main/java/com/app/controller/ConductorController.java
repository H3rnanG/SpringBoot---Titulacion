package com.app.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.app.dto.ConductorDTO;
import com.app.dto.ConductorViajesDTO;
import com.app.entity.Conductor;
import com.app.service.ConductorService;
import com.app.service.GuiaRemisionService;

@RestController
@RequestMapping(path = "/api/conductor")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @GetMapping()
    public ResponseEntity<List<Conductor>> getAllConductores() {
        List<Conductor> conductores = conductorService.getConductores();
        return ResponseEntity.ok(conductores);
    }

    @GetMapping("/")
    public ResponseEntity<Conductor> getConductorById(@RequestParam("id") int id) {
        try {
            Conductor conductor = conductorService.getConductor(id);
            return ResponseEntity.ok(conductor);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Void> createConductor(@Validated @RequestBody ConductorDTO conductorDTO) {
        conductorService.saveConductor(conductorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateConductor(@RequestParam("id") int id, @Validated @RequestBody ConductorDTO conductorDTO) {
        try {
            conductorService.updateConductor(id, conductorDTO);
            return ResponseEntity.ok().build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteConductor(@RequestParam("id") int id) {
        try {
            conductorService.deleteConductor(id);
            return ResponseEntity.ok().build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }
    
    @GetMapping("/viajes")
    public ResponseEntity<List<Map<String, Object>>> getConductoresConViajes() {
        List<Map<String, Object>> conductores = conductorService.getConductoresConViajes();
        return ResponseEntity.ok(conductores);
    }
    
    @GetMapping("/estado")
    public Map<String, BigDecimal> getCountByEstado() {
        return conductorService.getCountByEstado();
    }
    
}