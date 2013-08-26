package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named @SessionScoped
public class RedirecionadorBean implements Serializable {
	
	private static final long serialVersionUID = 1572078232642897158L;

	private static String LOGIN_PAGE = "login";
	
	private String toPage = LOGIN_PAGE;
	
	
	String getToPage() {
		return toPage;
	}

	public void setToPage(String toPage) {
		this.toPage = toPage;
	}
	
	public void defaultPage() {
		this.toPage = LOGIN_PAGE;
	}

	public String redirect() {
		return this.toPage + "?faces-redirect=true";
	}


}
