package com.truvainfo.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.truvainfo.api.model.Cliente;
import com.truvainfo.api.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired 
	private ClienteRepository clienteRepository;

	public Cliente atualizar(Long id, Cliente cliente) {
		Cliente clienteSalvo = buscarPeloId(id);
		BeanUtils.copyProperties(cliente, clienteSalvo, "id");
		
		return clienteRepository.save(clienteSalvo);
	}
	
	
	
	public Cliente buscarPeloId(Long id) {
		
		Cliente cliente = clienteRepository.findOne(id);
		if(cliente==null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return cliente;
	}

}
