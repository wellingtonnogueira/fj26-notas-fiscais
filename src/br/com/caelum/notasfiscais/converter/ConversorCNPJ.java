package br.com.caelum.notasfiscais.converter;

import javax.faces.convert.FacesConverter;

import br.com.caelum.stella.format.CNPJFormatter;

@FacesConverter("cnpj")
public class ConversorCNPJ extends DefaultConverter<String> {
	public ConversorCNPJ() {
		System.out.println("Vamos?");
	}

	@Override
	public String parser(String value) {
		return new CNPJFormatter().unformat(value);
	}

	@Override
	public String format(String value) {
		String cnpjFormatado;
		
		//try catch para resolver provblema de dados legados já cadastrados na base
		//o ideal é criar uma rotina que corrija o problema de valores inválidos e
		//remova o bloco try catch abaixo (eliminando o tratamento do catch).
		try {
			cnpjFormatado = new CNPJFormatter().format(value);
		} catch (Exception e) {
			return value;
		}
		return cnpjFormatado;
	}


}
