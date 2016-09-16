package edu.curso.java.services;

import java.util.Date;
import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;

import edu.curso.java.dao.ComentarioDAO;
import edu.curso.java.dao.ProyectoDAO;
import edu.curso.java.dao.TareaDAO;

@Service
@Transactional
public class TareaServiceImp implements TareaService {

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(TareaServiceImp.class);
	
	@Autowired
	TareaDAO tareaDAO;
	
	@Autowired
	ProyectoDAO proyectoDAO;
	
	@Autowired
	ComentarioDAO comentarioDAO;
	

	@Override
	public void guardarTarea(Tarea tarea, Long idProyecto) {
		tareaDAO.guardarClase(tarea);
		//log.info("ID de Proyecto en TAREA SERVICE: "+idProyecto);
		Proyecto proyecto = proyectoDAO.recuperarClasePorId(idProyecto);
		proyecto.getTareas().add(tarea);
		proyectoDAO.editarClase(proyecto);
	}

	@Override
	public List<Tarea> listarTareas() {
		return tareaDAO.listarClase(new Tarea());
	}

	@Override
	public Tarea recuperarTareaPorId(Long id) {
		return tareaDAO.recuperarClasePorId(id);
	}

	@Override
	public void agregarTareaProyecto(Tarea tarea, Long idProyecto) {
		tareaDAO.agregarTareaProyecto(tarea, idProyecto);
	}

	@Override
	public void borrarTareaPorId(Long id) {
		List<Comentario> comentarios = tareaDAO.borrarTareaPorId(id);
		for(Comentario comentario : comentarios){
			comentarioDAO.borrarComentarioPorId(comentario.getId());
		}
	}

	@Override
	public void editarTarea(Tarea tarea) {
		tareaDAO.editarClase(tarea);
	}

//	@Override
//	public List<Tarea> buscarTarea(String campoBuscar) {
//		return tareaDAO.buscarTarea(campoBuscar);
//	}

	@Override
	public Long guardarComentario(Comentario comentario, Long idTarea) {

		comentario.setFecha(new Date());
		Tarea tarea = tareaDAO.recuperarClasePorId(idTarea);
		comentarioDAO.guardarClase(comentario);
		tarea.getComentarios().add(comentario);
		tareaDAO.editarClase(tarea);
		return comentario.getId();
	}
	
	@Override
	public List<Comentario> buscarComentario(String campoBuscar, Long idTarea) {
		return comentarioDAO.buscarComentario(campoBuscar, idTarea);
	}

}
