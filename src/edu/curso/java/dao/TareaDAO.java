package edu.curso.java.dao;

import java.util.List;

import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;

public interface TareaDAO extends GenericDAO<Tarea, Long> {

	List<Comentario> borrarTareaPorId(Long id);
	public List<Tarea> buscarTareaPorNombre(String campoBuscar);
	public void agregarTareaProyecto(Tarea tarea, Long idProyecto);
	
}
