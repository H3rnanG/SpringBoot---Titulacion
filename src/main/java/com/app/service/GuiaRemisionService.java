package com.app.service;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
    private ClienteRepository clienteRepository;
    
    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private ConductorRepository conductorRepository;

    @Autowired
    private ModelMapper mapper;

    public List<GuiaRemision> getGuiasRemision() {
        return guiaRemisionRepository.findAll();
    }

    public GuiaRemision getGuiaRemision(Integer id) {
        return guiaRemisionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Guía de remisión no encontrada"));
    }

    public GuiaRemision saveGuiaRemision(GuiaRemisionDTO guiaRemisionDTO) {
        GuiaRemision guiaRemision = mapper.map(guiaRemisionDTO, GuiaRemision.class);
        
        // Obtener el cliente remitente por su ID y asignarlo a la guía de remisión
        Cliente remitente = clienteRepository.findById(guiaRemisionDTO.getIdClienteRemitente())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente remitente no encontrado"));
        
        Conductor conductor = conductorRepository.findById(guiaRemisionDTO.getIdConductor())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conductor no encontrado"));
        
        Vehiculo vehiculo = vehiculoRepository.findById(guiaRemisionDTO.getIdVehiculo())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehiculo no encontrado"));
        
        guiaRemision.setRemitente(remitente);
        guiaRemision.setConductor(conductor);
        guiaRemision.setVehiculo(vehiculo);

        return guiaRemisionRepository.save(guiaRemision);
    }

    public void updateGuiaRemision(Integer id, GuiaRemisionDTO guiaRemisionDTO) {
        GuiaRemision guiaRemision = guiaRemisionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Guía de remisión no encontrada"));

        guiaRemision.setGuia(guiaRemisionDTO.getGuia());
        guiaRemision.setDocumentoDestinatario(guiaRemisionDTO.getDocumentoDestinatario());
        guiaRemision.setTipoDocumentoDestinatario(guiaRemisionDTO.getTipoDocumentoDestinatario());
        guiaRemision.setDestinatario(guiaRemisionDTO.getDestinatario());
        guiaRemision.setFechaEmision(guiaRemisionDTO.getFechaEmision());
        guiaRemision.setInicioTraslado(guiaRemisionDTO.getInicioTraslado());
        guiaRemision.setUbicacionPartida(guiaRemisionDTO.getUbicacionPartida());
        guiaRemision.setDireccionPartida(guiaRemisionDTO.getDireccionPartida());
        guiaRemision.setUbicacionLlegada(guiaRemisionDTO.getUbicacionLlegada());
        guiaRemision.setDireccionLlegada(guiaRemisionDTO.getDireccionLlegada());
        guiaRemision.setMedidaPeso(guiaRemisionDTO.getMedidaPeso());
        guiaRemision.setPesoBruto(guiaRemisionDTO.getPesoBruto());

        // Obtener y asignar el vehículo
        Vehiculo vehiculo = vehiculoRepository.findById(guiaRemisionDTO.getIdVehiculo())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehículo no encontrado"));
        guiaRemision.setVehiculo(vehiculo);

        // Obtener y asignar el conductor
        Conductor conductor = conductorRepository.findById(guiaRemisionDTO.getIdConductor())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conductor no encontrado"));
        guiaRemision.setConductor(conductor);

        // Obtener y asignar el cliente remitente
        Cliente clienteRemitente = clienteRepository.findById(guiaRemisionDTO.getIdClienteRemitente())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente remitente no encontrado"));
        guiaRemision.setRemitente(clienteRemitente);

        guiaRemisionRepository.saveAndFlush(guiaRemision);
    }

    public void deleteGuiaRemision(Integer id) {
        guiaRemisionRepository.deleteById(id);
    }
    
    public void addDocumentId(Integer id, String documentId) {
        GuiaRemision guiaRemision = guiaRemisionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Guía de remisión no encontrada"));

        guiaRemision.setDocumentId(documentId);
        guiaRemisionRepository.save(guiaRemision);
    }

    public long getGuiasRemisionRegistradasHoy() {
        return guiaRemisionRepository.countGuiasRemisionRegistradasHoy();
    }
    
    public List<Map<String, Object>> countGuiasRemisionPorMes() {
        return guiaRemisionRepository.countGuiasRemisionPorMes();
    }
    
    public List<Map<String, Object>> countGuiasRemisionUltimos30Dias() {
        return guiaRemisionRepository.countGuiasRemisionUltimos30Dias();
    }
}
