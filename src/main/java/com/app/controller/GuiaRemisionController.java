package com.app.controller;

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

import com.app.dto.GuiaRemisionDTO;
import com.app.entity.GuiaRemision;
import com.app.service.GuiaRemisionService;

@RestController
@RequestMapping(path = "/api/guia-remision")
public class GuiaRemisionController {

    @Autowired
    private GuiaRemisionService guiaRemisionService;

    @GetMapping()
    public ResponseEntity<List<GuiaRemision>> getAllGuiaRemisiones() {
        List<GuiaRemision> guiaRemisiones = guiaRemisionService.getGuiasRemision();
        return ResponseEntity.ok(guiaRemisiones);
    }

    @GetMapping("/")
    public ResponseEntity<GuiaRemision> getGuiaRemisionById(@RequestParam("id") int id) {
        try {
            GuiaRemision guiaRemision = guiaRemisionService.getGuiaRemision(id);
            return ResponseEntity.ok(guiaRemision);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Void> createGuiaRemision(@Validated @RequestBody GuiaRemisionDTO guiaRemisionDTO) {
        guiaRemisionService.saveGuiaRemision(guiaRemisionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/")
    public ResponseEntity<Void> addDocumentId(@RequestParam("id") Integer id,@RequestBody String documentId) {
        try {
            guiaRemisionService.addDocumentId(id, documentId);
            return ResponseEntity.ok().build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteGuiaRemision(@RequestParam("id") int id) {
        try {
            guiaRemisionService.deleteGuiaRemision(id);
            return ResponseEntity.ok().build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }
    
    @GetMapping("/registrados-hoy")
    public ResponseEntity<Long> getGuiasRemisionRegistradasHoy() {
        long count = guiaRemisionService.getGuiasRemisionRegistradasHoy();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/count-guias-mes")
    public ResponseEntity<List<Map<String, Object>>> countGuiasRemisionPorMes() {
        List<Map<String, Object>> result = guiaRemisionService.countGuiasRemisionPorMes();
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/count-guias-ultimos-30-dias")
    public ResponseEntity<List<Map<String, Object>>> countGuiasRemisionUltimos30Dias() {
        List<Map<String, Object>> result = guiaRemisionService.countGuiasRemisionUltimos30Dias();
        return ResponseEntity.ok(result);
    }
}