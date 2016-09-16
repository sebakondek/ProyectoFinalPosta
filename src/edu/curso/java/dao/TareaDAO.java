package edu.curso.java.dao;

import java.util.List;

import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Tarea;

public interface TareaDAO extends GenericDAO<Tarea, Long> {

	public void agregarTareaProyecto(Tarea tarea, Long idProyecto);
	public List<Comentario> borrarTareaPorId(Long id);
	public List<Tarea> recuperarTareasProyecto(Long idProy);
	
}
