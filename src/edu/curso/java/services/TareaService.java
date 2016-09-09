package edu.curso.java.services;

import java.util.List;

import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Usuario;

public interface TareaService {

	public Long guardarTarea(Tarea tarea);
	public List<Tarea> listarTareas();
	
	public Tarea recuperarTareaPorId(Long id);


	
	public void agregarTareaProyecto(Tarea tarea, Long idProyecto);
	public void borrarTareaPorId(Long id);
	
	public void editarTarea(Tarea tarea);
	public List<Tarea> buscarTareaPorNombre(String campoBuscar);
	
	public Long guardarComentario(Comentario comentario, Long idTarea);
	
}
