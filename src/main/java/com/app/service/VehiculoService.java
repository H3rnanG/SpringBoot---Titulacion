package com.app.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.app.dto.VehiculoDTO;
import com.app.entity.Vehiculo;
import com.app.repository.VehiculoRepository;

@Service
public class VehiculoService {

    @Autowired
    VehiculoRepository vehiculoRepository;
    
    @Autowired
    ModelMapper mapper;
    
    public List<Vehiculo> getVehiculos(){
        return vehiculoRepository.findAll();
    }
    
    public Vehiculo getVehiculo(Integer id){
        return vehiculoRepository.findById(id)
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehículo no encontrado"));
    }
    
    public void saveVehiculo(VehiculoDTO vehiculoDTO) {
        Vehiculo vehiculo = mapper.map(vehiculoDTO, Vehiculo.class);
        vehiculoRepository.saveAndFlush(vehiculo);    
    }
    
    public void updateVehiculo(Integer id, VehiculoDTO vehiculoDTO) {
        Vehiculo vehiculoFromDb = vehiculoRepository.findById(id)
                                                     .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehículo no encontrado"));
        mapper.map(vehiculoDTO, vehiculoFromDb);
        vehiculoRepository.saveAndFlush(vehiculoFromDb);
    }
    
    public void deleteVehiculo(Integer id) {
        vehiculoRepository.deleteById(id);
    }
    
    public Map<String, BigDecimal> countByEstado() {
        return vehiculoRepository.countByEstado();
    }
    
    public List<Map<String, Object>> getVehiculosConViajes() {
        List<Object[]> results = vehiculoRepository.findVehiculoViajes();
        List<Map<String, Object>> vehiculosViajes = new ArrayList();

        for (Object[] result : results) {
            Map<String, Object> vehiculo = new HashMap<>();
            vehiculo.put("placa", result[0]);
            vehiculo.put("numeroViajes", result[1]);
            vehiculosViajes.add(vehiculo);
        }

        return vehiculosViajes;
    }
    
}
