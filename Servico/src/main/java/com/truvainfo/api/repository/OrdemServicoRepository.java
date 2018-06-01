package com.truvainfo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truvainfo.api.model.OrdemServico;
import com.truvainfo.api.repository.ordem.OrdemServicoRepositoryQuery;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long>,OrdemServicoRepositoryQuery {

}
