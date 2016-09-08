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
					<button type="button" data-toggle="modal" data-id-usuario="${u.id}" class="btn btn-primary btn-ver-usuario">Ver</button>
										
					<a href="editarusuario.html?id=${u.id}" class="btn btn-success">Editar</a>
					
					<a href="borrarusuario.html?id=${u.id}" class="btn btn-danger">Borrar</a>
					
					
					
					
					<div class="modal fade" id="${u.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
					  <div class="modal-dialog" role="dialog">
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					        		<span aria-hidden="true">&times;</span>
					        </button>
					        <h4 class="modal-title" id="myModalLabel"><b>${u.nombreCompleto}</b></h4>
					      </div>
					      <div class="modal-body">
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
					      </div>
					      <div class="modal-footer">
					      </div>
					    </div>
					  </div>
					</div>
				</td>
			</tr>
		</c:forEach>
	</table>
