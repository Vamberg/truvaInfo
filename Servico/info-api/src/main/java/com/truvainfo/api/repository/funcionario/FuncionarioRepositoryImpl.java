package com.truvainfo.api.repository.funcionario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import com.truvainfo.api.model.Funcionario;
import com.truvainfo.api.model.Funcionario_;
import com.truvainfo.api.model.Papel;
import com.truvainfo.api.model.Papel_;
import com.truvainfo.api.model.Pessoa;
import com.truvainfo.api.model.Pessoa_;
import com.truvainfo.api.repository.filter.FuncionarioFilter;

public class FuncionarioRepositoryImpl implements FuncionarioRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Funcionario> filtrar(FuncionarioFilter funcionarioFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Funcionario> criteria = builder.createQuery(Funcionario.class);
		Root<Funcionario> root = criteria.from(Funcionario.class);
		Join<Funcionario, Pessoa> func = (Join<Funcionario, Pessoa>) root.fetch(Funcionario_.pessoa);
		Join<Funcionario, Papel> pap = (Join<Funcionario, Papel>) root.fetch(Funcionario_.papel);
		Predicate [] predicates = criarRestricoes(root,builder,func,funcionarioFilter,pap);
		criteria.where(predicates);
		adicionarOrdenacao(pageable, builder, criteria, root);
		TypedQuery<Funcionario> query = manager.createQuery(criteria);
		adiicionarRestricaoPaginacao(query,pageable);

		return new PageImpl<>(query.getResultList()).getContent();
	}

	private void adiicionarRestricaoPaginacao(TypedQuery<Funcionario> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPogPagina = pageable.getPageSize();
		int primeiroRegistroPagina = paginaAtual * totalRegistrosPogPagina;
		
		query.setFirstResult(primeiroRegistroPagina);
		query.setMaxResults(totalRegistrosPogPagina);
		
		
	}

	private Predicate[] criarRestricoes(Root<Funcionario> root, CriteriaBuilder builder,
			Join<Funcionario, Pessoa> func, FuncionarioFilter funcionarioFilter, Join<Funcionario, Papel> pap) {
		
		List<Predicate> predicates = new ArrayList<>();
		
		if(!StringUtils.isEmpty(funcionarioFilter.getNome())) {
			predicates.add(builder.like(builder.lower(func.get(Pessoa_.nome)), "%"+funcionarioFilter.getNome().toLowerCase()+"%"));
			
		}
		if(!StringUtils.isEmpty(funcionarioFilter.getCargo())) {
			predicates.add(builder.like(builder.lower(pap.get(Papel_.funcao)), "%"+funcionarioFilter.getCargo().toLowerCase()+"%"));
			
		}
		
		if(funcionarioFilter.getDataInicial()!=null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get(Funcionario_.dataAdmissao), funcionarioFilter.getDataInicial()));
		}
		
		if(funcionarioFilter.getDataFinal()!=null) {
			predicates.add(builder.lessThanOrEqualTo(root.get(Funcionario_.dataAdmissao), funcionarioFilter.getDataFinal()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void adicionarOrdenacao(Pageable pageable, CriteriaBuilder builder, CriteriaQuery<Funcionario> criteria,
			Root<Funcionario> root) {
		Sort sort = pageable.getSort();
		if (sort != null) {
			Sort.Order order = sort.iterator().next();
			String field = order.getProperty();
			criteria.orderBy(order.isAscending() ? builder.asc(root.get(field)) : builder.desc(root.get(field)));
		}
	}

}
