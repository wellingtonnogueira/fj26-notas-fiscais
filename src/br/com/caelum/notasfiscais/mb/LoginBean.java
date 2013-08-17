package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.Usuario;

//@ManagedBean @SessionScoped
@Named @SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 3258128530136373961L;
	private static String LOGIN_PAGE = "login";
	
	private Usuario usuario = new Usuario();
	private String toPage = LOGIN_PAGE;
	private boolean autenticado = false;
	
	@Inject
	private UsuarioDAO dao;

	public String efetuaLogin() {
		
		autenticado = dao.existe(usuario);

		if(!autenticado) {
			setToPage(LOGIN_PAGE);
		} else if(getToPage().contains("login")) {
			setToPage("produto");
		}
		return getToPage() + "?faces-redirect=true";
	}
	
	public String efetuaLogout() {
		autenticado = false;
		usuario.setSenha(null);
		setToPage(LOGIN_PAGE);
		return "login?faces-redirect=true";
	}
	
	public boolean isLogado() {
		return autenticado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	private String getToPage() {
		return toPage;
	}

	public void setToPage(String toPage) {
		this.toPage = toPage;
	}
	
	
}
