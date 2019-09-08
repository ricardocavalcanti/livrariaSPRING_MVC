package br.com.livrariaspring.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.livrariaspring.models.Produto;

@Repository
public class ProdutoDao {

	@PersistenceContext
	private EntityManager manager;

	public void gravar(Produto produto) {

		manager.persist(produto);

	}

}
