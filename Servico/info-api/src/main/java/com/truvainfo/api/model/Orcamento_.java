package com.truvainfo.api.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Orcamento.class)
public abstract class Orcamento_ {

	public static volatile SingularAttribute<Orcamento, LocalDate> data;
	public static volatile SingularAttribute<Orcamento, Long> id;
	public static volatile SingularAttribute<Orcamento, OrdemServico> ordemServico;
	public static volatile SingularAttribute<Orcamento, String> descricao;

}

