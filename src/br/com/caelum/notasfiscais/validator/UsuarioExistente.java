package br.com.caelum.notasfiscais.validator;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import org.jboss.seam.faces.validation.InputField;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.Usuario;

@FacesValidator("usuarioexistente")
public class UsuarioExistente implements Validator, Serializable {

	private static final long serialVersionUID = 4541500923082439353L;

	@Inject @InputField
	private String login;
	
	@Inject @InputField
	private String senha;
	
	@Inject
	private UsuarioDAO dao;
	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {

		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		if(dao.existe(usuario)) {
			throw new ValidatorException(new FacesMessage("Usuario ja existe"));
		}

	}

}
