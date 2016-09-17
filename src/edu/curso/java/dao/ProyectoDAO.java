package edu.curso.java.dao;

import java.util.List;

import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Usuario;

public interface ProyectoDAO extends GenericDAO<Proyecto, Long> {

	List<Tarea> borrarProyectoPorId(Long id);
	void agregarUsuarioProyecto(Usuario usuario, Long id);
	public List<Proyecto> buscarProyecto(String campoBuscar);
	public Proyecto recuperarClasePorId2(Long id);
	
}
