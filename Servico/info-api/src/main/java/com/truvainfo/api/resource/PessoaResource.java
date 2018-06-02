package com.truvainfo.api.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.truvainfo.api.model.Pessoa;
import com.truvainfo.api.repository.PessoaRepository;
import com.truvainfo.api.repository.filter.PessoaFilter;
import com.truvainfo.api.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private PessoaService pessoaService;

	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PESSOA') and #oauth2.hasScope('write')")
	@PostMapping
	public ResponseEntity<Pessoa> salvar(@Valid @RequestBody Pessoa pessoa) {

		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(pessoaSalva.getId())
				.toUri();

		return ResponseEntity.created(uri).body(pessoaSalva);

	}

	@PreAuthorize("hasAuthority('ROLE_BUSCAR_PESSOA') and #oauth2.hasScope('write')")
	@GetMapping
	public List<Pessoa> buscarTodos(PessoaFilter pessoaFilter, Pageable pageable) {

		List<Pessoa> pessoas = pessoaRepository.filtrar(pessoaFilter, pageable);

		return pessoas;
	}

	@PreAuthorize("hasAuthority('ROLE_BUSCAR_PESSOA') and #oauth2.hasScope('write')")
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> buscarPeloId(@PathVariable Long id) {
		Pessoa pessoa = pessoaService.buscarPeloId(id);

		return ResponseEntity.ok(pessoa);

	}

	@PreAuthorize("hasAuthority('ROLE_ATUALIZAR_PESSOA') and #oauth2.hasScope('write')")
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @Valid @RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = pessoaService.atualizar(id, pessoa);

		return ResponseEntity.ok(pessoaSalva);
	}

	@PreAuthorize("hasAuthority('ROLE_DELETAR_PESSOA') and #oauth2.hasScope('write')")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		pessoaRepository.delete(id);
	}

}
