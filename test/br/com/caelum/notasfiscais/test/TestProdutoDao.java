package br.com.caelum.notasfiscais.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.notasfiscais.dao.ProdutoDAO;
import br.com.caelum.notasfiscais.modelo.Produto;

public class TestProdutoDao {
	
	private ProdutoDAO dao;
	
	@Before
	public void createDao() {
		dao = new ProdutoDAO();
		System.out.println("dao criado");
	}

	@Test
	public void testAdiciona() {
		
		Produto produto = new Produto();

		produto.setNome("Teste " + System.currentTimeMillis() % (1000 * 60 * 60));
		produto.setDescricao("Este � um teste incluindo " + produto.getNome());
		produto.setPreco(500.0 + (System.currentTimeMillis() % (1000* 60)));
		
		dao.adiciona(produto);
		
		Produto produtoLocalizado = dao.buscaPorId(produto.getId());
		
		assertTrue(produto.getNome().equals(produtoLocalizado.getNome()));
	}

	@Test
	public void testBuscaPorNomeCom4Caracteres() {
		List<Produto> listaTodos = dao.buscaPorNome("Test");
		
		System.out.println("Lista");
		for (Produto usuario : listaTodos) {
			System.out.println(usuario.getNome());
		}
		System.out.println("-----");
		
		assertTrue(listaTodos.size() > 0);
	}
	
	@Test
	public void testBuscaTextualPorNomeCom4Caracteres() {
		List<Produto> listaTodos = dao.buscaTextualPorNome("test");
		
		System.out.println("Lista Textual");
		for (Produto usuario : listaTodos) {
			System.out.println(usuario.getNome());
		}
		System.out.println("-------------");
		
		assertTrue(listaTodos.size() > 0);
	}
	
	@Test
	public void listaTodos() {
		List<Produto> listaTodos = dao.listaTodos();
		
		System.out.println("Lista Todos");
		for (Produto usuario : listaTodos) {
			System.out.println(usuario.getNome());
		}
		System.out.println("-----");
		
		assertTrue(listaTodos.size() > 0);
		
	}

}
