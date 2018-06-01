package com.truvainfo.api.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Funcionario.class)
public abstract class Funcionario_ {

	public static volatile SingularAttribute<Funcionario, Boolean> ativo;
	public static volatile SingularAttribute<Funcionario, Pessoa> pessoa;
	public static volatile SingularAttribute<Funcionario, Usuario> usuario;
	public static volatile SingularAttribute<Funcionario, Long> id;
	public static volatile SingularAttribute<Funcionario, LocalDate> dataAdmissao;

}

