package com.app.controller;

import java.util.List;

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

import com.app.dto.MercanciaDTO;
import com.app.entity.Mercancia;
import com.app.service.MercanciaService;

@RestController
@RequestMapping(path = "/api/mercancia")
public class MercanciaController {

    @Autowired
    private MercanciaService mercanciaService;

    @GetMapping()
    public ResponseEntity<List<Mercancia>> getAllMercancias() {
        List<Mercancia> mercancias = mercanciaService.getMercancias();
        return ResponseEntity.ok(mercancias);
    }

    @GetMapping("/")
    public ResponseEntity<Mercancia> getMercanciaById(@RequestParam("id") int id) {
        try {
            Mercancia mercancia = mercanciaService.getMercancia(id);
            return ResponseEntity.ok(mercancia);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Void> createMercancia(@Validated @RequestBody MercanciaDTO mercanciaDTO) {
        mercanciaService.saveMercancia(mercanciaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateMercancia(@RequestParam("id") int id, @Validated @RequestBody MercanciaDTO mercanciaDTO) {
        try {
            mercanciaService.updateMercancia(id, mercanciaDTO);
            return ResponseEntity.ok().build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteMercancia(@RequestParam("id") int id) {
        try {
            mercanciaService.deleteMercancia(id);
            return ResponseEntity.ok().build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }
}