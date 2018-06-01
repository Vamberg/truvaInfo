package com.truvainfo.api.repository.pessoa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import com.truvainfo.api.model.Pessoa;
import com.truvainfo.api.model.Pessoa_;
import com.truvainfo.api.repository.filter.PessoaFilter;

public class PessoaRepositoryImpl implements PessoaReposirotyQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Pessoa> filtrar(PessoaFilter pessoaFilter,Pageable pageable) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Pessoa> criteria = builder.createQuery(Pessoa.class);
		Root<Pessoa> root = criteria.from(Pessoa.class);
		Predicate[] predicates = criarRestricao(root, builder, pessoaFilter);
		criteria.where(predicates);
		adicionarOrdenacao(pageable, builder, criteria, root);
		TypedQuery<Pessoa> query = manager.createQuery(criteria);
		adicionarRestricaoPaginacao(pageable,query);

		return new PageImpl<>(query.getResultList()).getContent();
	}

	private void adicionarRestricaoPaginacao(Pageable pageable, TypedQuery<Pessoa> query) {
		
		
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPogPagina = pageable.getPageSize();
		int primeiroRegistroPagina = paginaAtual * totalRegistrosPogPagina;
		
		query.setFirstResult(primeiroRegistroPagina);
		query.setMaxResults(totalRegistrosPogPagina);
		
	}

	private Predicate[] criarRestricao(Root<Pessoa> root, CriteriaBuilder builder, PessoaFilter pessoaFilter) {

		List<Predicate> predicates = new ArrayList<>();
		if (!StringUtils.isEmpty(pessoaFilter.getNome())) {
			predicates.add(builder.like(builder.lower(root.get(Pessoa_.nome)),
					"%" + pessoaFilter.getNome().toLowerCase() + "%"));

		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	
	private void adicionarOrdenacao(Pageable pageable, CriteriaBuilder builder, CriteriaQuery<Pessoa> criteria,
			Root<Pessoa> root) {
		Sort sort = pageable.getSort();
		if (sort != null) {
			Sort.Order order = sort.iterator().next();
			String field = order.getProperty();
			criteria.orderBy(order.isAscending() ? builder.asc(root.get(field)) : builder.desc(root.get(field)));
		}
	}

}
