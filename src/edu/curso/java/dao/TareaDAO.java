package edu.curso.java.dao;

import java.util.List;

import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Usuario;

public interface TareaDAO {

	public Long guardarTarea(Tarea tarea);
	public List<Tarea> listarTareas();
	public Tarea recuperarTareaPorId(Long id);
	public void agregarTareaProyecto(Tarea tarea, Long idProyecto);
	List<Comentario> borrarTareaPorId(Long id);
	void editarTarea(Tarea tarea);
	public List<Tarea> buscarTareaPorNombre(String campoBuscar);
	
}
