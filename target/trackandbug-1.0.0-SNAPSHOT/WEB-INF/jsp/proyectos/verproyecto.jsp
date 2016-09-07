<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />

<table class="table table-bordered">
	 <tr>
	 	<th>ID</th>
	 	<td>${proyecto.id}</td>
	 </tr>
	 <tr>
	 	<th>Titulo</th>
	 	<td>${proyecto.nombre}</td>
	 </tr>
	 	<th>Descripcion</th>
	 	<td>${proyecto.descripcion}</td>
	 </tr>
</table>

<a href="<c:url value="/proyectos/listar.html" />" class="btn btn-default">Volver</a>

<c:import url="/general/template_bottom.jsp" />