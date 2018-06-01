package com.truvainfo.api.repository.pessoa;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.truvainfo.api.model.Pessoa;
import com.truvainfo.api.repository.filter.PessoaFilter;

public interface PessoaReposirotyQuery {

	public List<Pessoa> filtrar (PessoaFilter pessoaFilter, Pageable pageable);
	
}
