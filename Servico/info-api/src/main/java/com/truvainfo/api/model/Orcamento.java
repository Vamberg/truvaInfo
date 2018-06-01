package com.truvainfo.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Orcamento {

	private LocalDate dataOrcamento;
	private String orcamento;
	private Status status;
	
	@Column(name="data_orcamento")
	public LocalDate getDataOrcamento() {
		return dataOrcamento;
	}
	public void setDataOrcamento(LocalDate dataOrcamento) {
		this.dataOrcamento = dataOrcamento;
	}
	public String getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(String orcamento) {
		this.orcamento = orcamento;
	}
	
	@Enumerated(EnumType.STRING)
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Orcamento(Status status) {
		super();
		this.status = status;
	}
	
	public Orcamento() {
		super();
	}
	


	
	
}
