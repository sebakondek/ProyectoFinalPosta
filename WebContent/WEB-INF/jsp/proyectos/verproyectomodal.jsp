<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<div class="modal-dialog" role="dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"><b>${proyecto.nombre}</b></h4>
      </div>
      <div class="modal-body" id="modal-body">
		<table class="table table-bordered">
			<tr>
			 	<th>ID del Proyecto</th>
			 	<td>${proyecto.id}</td>
			</tr>
			<tr>
			 	<th>Descripcion</th>
			 	<td><textarea rows="2" cols="50" class="textAreaDesc" readonly>${proyecto.descripcion}</textarea></td>
			</tr>
			<tr>
		 		<th>Usuario Principal</th>
			 	<c:if test="${not empty proyecto.usuarioPrincipal}">
					<td><b>${proyecto.usuarioPrincipal.nombreCompleto}</b></td>
				</c:if>
			</tr>
			<tr>
				<th>Usuarios en el Proyecto</th>
				<td>	
					<c:choose>
						<c:when test="${not empty proyecto.usuarios}">
							<c:forEach items="${proyecto.usuarios}" var="u" varStatus="loop">
								<c:if test="${u.activo == true}">${u.nombreCompleto}</c:if>
								<c:if test="${!loop.last}">,&nbsp;</c:if>
							</c:forEach>
						</c:when>
						<c:otherwise>
							No hay usuarios asignados además del principal.
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th>Tiempo Asignado</th>
				<td>${proyecto.tiempoEstimado} horas</td>
			</tr>
		</table>
		
<!-- Tareas -->

		<hr>
		<h2>Tareas</h2>
		
		<c:choose>
			<c:when test="${proyecto.tiempoReal > 0}">
				<a href="<c:url value="/tareas/nuevatarea.html?id=${proyecto.id}" />" id="nuevaTareaBtn" class="btn btn-warning">Nueva Tarea</a>
			</c:when>
			<c:otherwise>
					<div class="alert alert-warning">
					    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					    <strong>No tiene Horas disponibles!</strong> contactese con ${proyecto.usuarioPrincipal.nombreCompleto} para que le asigne.
				    </div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${empty proyecto.tareas}">
				<div class="alert alert-warning">
	   				<strong>No hay Tareas!</strong> el proyecto no tiene tareas asignadas.
	    		</div>	
			</c:when>
			<c:otherwise>
			
				<table class="table table-striped table-bordered table-hover table-responsive">
					<tr>
						<th>Prioridad</th>
						<th>Titulo</th>
						<th>Duracion Estimada</th>
						<th>Estado</th>
						<th></th>
					</tr>
					<c:forEach items="${proyecto.tareas}" var="t">
						<tr>
							<td>
								<c:choose>
									<c:when test="${t.prioridad == '1' }">
										<h4><span class="label label-danger">Alta</span></h4>
									</c:when>
									<c:when test="${t.prioridad == '2' }">
										<h4><span class="label label-warning">Media</span></h4>
									</c:when>
									<c:otherwise>
										<h4><span class="label label-success">Baja</span></h4>
									</c:otherwise>
								</c:choose>
							</td>
							<td><b>${t.titulo}</b></td>
							<td>${t.duracionEstimada} horas</td>
							<td>
								<c:choose>
									<c:when test="${t.estado == '1' }">
										<h4><span class="label label-warning">En Curso</span></h4>
									</c:when>
									<c:otherwise>
										<h4><span class="label label-success">Completado</span></h4>
									</c:otherwise>
								</c:choose>
							</td>
							<td>
							
								<a href="<c:url value="/tareas/vertarea.html?idT=${t.id}&idP=${proyecto.id}" />" class="btn btn-primary">Ver</a>
								
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
		
      </div>
      <div class="modal-footer">
      	<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
      </div>
    </div>
</div>
