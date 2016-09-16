package edu.curso.java.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.bo.Comentario;

@Repository
public class ComentarioDAOImp extends GenericDAOImp<Comentario, Long>implements ComentarioDAO  {

	@Autowired
	private SessionFactory sessionFactory;
	
		
	@Override
	public void borrarComentarioPorId(Long id) {
		Comentario comentario = super.recuperarClasePorId(id);
		comentario.setEstado(false);
		super.editarClase(comentario);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Comentario> buscarComentarioPorContenido(String campoBuscar) {
		String hql = "from Comentario as c where c.comentario like :textoBuscar and estado=1";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("textoBuscar", "%" + campoBuscar + "%");
		return query.list();
	}

	
}
