package com.truvainfo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truvainfo.api.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
