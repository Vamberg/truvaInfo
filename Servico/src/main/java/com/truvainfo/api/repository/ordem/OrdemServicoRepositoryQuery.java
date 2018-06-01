package com.truvainfo.api.repository.ordem;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.truvainfo.api.model.OrdemServico;
import com.truvainfo.api.repository.filter.OrdemFilter;

public interface OrdemServicoRepositoryQuery {
	
	public List<OrdemServico> filtrar(Pageable pageable,OrdemFilter ordemFilter);

}
