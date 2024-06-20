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

import com.app.dto.ClienteDTO;
import com.app.entity.Cliente;
import com.app.service.ClienteService;

@RestController
@RequestMapping(path = "/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping()
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.getClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/")
    public ResponseEntity<Cliente> getClienteById(@RequestParam("id") int id) {
        try {
            Cliente cliente = clienteService.getCliente(id);
            return ResponseEntity.ok(cliente);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Void> createCliente(@Validated @RequestBody ClienteDTO clienteDTO) {
        clienteService.saveCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateCliente(@RequestParam("id") int id, @Validated @RequestBody ClienteDTO clienteDTO) {
        try {
            clienteService.updateCliente(id, clienteDTO);
            return ResponseEntity.ok().build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteCliente(@RequestParam("id") int id) {
        try {
            clienteService.deleteCliente(id);
            return ResponseEntity.ok().build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }
    
    @GetMapping("/registrados-hoy")
    public ResponseEntity<Long> getClientesRegistradosHoy() {
        long count = clienteService.getClientesRegistradosHoy();
        return ResponseEntity.ok(count);
    }
    
    @GetMapping("/clientes-por-mes")
    public ResponseEntity<Map<String, Long>> getClientesPorMes() {
        Map<String, Long> clientesPorMes = clienteService.clientesPorMes();
        return ResponseEntity.ok(clientesPorMes);
    }
}

