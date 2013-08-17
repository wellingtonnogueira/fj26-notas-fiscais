package br.com.caelum.notasfiscais.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("comecaComMaiuscula")
public class ComecaComMaiuscula implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		
		if(!value.toString().matches("[A-Z].*")) {
			throw new ValidatorException(new FacesMessage("Primeira letra tem que ser maiúscula"));
		}

	}

}
