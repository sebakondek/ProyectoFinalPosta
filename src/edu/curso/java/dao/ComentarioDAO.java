package edu.curso.java.dao;

import java.util.List;

import edu.curso.java.bo.Comentario;

public interface ComentarioDAO {
	
	public Long guardarComentario(Comentario comentario);
	public List<Comentario> listarComentarios();
	public Comentario recuperarComentarioPorId(Long id);
	void borrarComentarioPorId(Long id);
	void editarComentario(Comentario comentario);
	public List<Comentario> buscarComentario(String campoBuscar, Long idTarea);
}
