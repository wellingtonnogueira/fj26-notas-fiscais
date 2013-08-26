package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.modelo.Usuario;

@Named @RequestScoped
public class LoginBean implements Serializable {

	private UsuarioLogado usuarioLogado;
	private RedirecionadorBean redirecionadorBean;

	private static final long serialVersionUID = 3258128530136373961L;
	

	public LoginBean() {
	}

	@Inject
	public LoginBean(UsuarioLogado usuarioLogado, RedirecionadorBean redirecionadorBean) {
		this.usuarioLogado = usuarioLogado;
		this.redirecionadorBean = redirecionadorBean;
	}

	public String efetuaLogin() {
		
		if(!usuarioLogado.efetuaLogin()) {
			redirecionadorBean.defaultPage();
		} else if(getToPage().contains("login")) {
			setToPage("produto");
		}
		return redirecionadorBean.redirect();
	}
	
	public String efetuaLogout() {
		
		usuarioLogado.efetuaLogout();
		
		redirecionadorBean.defaultPage();
		return redirecionadorBean.redirect();
	}
	
	public boolean isLogado() {
		return usuarioLogado.isLogado();
	}
	
	private String getToPage() {
		return redirecionadorBean.getToPage();
	}

	public void setToPage(String toPage) {
		redirecionadorBean.setToPage(toPage);
	}
	
	public Usuario getUsuario() {
		return usuarioLogado.getUsuario();
	}

	public void setUsuario(Usuario usuario) {
		this.usuarioLogado.setUsuario(usuario);
	}

}
