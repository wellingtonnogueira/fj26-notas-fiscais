package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.Usuario;

@ManagedBean @SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 3258128530136373961L;
	private static String LOGIN_PAGE = "login";
	
	private Usuario usuario = new Usuario();
	private String toPage = LOGIN_PAGE;
	private boolean autenticado = false;
	
	public String efetuaLogin() {
		UsuarioDAO dao = new UsuarioDAO();
		
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
