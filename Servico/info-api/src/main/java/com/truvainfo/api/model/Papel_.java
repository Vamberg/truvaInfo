package com.truvainfo.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Papel.class)
public abstract class Papel_ {

	public static volatile SingularAttribute<Papel, String> funcao;
	public static volatile ListAttribute<Papel, Permissao> permissoes;
	public static volatile SingularAttribute<Papel, Long> id;
	public static volatile ListAttribute<Papel, Funcionario> funcionario;

}

