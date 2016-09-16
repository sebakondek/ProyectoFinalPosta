package edu.curso.java.dao;

import java.util.List;

import edu.curso.java.bo.Comentario;

public interface ComentarioDAO extends GenericDAO<Comentario, Long> {
	
	void borrarComentarioPorId(Long id);
	public List<Comentario> buscarComentario(String campoBuscar, Long idTarea);
}
