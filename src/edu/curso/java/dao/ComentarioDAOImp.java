package edu.curso.java.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.bo.Comentario;

@Repository
public class ComentarioDAOImp implements ComentarioDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Long guardarComentario(Comentario comentario) {
		return (Long) sessionFactory.getCurrentSession().save(comentario);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comentario> listarComentarios() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Comentario");
		return query.list();
	}

	@Override
	public Comentario recuperarComentarioPorId(Long id){
		return (Comentario) sessionFactory.getCurrentSession().load(Comentario.class, id);
	}
	
	@Override
	public void borrarComentarioPorId(Long id) {
		Comentario comentario = this.recuperarComentarioPorId(id);
		sessionFactory.getCurrentSession().delete(comentario);
	}

	@Override
	public void editarComentario(Comentario comentario) {
		sessionFactory.getCurrentSession().update(comentario);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comentario> buscarComentario(String campoBuscar, String idBuscar) {
		String hql = "from Tarea as t inner join Comentario as c on t.id = :idBuscar AND c.comentario like :textoBuscar ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("textoBuscar", "%" + campoBuscar + "%");
		query.setString("idBuscar", "%" + idBuscar + "%");
		return query.list();
	}

	
}
