package br.com.caelum.notasfiscais.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.lucene.analysis.br.BrazilianAnalyzer;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.util.Version;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;

import br.com.caelum.notasfiscais.modelo.Produto;

public class ProdutoDAO extends DAO<Produto> {

	public ProdutoDAO() {
		super(Produto.class);
	}
	
	public List<Produto> buscaPorNome(String nome) {
		String jpql = "select p from Produto p where" +
				" p.nome like :nome order by p.nome";
//				" lower(p.nome) like :nome order by p.nome"; //função lower não funciona no HSQLDB 

		EntityManager em = new JPAUtil().getEntityManager();
		return em.createQuery(jpql, classe)
				.setParameter("nome", nome + "%")
				.getResultList();
	}
	
	public List<Produto> buscaTextualPorNome(String nome) {
		
		System.out.println("Iniciando busca textual: " + nome);
		
		FullTextEntityManager em = Search.getFullTextEntityManager(new JPAUtil().getEntityManager());
		
		QueryParser parser = new QueryParser(
				Version.LUCENE_29, "produtos.nome", 
				new BrazilianAnalyzer(Version.LUCENE_29));
		
		try {
			Query query = parser.parse(nome);
			FullTextQuery textQuery = em.createFullTextQuery(query, classe);
			
			return textQuery.getResultList();
			
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
		
	}

}
