package br.com.caelum.notasfiscais.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Item;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.modelo.Produto;

import org.junit.Assert.*;

public class TestNotaFiscalDao {
	
	private DAO<NotaFiscal> dao;
	
	@Before
	public void createDao() {
		dao = new DAO<>(NotaFiscal.class);
		System.out.println("dao criado");
	}
	
//	@Test
//	public void removeSeAlgumItemTiverTest() {
//		
//		List<NotaFiscal> listaNotasFiscais = dao.listaTodos();
//		List<NotaFiscal> listaNotasARemover = new ArrayList<>();
//		
//		for (NotaFiscal notaFiscal : listaNotasFiscais) {
//			List<Item> itens = notaFiscal.getItens();
//			
//			for (Item item : itens) {
//				if(item.getProduto().getNome().contains("Test")) {
//					listaNotasARemover.add(notaFiscal);
//					break;
//				}
//			}
//		}
//		for (NotaFiscal notaFiscal : listaNotasARemover) {
//			dao.remove(notaFiscal);
//		}
//		
//	}

	@Test
	public void testAdiciona() {
		NotaFiscal notaFiscal = new NotaFiscal();
		notaFiscal.setCnpj("12456987000131");
		notaFiscal.setData(Calendar.getInstance());
		notaFiscal.setItens(getItens(notaFiscal));
		
		dao.adiciona(notaFiscal);
		
		NotaFiscal notaFiscalLocalizada = dao.buscaPorId(notaFiscal.getId());

		assertNotNull(notaFiscalLocalizada);
	}

	private List<Item> getItens(NotaFiscal notaFiscal) {
		
		DAO<Produto> dao = new DAO<>(Produto.class);
		List<Produto> listaProdutos = dao.listaTodos();
		
		List<Item> itens = new ArrayList<>();
		for (Produto produto : listaProdutos) {
			Item item = new Item();
			item.setNotaFiscal(notaFiscal);
			item.setProduto(produto);
			item.setQuantidade(1);
			item.setValorUnitario(produto.getPreco());
			
			itens.add(item);
		}
		return itens;
	}

}
