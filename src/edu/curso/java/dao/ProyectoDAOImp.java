package edu.curso.java.dao;

import java.util.List;


import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Usuario;

@Repository
public class ProyectoDAOImp extends GenericDAOImp<Proyecto, Long> implements ProyectoDAO {
	
	private static final Logger log = Logger.getLogger(ProyectoDAOImp.class);

	@Autowired
	private SessionFactory sessionFactory; 
	

	
	@Override
	public void agregarUsuarioProyecto(Usuario usuario, Long id) {
		Proyecto proyecto = super.recuperarClasePorId(id);
		List<Usuario> usuarios = proyecto.getUsuarios();
		usuarios.add(usuario);
		proyecto.setUsuarios(usuarios);
	}

	@Override
	public List<Tarea> borrarProyectoPorId(Long id) {
		Proyecto proyecto = super.recuperarClasePorId(id);
		List<Tarea> tareas = proyecto.getTareas();
		
		proyecto.setEstado(false);
		super.editarClase(proyecto);
		
		return tareas;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> buscarProyecto(String campoBuscar) {
		String hql = "from Proyecto as p where p.estado = 1 and (p.nombre like :textoBuscar OR p.descripcion like :textoBuscar OR p.id like :textoBuscar) order by p.nombre";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("textoBuscar", "%" + campoBuscar + "%");
		return query.list();
	}

	
	@Override
	public Proyecto recuperarClasePorId2(Long id) {
		return (Proyecto) sessionFactory.getCurrentSession().load(Proyecto.class, id);
	}

}
