package com.truvainfo.api.repository.ordem;

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
import org.springframework.util.StringUtils;

import com.truvainfo.api.model.Cliente;
import com.truvainfo.api.model.Cliente_;
import com.truvainfo.api.model.Funcionario;
import com.truvainfo.api.model.Funcionario_;
import com.truvainfo.api.model.OrdemServico;
import com.truvainfo.api.model.OrdemServico_;
import com.truvainfo.api.model.Pessoa_;
import com.truvainfo.api.repository.filter.OrdemFilter;

public class OrdemServicoRepositoryImpl implements OrdemServicoRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<OrdemServico> filtrar(Pageable pageable, OrdemFilter ordemFilter) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<OrdemServico> criteria = builder.createQuery(OrdemServico.class);
		Root<OrdemServico> root = criteria.from(OrdemServico.class);
		Join<OrdemServico, Cliente> cli = (Join<OrdemServico, Cliente>) root.fetch(OrdemServico_.cliente);
		Join<OrdemServico, Funcionario> func  = (Join<OrdemServico, Funcionario>) root.fetch(OrdemServico_.funcionario);
		Predicate [] predicates = adicionarRestricoes(root,builder,ordemFilter,cli,func);
		criteria.where(predicates);
		TypedQuery<OrdemServico> query = manager.createQuery(criteria);
		
		return query.getResultList();
	}

	private Predicate[] adicionarRestricoes(Root<OrdemServico> root, CriteriaBuilder builder, OrdemFilter ordemFilter,
			Join<OrdemServico, Cliente> cli, Join<OrdemServico, Funcionario> func) {
		
		List<Predicate> predicates = new ArrayList<>();
		
	
		if(!StringUtils.isEmpty(ordemFilter.getCliente())) {
			predicates.add(builder.like(builder.lower(cli.get(Cliente_.pessoa).get(Pessoa_.nome)), "%"+ordemFilter.getCliente().toLowerCase()+"%"));
		}
		
		if(!StringUtils.isEmpty(ordemFilter.getFuncionario())) {
			predicates.add(builder.like(builder.lower(func.get(Funcionario_.pessoa).get(Pessoa_.nome)), "%"+ordemFilter.getFuncionario().toLowerCase()+"%"));
		}
		
		if(!StringUtils.isEmpty(ordemFilter.getResponsavel())) {
			predicates.add(builder.like(builder.lower(func.get(Funcionario_.pessoa).get(Pessoa_.nome)), "%"+ordemFilter.getResponsavel().toLowerCase()+"%"));
		}
		
		if(!StringUtils.isEmpty(ordemFilter.getProblema())) {
			predicates.add(builder.like(builder.lower(root.get(OrdemServico_.supostoProblema)), "%"+ordemFilter.getProblema().toLowerCase()+"%"));
		}
		
		if(ordemFilter.getDataAberturaDe()!=null) {
			
			predicates.add(builder.greaterThanOrEqualTo(root.get(OrdemServico_.dataAbertura), ordemFilter.getDataAberturaDe()));
		}
		
		if(ordemFilter.getDataAberturaAte()!=null) {
			
			predicates.add(builder.lessThanOrEqualTo(root.get(OrdemServico_.dataAbertura), ordemFilter.getDataAberturaAte()));
		}
		
		if(ordemFilter.getDataBaixaDe()!=null) {
			
			predicates.add(builder.greaterThanOrEqualTo(root.get(OrdemServico_.dataBaixa), ordemFilter.getDataBaixaDe()));
		}
		
		if(ordemFilter.getDataBaixaAte()!=null) {
			
			predicates.add(builder.lessThanOrEqualTo(root.get(OrdemServico_.dataBaixa), ordemFilter.getDataBaixaAte()));
		}
		
		
		return predicates.toArray(new Predicate [predicates.size()]);
		
	}
	
	

}
