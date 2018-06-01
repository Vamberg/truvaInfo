package com.truvainfo.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.truvainfo.api.model.Pessoa;
import com.truvainfo.api.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;


	public Pessoa atualizar(Long id, Pessoa pessoa) {
		Pessoa pessoaSalva = buscarPeloId(id);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "id");
		return pessoaRepository.save(pessoaSalva);
	}

	public Pessoa buscarPeloId(Long id) {
		
		Pessoa pessoaSalva = pessoaRepository.findOne(id);
		if(pessoaSalva==null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return pessoaSalva;
	}
}
