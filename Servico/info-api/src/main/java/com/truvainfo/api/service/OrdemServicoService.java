package com.truvainfo.api.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.truvainfo.api.model.Orcamento;
import com.truvainfo.api.model.OrdemServico;
import com.truvainfo.api.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	public OrdemServico atualizar(Long id, Orcamento orcamento) {

		OrdemServico ordemServico = buscarPeloId(id);
		if (orcamento.getDataOrcamento() == null) {
			orcamento.setDataOrcamento(LocalDate.now());
		}
		if (orcamento.getStatus().toString().equals("FECHADA")
				|| orcamento.getStatus().toString().equals("SEM_SERVICO")) {
			ordemServico.setDataBaixa(LocalDate.now());
		}
		ordemServico.setOrcamento(orcamento);
		ordemServico = ordemServicoRepository.save(ordemServico);

		return ordemServico;
	}

	private OrdemServico buscarPeloId(Long id) {
		OrdemServico ordemServico = ordemServicoRepository.findOne(id);

		if (ordemServico == null) {
			throw new EmptyResultDataAccessException(1);
		}

		return ordemServico;
	}

}
