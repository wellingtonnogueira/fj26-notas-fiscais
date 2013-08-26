package br.com.caelum.notasfiscais.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.dao.JPAUtil;
import br.com.caelum.notasfiscais.modelo.Usuario;

public class TestUsuarioDao {
	
	private DAO<Usuario> dao;
	
	@Before
	public void createDao() {
		dao = new DAO<>(Usuario.class);
		System.out.println("dao criado");
	}

	@Test
	public void testAdiciona() {
		Usuario usuario = new Usuario();
		usuario.setLogin("teste");
		usuario.setSenha("teste");
		
		dao.adiciona(usuario);
		
		Usuario usuarioLocalizado = dao.buscaPorId(usuario.getId());
		
//		dao.remove(usuarioLocalizado);
		
		assertTrue(usuario.getLogin().equals(usuarioLocalizado.getLogin()));
	}

	@Test
	public void testListaTodos() {
		List<Usuario> listaTodos = dao.listaTodos();
		
		for (Usuario usuario : listaTodos) {
			System.out.println(usuario.getLogin());
		}
		
		assertTrue(listaTodos.size() > 0);
	}

}
