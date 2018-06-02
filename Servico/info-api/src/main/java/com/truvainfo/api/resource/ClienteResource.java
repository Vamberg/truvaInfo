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

import com.truvainfo.api.model.Cliente;
import com.truvainfo.api.repository.ClienteRepository;
import com.truvainfo.api.repository.filter.ClienteFilter;
import com.truvainfo.api.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteService clienteService;

	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CLIENTE') and #oauth2.hasScope('write')")
	@PostMapping
	public ResponseEntity<Cliente> salvar(@Valid @RequestBody Cliente cliente) {

		Cliente clienteSalvo = clienteRepository.save(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(clienteSalvo.getId())
				.toUri();

		return ResponseEntity.created(uri).body(clienteSalvo);

	}

	@PreAuthorize("hasAuthority('ROLE_BUSCAR_CLIENTE') and #oauth2.hasScope('write')")
	@GetMapping
	public List<Cliente> buscarTodos(ClienteFilter clienteFilter, Pageable pageable) {

		List<Cliente> clientes = clienteRepository.filtrar(clienteFilter, pageable);

		return clientes;
	}

	@PreAuthorize("hasAuthority('ROLE_BUSCAR_CLIENTE') and #oauth2.hasScope('write')")
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPeloId(@PathVariable Long id) {

		Cliente cliente = clienteService.buscarPeloId(id);

		return ResponseEntity.ok(cliente);

	}
	@PreAuthorize("hasAuthority('ROLE_ATUALIZAR_CLIENTE') and #oauth2.hasScope('write')")
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {

		Cliente clienteSalvo = clienteService.atualizar(id, cliente);

		return ResponseEntity.ok(clienteSalvo);

	}
	
	@PreAuthorize("hasAuthority('ROLE_DELETAR_CLIENTE') and #oauth2.hasScope('write')")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		clienteRepository.delete(id);
	}

}
