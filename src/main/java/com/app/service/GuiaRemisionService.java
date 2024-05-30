package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.app.dto.GuiaRemisionDTO;
import com.app.entity.Conductor;
import com.app.entity.GuiaRemision;
import com.app.entity.Vehiculo;
import com.app.repository.ConductorRepository;
import com.app.repository.GuiaRemisionRepository;
import com.app.repository.VehiculoRepository;

@Service
public class GuiaRemisionService {

    @Autowired
    private GuiaRemisionRepository guiaRemisionRepository;
    
    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private ConductorRepository conductorRepository;

    @Autowired
    ModelMapper mapper;

    public List<GuiaRemision> getGuiasRemision() {
        return guiaRemisionRepository.findAll();
    }

    public GuiaRemision getGuiaRemision(Integer id) {
        return guiaRemisionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Guía de remisión no encontrada"));
    }

    public GuiaRemision saveGuiaRemision(GuiaRemisionDTO guiaRemisionDTO) {
        GuiaRemision guiaRemision = mapper.map(guiaRemisionDTO, GuiaRemision.class);
        
        Vehiculo vehiculo = vehiculoRepository.findById(guiaRemisionDTO.getIdVehiculo())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehículo no encontrado"));
        
        Conductor conductor = conductorRepository.findById(guiaRemisionDTO.getIdConductor())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conductor no encontrado"));
        
        guiaRemision.setVehiculo(vehiculo);
        guiaRemision.setConductor(conductor);
        
        guiaRemision = guiaRemisionRepository.saveAndFlush(guiaRemision);
        
        return guiaRemision;
    }

    public void addDocumentId(Integer id, String documentId) {
        GuiaRemision guiaRemision = guiaRemisionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Guía de remisión no encontrada"));
        guiaRemision.setDocumentId(documentId);
        guiaRemisionRepository.saveAndFlush(guiaRemision);
    }

    public void deleteGuiaRemision(Integer id) {
        guiaRemisionRepository.deleteById(id);
    }
}