package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.datamodel.NotasFiscaisDataModel;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

@Named @ViewScoped
public class ListaNotasFiscaisBean implements Serializable {
	
	private static final long serialVersionUID = 5209918235912765710L;

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
