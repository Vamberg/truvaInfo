package com.truvainfo.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.truvainfo.api.model.Funcionario;
import com.truvainfo.api.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public Funcionario atualizar(Long id, Funcionario funcionario) {
		
		Funcionario funcionarioSalvo = buscarPeloId(id);
		BeanUtils.copyProperties(funcionario, funcionarioSalvo, "id","email");
	
		return funcionarioRepository.save(funcionarioSalvo);
	}

	public Funcionario buscarPeloId(Long id) {

		Funcionario funcionario = funcionarioRepository.findOne(id);
		if (funcionario == null) {
			throw new EmptyResultDataAccessException(1);
		}

		return funcionario;

	}

	public Funcionario save(Funcionario funcionario) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        funcionario.setSenha(encoder.encode(funcionario.getSenha()));
		Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
		
		return funcionarioSalvo;
	}
}
