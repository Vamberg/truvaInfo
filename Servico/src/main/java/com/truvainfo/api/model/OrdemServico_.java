package com.truvainfo.api.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OrdemServico.class)
public abstract class OrdemServico_ {

	public static volatile SingularAttribute<OrdemServico, Cliente> cliente;
	public static volatile SingularAttribute<OrdemServico, String> supostoProblema;
	public static volatile SingularAttribute<OrdemServico, Equipamento> equipamento;
	public static volatile SingularAttribute<OrdemServico, Long> id;
	public static volatile SingularAttribute<OrdemServico, Funcionario> funcionario;
	public static volatile SingularAttribute<OrdemServico, Funcionario> responsavel;
	public static volatile SingularAttribute<OrdemServico, LocalDate> dataAbertura;
	public static volatile SingularAttribute<OrdemServico, LocalDate> dataBaixa;

}

