package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Usuario;

@Named @ViewScoped
public class UsuarioBean implements Serializable {
	
	private static final long serialVersionUID = 1966624938216688849L;

	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;


	public void grava() {
		DAO<Usuario> dao = new DAO<>(Usuario.class);
		
		if(getUsuario().getId() == null) {
			dao.adiciona(getUsuario());
		} else {
			dao.atualiza(getUsuario());
		}
		this.setUsuario(new Usuario()); //Para zerar dados da página
		this.usuarios = null;
	}

	public List<Usuario> getUsuarios() {
		if(this.usuarios == null) {
			this.usuarios = new DAO<Usuario>(Usuario.class).listaTodos();
		}
		return this.usuarios;
	}
	
	public void remove(Usuario usuario) {
		DAO<Usuario> dao = new DAO<>(Usuario.class);
		dao.remove(usuario);
		this.usuarios = null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
