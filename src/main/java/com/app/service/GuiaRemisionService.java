package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.app.dto.GuiaRemisionDTO;
import com.app.entity.Cliente;
import com.app.entity.Conductor;
import com.app.entity.GuiaRemision;
import com.app.entity.Vehiculo;
import com.app.repository.ClienteRepository;
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

    public void saveGuiaRemision(GuiaRemisionDTO guiaRemisionDTO) {
        GuiaRemision guiaRemision = mapper.map(guiaRemisionDTO, GuiaRemision.class);
        Vehiculo vehiculo = vehiculoRepository.findById(guiaRemisionDTO.getIdVehiculo())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehículo no encontrado"));
        Conductor conductor = conductorRepository.findById(guiaRemisionDTO.getIdConductor())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conductor no encontrado"));
        guiaRemision.setVehiculo(vehiculo);
        guiaRemision.setConductor(conductor);
        guiaRemisionRepository.saveAndFlush(guiaRemision);
    }

    public void updateGuiaRemision(Integer id, GuiaRemisionDTO guiaRemisionDTO) {
        GuiaRemision guiaRemision = guiaRemisionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Guía de remisión no encontrada"));
        guiaRemision.setRucRemitente(guiaRemisionDTO.getRucRemitente());
        guiaRemision.setRemitente(guiaRemisionDTO.getRemitente());
        guiaRemision.setRucDestinatario(guiaRemisionDTO.getRucDestinatario());
        guiaRemision.setDestinatario(guiaRemisionDTO.getDestinatario());
        guiaRemision.setFechaEmision(guiaRemisionDTO.getFechaEmision());
        guiaRemision.setInicioTraslado(guiaRemisionDTO.getInicioTraslado());
        guiaRemision.setUbicacionPartida(guiaRemisionDTO.getUbicacionPartida());
        guiaRemision.setDireccionPartida(guiaRemisionDTO.getDireccionPartida());
        guiaRemision.setUbicacionLlegada(guiaRemisionDTO.getUbicacionLlegada());
        guiaRemision.setDireccionLlegada(guiaRemisionDTO.getDireccionLlegada());
        guiaRemision.setMedidaPeso(guiaRemisionDTO.getMedidaPeso());
        guiaRemision.setPesoBruto(guiaRemisionDTO.getPesoBruto());
        guiaRemisionRepository.saveAndFlush(guiaRemision);
    }

    public void deleteGuiaRemision(Integer id) {
        guiaRemisionRepository.deleteById(id);
    }
}