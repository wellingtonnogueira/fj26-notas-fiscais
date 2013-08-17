package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.Usuario;

@Named @SessionScoped
public class UsuarioLogado implements Serializable {
	
	private static final long serialVersionUID = 8134717289216851529L;

	private Usuario usuario = new Usuario();

	private UsuarioDAO dao;

	private boolean autenticado;
	
	public boolean isLogado() {
		return autenticado;
	}
	
	public UsuarioLogado() {
	}
	
	@Inject
	public UsuarioLogado(UsuarioDAO dao) {
		this.dao = dao;
	}

	public boolean efetuaLogin() {
		autenticado = dao.existe(getUsuario());
		return autenticado;
	}
	
	public void efetuaLogout() {
		getUsuario().setSenha(null);
		autenticado = false;
		
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
