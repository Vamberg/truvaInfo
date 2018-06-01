package com.truvainfo.api.resource;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truvainfo.api.model.Empresa;
import com.truvainfo.api.repository.EmpresaRepository;

@RestController
@RequestMapping("/empresa")
public class EmpresaResource {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@GetMapping
	private ResponseEntity<Empresa> buscarEmpresa(){
		
		Empresa empresa = empresaRepository.findOne(1L);
		
		return ResponseEntity.ok(empresa);
		
	}
	
	@PutMapping
	private ResponseEntity<Empresa> atualizar(@Valid @RequestBody Empresa empresa){
		
		Empresa empresaSalva = empresaRepository.findOne(1L);
		BeanUtils.copyProperties(empresa, empresaSalva, "id");
		empresaRepository.save(empresaSalva);
		return ResponseEntity.ok(empresaSalva);	
		
	}

}
