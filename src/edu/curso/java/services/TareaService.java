package edu.curso.java.services;

import java.util.List;

import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Tarea;

public interface TareaService {

	public void guardarTarea(Tarea tarea, Long idProyecto);
	public List<Tarea> listarTareas();
	
	public Tarea recuperarTareaPorId(Long id);


	
	public void agregarTareaProyecto(Tarea tarea, Long idProyecto);
	public void borrarTareaPorId(Long id);
	
	public void editarTarea(Tarea tarea);
	public List<Tarea> buscarTareaPorNombre(String campoBuscar);
	
	public Long guardarComentario(Comentario comentario, Long idTarea);
	public List<Comentario> buscarComentarioPorContenido(String campoBuscar);
	
}
