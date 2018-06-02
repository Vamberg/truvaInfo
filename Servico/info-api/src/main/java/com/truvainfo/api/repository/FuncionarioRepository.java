package com.truvainfo.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truvainfo.api.model.Funcionario;
import com.truvainfo.api.repository.funcionario.FuncionarioRepositoryQuery;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>,FuncionarioRepositoryQuery{

	public Optional<Funcionario> findByEmail(String email);

}
