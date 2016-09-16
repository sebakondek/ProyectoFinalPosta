package edu.curso.java.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Usuario;
import edu.curso.java.dao.ProyectoDAO;
import edu.curso.java.dao.UsuarioDAO;

@Service
@Transactional
public class ProyectoServiceImp implements ProyectoService {

	@Autowired
	ProyectoDAO proyectoDAO;
	@Autowired
	UsuarioDAO usuarioDAO;
	@Autowired
	TareaService tareaService;
	
	@Override
	public Long guardarProyecto(Proyecto proyecto){
		
		return proyectoDAO.guardarClase(proyecto);
	}
	
	@Override
	public List<Proyecto> listarProyectos() {
		return proyectoDAO.listarClase(new Proyecto());
	}

	@Override
	public Proyecto recuperarProyectoPorId(Long id) {
		
		return  (Proyecto)proyectoDAO.recuperarClasePorId(id);
	}

	@Override
	public void agregarUsuarioProyecto(Usuario usuario, Long id) {
		proyectoDAO.agregarUsuarioProyecto(usuario, id);
		
	}

	@Override
	public void borrarProyectoPorId(Long id) {
		List<Tarea> tareas = proyectoDAO.borrarProyectoPorId(id);
		for(Tarea tarea : tareas){
			tareaService.borrarTareaPorId(tarea.getId());
		}
		
	}

	@Override
	public void editarProyecto(Proyecto proyecto) {
		proyectoDAO.editarClase(proyecto);
		
	}

	@Override
	public Long guardarProyecto(Proyecto proyecto, Long idUsuarioPrincipal) {
		
		Usuario usuario = usuarioDAO.recuperarClasePorId(idUsuarioPrincipal);
		proyecto.setUsuarioPrincipal(usuario);
		proyectoDAO.guardarClase(proyecto);
		return proyecto.getId();
	}

	@Override
	public Long actualizarProyecto(Proyecto proyecto, Long idUsuarioPrincipal, Long[] idUsuarios) {
		Usuario usuarioPpal = usuarioDAO.recuperarClasePorId(idUsuarioPrincipal);
		proyecto.getUsuarios().clear();
		for (Long id : idUsuarios) {
			Usuario usuario = usuarioDAO.recuperarClasePorId(id);
			proyecto.getUsuarios().add(usuario);
		}
			
		
		proyecto.setUsuarioPrincipal(usuarioPpal);
		proyectoDAO.guardarClase(proyecto);
		return proyecto.getId();
		
	}

	@Override
	public List<Proyecto> buscarProyectosPorNombre(String campoBuscar) {
		return proyectoDAO.buscarProyectoPorNombre(campoBuscar);
	}
	
	@Override
	public void editarTiempoProyecto(Double duracionEstimada, Long idProyecto) {
		Proyecto proyecto = proyectoDAO.recuperarClasePorId(idProyecto);
		proyecto.setTiempoAcumulado(proyecto.getTiempoAcumulado() + duracionEstimada);
		
		proyecto.setTiempoReal(proyecto.getTiempoEstimado() - proyecto.getTiempoAcumulado());
		proyectoDAO.guardarClase(proyecto);
	}
}
