package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Item;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean @ViewScoped
public class NotaFiscalBean implements Serializable {
	
	private static final long serialVersionUID = 740252078626496799L;

	private Long idProduto;
	private Item item = new Item();
	private NotaFiscal notaFiscal = new NotaFiscal();

	
	public void guardaItem() {
		DAO<Produto> daoProduto = new DAO<>(Produto.class);
		Produto produto = daoProduto.buscaPorId(idProduto);
		getItem().setProduto(produto);
		getItem().setValorUnitario(produto.getPreco());
		
		notaFiscal.adicionaItem(getItem());
		
		//Limpar campos
		setItem(new Item());
		idProduto = null;
	}
	
	public void gravar() {
		DAO<NotaFiscal> dao = new DAO<>(NotaFiscal.class);
		dao.adiciona(notaFiscal);
		
		//Limpar campos
		notaFiscal = new NotaFiscal();
		idProduto = null;
	}
	
	//Getters & Setters
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	
	
}
