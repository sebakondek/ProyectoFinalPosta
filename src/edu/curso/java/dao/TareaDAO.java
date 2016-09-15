package edu.curso.java.dao;

import java.util.List;

import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Tarea;

public interface TareaDAO {

	public Long guardarTarea(Tarea tarea);
	public List<Tarea> listarTareas();
	public Tarea recuperarTareaPorId(Long id);
	public void agregarTareaProyecto(Tarea tarea, Long idProyecto);
	public List<Comentario> borrarTareaPorId(Long id);
	public void editarTarea(Tarea tarea);
	public List<Tarea> recuperarTareasProyecto(Long idProy);
	
}
