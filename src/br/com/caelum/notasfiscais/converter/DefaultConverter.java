package br.com.caelum.notasfiscais.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public abstract class DefaultConverter<T extends Object> implements Converter {

	@Override
	public final Object getAsObject(FacesContext context, UIComponent component, String value) {
		return parser(value);
	}

	@Override
	public final String getAsString(FacesContext context, UIComponent component, Object value) {
		return format((T)value);
	}
	
	public abstract T parser(String value);
	
	public abstract String format(T value);

}
