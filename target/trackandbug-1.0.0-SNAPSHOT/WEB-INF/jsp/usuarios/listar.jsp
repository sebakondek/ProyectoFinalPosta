<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />

<h1>Listado de usuarios</h1>

<a href="nuevousuario.html" class="btn btn-warning btnnuevo">Nuevo Usuario</a>

	<table class="table table-striped table-bordered table-hover tabla">
		<tr>
			<th>Id</th>
			<th>Usuario</th>
			<th>Nombre Completo</th>
			<th>Activo</th>
			<th>Opciones</th>
		</tr>
		<c:forEach items="${usuarios}" var="u">
			<tr>
				<td>${u.id}</td>
				<td>${u.usuario}</td>
				<td>${u.nombreCompleto}</td>
				<td>
					<c:choose>
						<c:when test="${u.activo}">SI</c:when>
						<c:otherwise>NO</c:otherwise>
					</c:choose>
				</td>
				<td>
					<a href="verusuario.html?id=${u.id}" class="btn btn-primary">Ver</a>
					
					<a href="editarusuario.html?id=${u.id}" class="btn btn-success">Editar</a>
					
					<a href="borrarusuario.html?id=${u.id}" class="btn btn-danger">Borrar</a>
						
						
				</td>
			</tr>
		</c:forEach>
	</table>

<c:import url="/general/template_bottom.jsp" />