<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <table class="table table-striped table-bordered table-hover table-responsive">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Descripcion</th>
			<th>Usuario Principal</th>
			<th>Opciones</th>
		</tr>
		<c:forEach items="${proyectos}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.nombre}</td>
				<td><textarea rows="2" cols="70" class="textAreaDesc" readonly>${p.descripcion}</textarea></td>
				<c:if test="${not empty p.usuarioPrincipal}">
					<td>${p.usuarioPrincipal.nombreCompleto}</td>
				</c:if>
				<td>
					<button type="button" data-toggle="modal" onclick="opcionProyecto(${p.id},'ver')" class="btn btn-success">Ver</button>
										
					<button type="button" data-toggle="modal" onclick="opcionProyecto(${p.id},'editar')" class="btn btn-primary">Editar</button>
					
					<a href="borrarproyecto.html?id=${p.id}" class="btn btn-danger">Borrar</a>
															
				</td>
			</tr>
			
			
			
		</c:forEach>
	</table>
