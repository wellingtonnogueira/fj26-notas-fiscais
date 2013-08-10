package br.com.caelum.notasfiscais.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.caelum.stella.format.CNPJFormatter;

@Deprecated //substituido por br.com.caelum.notasfiscais.converter.ConversorCNPJ
//@FacesConverter("cnpj")
public class CNPJConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return new CNPJFormatter().unformat(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return new CNPJFormatter().format(value.toString());
	}

}
