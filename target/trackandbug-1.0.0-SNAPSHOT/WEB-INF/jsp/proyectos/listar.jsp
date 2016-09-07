<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />

<h1>Listado de usuarios</h1>

<a href="<c:url value="/proyectos/nuevoproyecto.html" />" class="btn btn-warning btnnuevo">Nuevo Proyecto</a>

<table class="table table-striped table-bordered table-hover">
	<tr>
		<th>Id</th>
		<th>Titulo</th>
		<th>Descripcion</th>
		<th>Opciones</th>
	</tr>
	<c:forEach items="${proyectos}" var="p">
		<tr>
			<td>${p.id}</td>
			<td>${p.nombre}</td>
			<td>${p.descripcion}</td>
			<td>
				<a href="verproyecto.html?id=${p.id}" class="btn btn-primary">Ver</a>
				
				<a href="editarproyecto.html?id=${p.id}" class="btn btn-success">Editar</a>
				
				<a href="borrarproyecto.html?id=${p.id}" class="btn btn-danger">Borrar</a>
				
			</td>
		</tr>
	</c:forEach>
</table>

<c:import url="/general/template_bottom.jsp" />