package com.truvainfo.api.repository.cliente;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.truvainfo.api.model.Cliente;
import com.truvainfo.api.repository.filter.ClienteFilter;

public interface ClienteRepositoryQuery {
	
	public List<Cliente> filtrar(ClienteFilter clienteFilter,Pageable pageable);

}
