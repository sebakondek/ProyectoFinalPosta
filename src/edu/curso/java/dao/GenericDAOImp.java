package edu.curso.java.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public abstract class GenericDAOImp<Entity, K extends Serializable> implements GenericDAO<Entity, K> {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public Class<Entity> domainClass =  getDomainClass();
	 
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Class getDomainClass() {
		   if (domainClass == null) {
		   ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
		   domainClass = (Class) thisType.getActualTypeArguments()[0];
		   }
		  return domainClass;
		 }
	
	@SuppressWarnings("unchecked")
	@Override
	public K guardarClase(Entity clase) {
		
		return (K) sessionFactory.getCurrentSession().save(clase);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entity> listarClase(Entity Clase) {
		Query query = sessionFactory.getCurrentSession().createQuery("from "+Clase.getClass().getName()+" where estado=1");
        return query.list();
	}

	@Override
	public void editarClase(Entity clase) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(clase);

	}

	@SuppressWarnings("unchecked")
	@Override
	public Entity recuperarClasePorId(K id){
		return (Entity) sessionFactory.getCurrentSession().load(domainClass, id);

	}

	

}
