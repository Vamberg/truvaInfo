package com.truvainfo.api.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.truvainfo.api.model.Orcamento;
import com.truvainfo.api.model.OrdemServico;
import com.truvainfo.api.repository.OrdemServicoRepository;
import com.truvainfo.api.repository.filter.OrdemFilter;
import com.truvainfo.api.service.OrdemServicoService;

@RestController
@RequestMapping("/ordem")
public class OrdemServicoResource {
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private OrdemServicoService OrdemServicoService;
	
	@PostMapping
	private ResponseEntity<OrdemServico> salvar(@Valid @RequestBody OrdemServico ordemServico){
		OrdemServico ordemServicoSalva = ordemServicoRepository.save(ordemServico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(ordemServicoSalva.getId()).toUri();
		
		return ResponseEntity.created(uri).body(ordemServico);
		
	}
	
	@GetMapping
	private List<OrdemServico> buscarTodas(Pageable pageable, OrdemFilter ordemFilter){
		List<OrdemServico> ordens = ordemServicoRepository.filtrar(pageable,ordemFilter);
		
		return ordens;
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<OrdemServico > atualizar (@PathVariable Long id,@Valid @RequestBody Orcamento orcamento ) {
		
		OrdemServico ordemServico = OrdemServicoService.atualizar(id,orcamento);
		
		return ResponseEntity.ok(ordemServico);
		
	}

	
	
}
