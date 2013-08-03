package br.com.caelum.notasfiscais.datamodel;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

public class NotasFiscaisDataModel extends LazyDataModel<NotaFiscal> {

	private static final long serialVersionUID = -8360829502782904913L;

	@Override
	public List<NotaFiscal> load(int init, int offset, String orderByFieldName,
			SortOrder order, Map<String, String> filters) {
		
		DAO<NotaFiscal> dao = new DAO<>(NotaFiscal.class);
		List<NotaFiscal> lista = dao.listaTodosPaginada(init, offset);
		
		return lista;
	}
	
}
