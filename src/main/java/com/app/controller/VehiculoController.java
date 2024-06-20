package com.app.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.app.dto.VehiculoDTO;
import com.app.entity.Vehiculo;
import com.app.service.VehiculoService;

@RestController
@RequestMapping(path = "/api/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping()
    public ResponseEntity<List<Vehiculo>> getAllVehiculos() {
        List<Vehiculo> vehiculos = vehiculoService.getVehiculos();
        return ResponseEntity.ok(vehiculos);
    }

    @GetMapping("/")
    public ResponseEntity<Vehiculo> getVehiculoById(@RequestParam("id") int id) {
        try {
            Vehiculo vehiculo = vehiculoService.getVehiculo(id);
            return ResponseEntity.ok(vehiculo);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Void> createVehiculo(@Validated @RequestBody VehiculoDTO vehiculoDTO) {
        vehiculoService.saveVehiculo(vehiculoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateVehiculo(@RequestParam("id") int id, @Validated @RequestBody VehiculoDTO vehiculoDTO) {
        try {
            vehiculoService.updateVehiculo(id, vehiculoDTO);
            return ResponseEntity.ok().build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteVehiculo(@RequestParam("id") int id) {
        try {
            vehiculoService.deleteVehiculo(id);
            return ResponseEntity.ok().build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }
    
    @GetMapping("/estado")
    public ResponseEntity<Map<String, BigDecimal>> getCountByEstado() {
        Map<String, BigDecimal> countByEstado = vehiculoService.countByEstado();
        return ResponseEntity.ok(countByEstado);
    }
    
    @GetMapping("/viajes")
    public ResponseEntity<List<Map<String, Object>>> getVehiculosConViajes() {
        List<Map<String, Object>> vehiculos = vehiculoService.getVehiculosConViajes();
        return ResponseEntity.ok(vehiculos);
    }
}