package br.com.caelum.notasfiscais.util;

import javax.persistence.EntityManager;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;

import br.com.caelum.notasfiscais.dao.JPAUtil;

public class IndexaProdutos {

	public static void main(String[] args) throws InterruptedException {
		EntityManager em = new JPAUtil().getEntityManager();
		
		FullTextEntityManager fullTextEM = Search.getFullTextEntityManager(em);
		
		fullTextEM.createIndexer().startAndWait();
	}

}
