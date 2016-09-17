package edu.curso.java.services;

import java.util.List;

import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Usuario;

public interface TareaService {

	public void guardarTarea(Tarea tarea, Long idProyecto, Long[] idUsuarios);
	public List<Tarea> listarTareas();
	
	public Tarea recuperarTareaPorId(Long id);


	
	public void agregarTareaProyecto(Tarea tarea, Long idProyecto);
	public void borrarTareaPorId(Long id);
	
	public void editarTarea(Tarea tarea, Long[] idUsuarios);
	public void agregarUsuarioTarea(Usuario usuario, Long id);
	
	public Long guardarComentario(Comentario comentario, Long idTarea);
	public List<Comentario> buscarComentario(String campoBuscar, Long idTarea);
	
}
