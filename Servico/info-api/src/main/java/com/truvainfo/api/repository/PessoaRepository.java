package com.truvainfo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truvainfo.api.model.Pessoa;
import com.truvainfo.api.repository.pessoa.PessoaReposirotyQuery;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>,PessoaReposirotyQuery {

}
