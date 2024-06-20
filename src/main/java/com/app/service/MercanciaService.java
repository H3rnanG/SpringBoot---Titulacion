package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.app.dto.MercanciaDTO;
import com.app.entity.Cliente;
import com.app.entity.Mercancia;
import com.app.repository.ClienteRepository;
import com.app.repository.MercanciaRepository;

@Service
public class MercanciaService {

    @Autowired
    private MercanciaRepository mercanciaRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;

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
        Cliente cliente = clienteRepository.findById(mercanciaDTO.getIdCliente())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));
        mercancia.setCliente(cliente);

        mercanciaRepository.saveAndFlush(mercancia);
    }

    public void updateMercancia(Integer id, MercanciaDTO mercanciaDTO) {
        Mercancia mercancia = mercanciaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mercancia no encontrada"));
        
        mercancia.setNombre(mercanciaDTO.getNombre());
        mercancia.setPrecio(mercanciaDTO.getPrecio());
        mercancia.setCantidad(mercanciaDTO.getCantidad());
        mercancia.setCategoria(mercanciaDTO.getCategoria());

        Cliente cliente = clienteRepository.findById(mercanciaDTO.getIdCliente())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));
        mercancia.setCliente(cliente);

        mercanciaRepository.saveAndFlush(mercancia);
    }

    public void deleteMercancia(Integer id) {
        mercanciaRepository.deleteById(id);
    }
    
    public long getMercanciasRegistradasHoy() {
        return mercanciaRepository.countMercanciaRegistradosHoy();
    }
}