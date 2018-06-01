package com.truvainfo.api.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@GetMapping
	public List<Funcionario> buscarTodos(FuncionarioFilter funcionarioFilter, Pageable pageable) {

		List<Funcionario> funcionarios = funcionarioRepository.filtrar(funcionarioFilter, pageable);

		return funcionarios;

	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> buscarPeloId(@PathVariable Long id) {
		Funcionario funcionario = funcionarioService.buscarPeloId(id);

		return ResponseEntity.ok(funcionario);

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		funcionarioRepository.delete(id);

	}

	@PostMapping
	public ResponseEntity<Funcionario> salvar(@Valid @RequestBody Funcionario funcionario) {

		Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(funcionarioSalvo.getId()).toUri();

		return ResponseEntity.created(uri).body(funcionarioSalvo);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @Valid @RequestBody Funcionario funcionario) {

		Funcionario funcionarioSalvo = funcionarioService.atualizar(id, funcionario);

		return ResponseEntity.ok(funcionarioSalvo);

	}

}
