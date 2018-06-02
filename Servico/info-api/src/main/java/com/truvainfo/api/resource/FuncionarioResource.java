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

import com.truvainfo.api.model.Funcionario;
import com.truvainfo.api.repository.FuncionarioRepository;
import com.truvainfo.api.repository.filter.FuncionarioFilter;
import com.truvainfo.api.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private FuncionarioService funcionarioService;

	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_FUNCIONARIO') and #oauth2.hasScope('write')")
	@PostMapping
	public ResponseEntity<Funcionario> salvar(@Valid @RequestBody Funcionario funcionario) {

		Funcionario funcionarioSalvo = funcionarioService.save(funcionario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(funcionarioSalvo.getId()).toUri();

		return ResponseEntity.created(uri).body(funcionarioSalvo);

	}

	@PreAuthorize("hasAuthority('ROLE_BUSCAR_FUNCIONARIO') and #oauth2.hasScope('write')")
	@GetMapping
	public List<Funcionario> buscarTodos(FuncionarioFilter funcionarioFilter, Pageable pageable) {

		List<Funcionario> funcionarios = funcionarioRepository.filtrar(funcionarioFilter, pageable);

		return funcionarios;

	}

	@PreAuthorize("hasAuthority('ROLE_BUSCAR_FUNCIONARIO') and #oauth2.hasScope('write')")
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> buscarPeloId(@PathVariable Long id) {
		Funcionario funcionario = funcionarioService.buscarPeloId(id);

		return ResponseEntity.ok(funcionario);

	}

	@PreAuthorize("hasAuthority('ROLE_ATUALIZAR_FUNCIONARIO') and #oauth2.hasScope('write')")
	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> atualizar(@PathVariable Long id,@RequestBody Funcionario funcionario) {

		Funcionario funcionarioSalvo = funcionarioService.atualizar(id, funcionario);

		return ResponseEntity.ok(funcionarioSalvo);

	}

	@PreAuthorize("hasAuthority('ROLE_DELETAR_FUNCIONARIO') and #oauth2.hasScope('write')")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		funcionarioRepository.delete(id);

	}

}
