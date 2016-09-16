package edu.curso.java.dao;

import java.io.Serializable;
import java.util.List;


public interface GenericDAO<Entity, K  extends Serializable> {

	List<Entity> listarClase(Entity Clase);
	void editarClase(Entity clase);
	Entity recuperarClasePorId(K id);
	K guardarClase(Entity clase);

}
