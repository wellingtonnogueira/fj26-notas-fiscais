package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.datamodel.NotasFiscaisDataModel;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

@ManagedBean @ViewScoped
public class ListaNotasFiscaisBean {
	
	private LazyDataModel<NotaFiscal> dataModel;
	
	public ListaNotasFiscaisBean() {
		
		DAO<NotaFiscal> dao = new DAO<>(NotaFiscal.class);
		
		dataModel = new NotasFiscaisDataModel();
		dataModel.setRowCount(dao.contaTodos());
		
	}
	
	//Getters & Setters
	
	public LazyDataModel<NotaFiscal> getDataModel() {
		return dataModel;
	}
	
	@Deprecated
	public List<NotaFiscal> getNotas() { //Substituida pelo getDataModel que pagina
		DAO<NotaFiscal> dao = new DAO<>(NotaFiscal.class);
		return dao.listaTodos();
	}
	
	
	
}
