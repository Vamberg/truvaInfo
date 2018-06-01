package com.truvainfo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truvainfo.api.model.Cliente;
import com.truvainfo.api.repository.cliente.ClienteRepositoryQuery;

public interface ClienteRepository extends JpaRepository<Cliente, Long>,ClienteRepositoryQuery {

}
