package com.app.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.app.dto.ClienteDTO;
import com.app.entity.Cliente;
import com.app.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ModelMapper mapper;
	
	public List<Cliente> getClientes(){
		return clienteRepository.findAll();
	}
	
	public Cliente getCliente(Integer id){
		return clienteRepository.findById(id)
								.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));
	}
		
	
	public void saveCliente(ClienteDTO clienteDTO) {
		Cliente cliente = mapper.map(clienteDTO, Cliente.class);
		clienteRepository.saveAndFlush(cliente);	
	}
	
	public void updateCliente(Integer id, ClienteDTO clienteDTO) {
		Cliente clienteFromDb = clienteRepository.findById(id)
												 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));
		mapper.map(clienteDTO, clienteFromDb);
		clienteRepository.saveAndFlush(clienteFromDb);
	}
	
	public void deleteCliente(Integer id) {
		clienteRepository.deleteById(id);
	}
	
	public long getClientesRegistradosHoy() {
        return clienteRepository.countClientesRegistradosHoy();
    }
	
	public Map<String, Long> clientesPorMes() {
        Map<String, Long> clientesPorMes = new HashMap<>();

        // Obtener las fechas de los últimos 6 meses
        LocalDate today = LocalDate.now();
        for (int i = 0; i < 6; i++) {
            LocalDate startDate = today.minusMonths(i).withDayOfMonth(1);
            LocalDate endDate = today.minusMonths(i).withDayOfMonth(startDate.lengthOfMonth());

            // Contar clientes registrados hasta el final de este mes
            Long count = clienteRepository.countClientesByFechaCreacionBefore(endDate.atTime(23, 59, 59));
            clientesPorMes.put(formatMesAnio(startDate), count);
        }

        return clientesPorMes;
    }

    private String formatMesAnio(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("M"));
    }
	
    public List<Map<String, Object>> getClientesConMasGuiasGeneradas() {
        return clienteRepository.findTopClientesByGuiasGeneradas();
    }
    
    public List<Map<String, Object>> getTopClientesPorMercancias() {
        return clienteRepository.findTopClientesByMercancias();
    }
}