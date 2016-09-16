package edu.curso.java.dao;

import java.util.List;

import edu.curso.java.bo.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario, Long> {


	void borrarUsuarioPorId(Long id);

	List<Usuario> buscarUsuarios(String campoBuscar);
}