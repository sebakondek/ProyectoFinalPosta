package edu.curso.java.services;

import java.util.List;

import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Usuario;

public interface TareaService {

	public void guardarTarea(Tarea tarea, Long idProyecto);
	public List<Tarea> listarTareas();
	
	Tarea recuperarTareaPorId(Long id);


	
	public void agregarTareaProyecto(Tarea tarea, Long idProyecto);
	void borrarTareaPorId(Long id);
	
	void editarTarea(Tarea tarea);
	public List<Tarea> buscarTareaPorNombre(String campoBuscar);
	
	public Long guardarComentario(Comentario comentario, Long idTarea);
	
}
