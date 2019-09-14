package br.com.livrariaspring.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.livrariaspring.models.Produto;

@Repository
@Transactional
public class ProdutoDao {

	@PersistenceContext
	private EntityManager manager;

	public void gravar(Produto produto) {

		manager.persist(produto);

	}

}
