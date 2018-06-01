package com.truvainfo.api.repository.filter;

import java.time.LocalDate;

public class OrdemFilter {
	
	private String responsavel;
	private String funcionario;
	private String cliente;
	private String problema;
	private LocalDate dataAberturaDe;
	private LocalDate dataAberturaAte;
	private LocalDate dataBaixaDe;
	private LocalDate dataBaixaAte;
	
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getProblema() {
		return problema;
	}
	public void setProblema(String problema) {
		this.problema = problema;
	}
	public LocalDate getDataAberturaDe() {
		return dataAberturaDe;
	}
	public void setDataAberturaDe(LocalDate dataAberturaDe) {
		this.dataAberturaDe = dataAberturaDe;
	}
	public LocalDate getDataAberturaAte() {
		return dataAberturaAte;
	}
	public void setDataAberturaAte(LocalDate dataAberturaAte) {
		this.dataAberturaAte = dataAberturaAte;
	}
	public LocalDate getDataBaixaDe() {
		return dataBaixaDe;
	}
	public void setDataBaixaDe(LocalDate dataBaixaDe) {
		this.dataBaixaDe = dataBaixaDe;
	}
	public LocalDate getDataBaixaAte() {
		return dataBaixaAte;
	}
	public void setDataBaixaAte(LocalDate dataBaixaAte) {
		this.dataBaixaAte = dataBaixaAte;
	}

	
	

}
