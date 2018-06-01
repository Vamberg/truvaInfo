package com.truvainfo.api.repository.funcionario;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.truvainfo.api.model.Funcionario;
import com.truvainfo.api.repository.filter.FuncionarioFilter;

public interface FuncionarioRepositoryQuery {
	
	public List<Funcionario> filtrar(FuncionarioFilter funcionarioFilter, Pageable pageable);

}
