<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <table class="table table-striped table-bordered table-hover table-responsive">
		<tr>
			<th>Id</th>
			<th>Usuarios</th>
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
					<button type="button" data-toggle="modal" onclick="opcionUsuario(${u.id},'ver')" class="btn btn-primary">Ver</button>
										
					<button type="button" data-toggle="modal" onclick="opcionUsuario(${u.id},'editar')" class="btn btn-primary">Editar</button>
					
					<a href="borrarusuario.html?id=${u.id}" class="btn btn-danger">Borrar</a>
					
					
							<table class="table table-bordered">
								<tr>
								 	<th>Usuario</th>
								 	<td>${u.usuario}</td>
								 </tr>
								 <tr>
								 	<th>Activo</th>
								 	<td>
										<c:choose>
											<c:when test="${u.activo}">SI</c:when>
											<c:otherwise>NO</c:otherwise>
										</c:choose>
									</td>
								</tr>
							</table>
				</td>
			</tr>
		</c:forEach>
	</table>
