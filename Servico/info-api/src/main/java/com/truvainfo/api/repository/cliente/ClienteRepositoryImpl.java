package com.truvainfo.api.repository.cliente;

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

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import com.truvainfo.api.model.Cliente;
import com.truvainfo.api.model.Cliente_;
import com.truvainfo.api.model.Pessoa;
import com.truvainfo.api.model.Pessoa_;
import com.truvainfo.api.repository.filter.ClienteFilter;

public class ClienteRepositoryImpl implements ClienteRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
		Root<Cliente> root = criteria.from(Cliente.class);
		Join<Cliente, Pessoa> pes = (Join<Cliente, Pessoa>) root.fetch(Cliente_.pessoa);
		Predicate[] predicates = criarRestricoes(pes, builder, clienteFilter);
		criteria.where(predicates);
		adicionarOrdenacao(pageable, builder, criteria, root);
		TypedQuery<Cliente> query = manager.createQuery(criteria);
		adicionarRestricaoPaginacao(query,pageable);

		return query.getResultList();
	}

	private void adicionarRestricaoPaginacao(TypedQuery<Cliente> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPogPagina = pageable.getPageSize();
		int primeiroRegistroPagina = paginaAtual * totalRegistrosPogPagina;
		
		query.setFirstResult(primeiroRegistroPagina);
		query.setMaxResults(totalRegistrosPogPagina);
		
		
	}

	private Predicate[] criarRestricoes(Join<Cliente, Pessoa> pes, CriteriaBuilder builder,
			ClienteFilter clienteFilter) {
		List<Predicate> predicates = new ArrayList<>();
		if (!StringUtils.isEmpty(clienteFilter.getNome())) {
			predicates.add(builder.like(builder.lower(pes.get(Pessoa_.nome)),
					"%" + clienteFilter.getNome().toLowerCase() + "%"));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void adicionarOrdenacao(Pageable pageable, CriteriaBuilder builder, CriteriaQuery<Cliente> criteria,
			Root<Cliente> root) {
		Sort sort = pageable.getSort();
		if (sort != null) {
			Sort.Order order = sort.iterator().next();
			String field = order.getProperty();
			criteria.orderBy(order.isAscending() ? builder.asc(root.get(field)) : builder.desc(root.get(field)));
		}
	}

}
