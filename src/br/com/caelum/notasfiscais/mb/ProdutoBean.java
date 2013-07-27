package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean @ViewScoped
public class ProdutoBean implements Serializable {
	
	private static final long serialVersionUID = 1966624938216688849L;

	private Produto produto = new Produto();
	private List<Produto> produtos;

	public Produto getProduto() {
		return produto;
	}
	

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void grava() {
		DAO<Produto> dao = new DAO<>(Produto.class);
		
		if(getProduto().getId() == null) {
			dao.adiciona(getProduto());
		} else {
			dao.atualiza(getProduto());
		}
		this.setProduto(new Produto()); //Para zerar dados da página
		this.produtos = null;
	}

	public List<Produto> getProdutos() {
		if(this.produtos == null) {
			this.produtos = new DAO<Produto>(Produto.class).listaTodos();
		}
		return this.produtos;
	}
	
	public void remove(Produto produto) {
		DAO<Produto> dao = new DAO<>(Produto.class);
		dao.remove(produto);
		this.produtos = null;
	}

}
