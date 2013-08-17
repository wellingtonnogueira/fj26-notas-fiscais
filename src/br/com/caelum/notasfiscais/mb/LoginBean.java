package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.modelo.Usuario;

@Named @RequestScoped
public class LoginBean implements Serializable {

	private UsuarioLogado usuarioLogado;

	private static final long serialVersionUID = 3258128530136373961L;
	private static String LOGIN_PAGE = "login";
	
	private String toPage = LOGIN_PAGE;
	

	public LoginBean() {
	}

	@Inject
	public LoginBean(UsuarioLogado usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public String efetuaLogin() {
		
		if(!usuarioLogado.efetuaLogin()) {
			setToPage(LOGIN_PAGE);
		} else if(getToPage().contains("login")) {
			setToPage("produto");
		}
		return getToPage() + "?faces-redirect=true";
	}
	
	public String efetuaLogout() {
		
		usuarioLogado.efetuaLogout();
		
		setToPage(LOGIN_PAGE);
		return "login?faces-redirect=true";
	}
	
	public boolean isLogado() {
		return usuarioLogado.isLogado();
	}
	
	private String getToPage() {
		return toPage;
	}

	public void setToPage(String toPage) {
		this.toPage = toPage;
	}
	
	public Usuario getUsuario() {
		return usuarioLogado.getUsuario();
	}

	public void setUsuario(Usuario usuario) {
		this.usuarioLogado.setUsuario(usuario);
	}

}
