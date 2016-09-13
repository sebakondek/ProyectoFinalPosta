package edu.curso.java.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Usuario;

@Repository
public class ProyectoDAOImp implements ProyectoDAO {
	
	private static final Logger log = Logger.getLogger(ProyectoDAOImp.class);

	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public Long guardarProyecto(Proyecto proyecto) {
		return (Long) sessionFactory.getCurrentSession().save(proyecto);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> listarProyectos() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Proyecto where estado=1");
        return query.list();
	}

	@Override
	public Proyecto recuperarProyectoPorId(Long id) {
		
		return (Proyecto) sessionFactory.getCurrentSession().load(Proyecto.class, id);
	}

	@Override
	public void agregarUsuarioProyecto(Usuario usuario, Long id) {
		Proyecto proyecto = recuperarProyectoPorId(id);
		List<Usuario> usuarios = proyecto.getUsuarios();
		usuarios.add(usuario);
		proyecto.setUsuarios(usuarios);
	}

	@Override
	public List<Tarea> borrarProyectoPorId(Long id) {
		Proyecto proyecto = this.recuperarProyectoPorId(id);
		List<Tarea> tareas = proyecto.getTareas();
		
		proyecto.setEstado(false);
		editarProyecto(proyecto);
		
		return tareas;
	}

	@Override
	public void editarProyecto(Proyecto proyecto) {
		sessionFactory.getCurrentSession().update(proyecto);
		//log.info("El proyecto es: "+proyecto.getId()+"// La tarea es: "+(proyecto.getTareas()).get((proyecto.getTareas().size() - 1)));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> buscarProyectoPorNombre(String campoBuscar) {
		String hql = "from Proyecto as p where p.estado=1 and (p.nombre like :textoBuscar OR p.descripcion like :textoBuscar)";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("textoBuscar", "%" + campoBuscar + "%");
		return query.list();
	}

}
