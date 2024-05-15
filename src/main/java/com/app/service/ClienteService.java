package com.app.service;

import java.util.List;

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
	
}