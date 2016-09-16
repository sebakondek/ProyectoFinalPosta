package edu.curso.java.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;
import edu.curso.java.services.ProyectoService;

@Repository
public class TareaDAOImp extends GenericDAOImp<Tarea, Long>implements TareaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ProyectoService proyectoService;
	
	

	@Override
	public void agregarTareaProyecto(Tarea tarea, Long idProyecto) {
		Proyecto proyecto = proyectoService.recuperarProyectoPorId(idProyecto);
		proyecto.getTareas().add(tarea);		
	}

	@Override
	public List<Comentario> borrarTareaPorId(Long id) {
		Tarea tarea = super.recuperarClasePorId(id);
		List<Comentario> comentarios = tarea.getComentarios();
		
		tarea.setEstado(false);
		super.editarClase(tarea);
		
		return comentarios;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Tarea> buscarTareaPorNombre(String campoBuscar) {
		String hql = "from Tarea as t where t.estado=1 and (t.titulo like :textoBuscar OR t.descripcion like :textoBuscar)";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("textoBuscar", "%" + campoBuscar + "%");
		return query.list();
	}

}
