<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />


<h2><b>${proyecto.nombre}</b></h2>

<table class="table">
	<td>
		<h2><b>Tarea</b></h2>
	</td>
	<td>
	<a href="<c:url value="/proyectos/listar.html" />" class="btn btn-default" id="btnVolverTarea">Volver</a>
	</td>
</table>

<table class="table table-striped table-bordered table-hover table-responsive">
	<tr>
	    <th>ID</th>
	    <td>${tarea.id}</td>
 	</tr>
    <tr>
	    <th>Titulo</th>
	    <td>${tarea.titulo}</td>
	</tr>
    <tr>
	    <th>Duración Estimada</th>
	    <td>${tarea.duracionEstimada} horas</td>
    </tr>
    <tr>
	    <th>Descripción</th>
	    <td><textarea rows="3" cols="70" class="textAreaDesc">${tarea.descripcion}</textarea></td>
    </tr>
    <tr>
    	<th>Prioridad</th>
    	<td>
    		<c:choose>
				<c:when test="${tarea.prioridad == 'Alta' }">
					<h3><span class="label label-danger label-vista">Alta</span></h3>
				</c:when>
				<c:when test="${tarea.prioridad == 'Media' }">
					<h3><span class="label label-warning label-vista">Media</span></h3>
				</c:when>
				<c:otherwise>
					<h4><span class="label label-success label-vista">Baja</span></h3>
				</c:otherwise>
			</c:choose>
		</td>
		
		<button type="button" data-toggle="modal" onclick="opcionTarea(${proyecto.id}, ${tarea.id},'editar')" class="btn btn-primary" id="editarBtn">Editar</button>
		
</table>

<div id="myModalTarea" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"></div>



<!-- Comentarios -->

	<hr>
	<h2><b>Comentarios</b></h2>
	<table id="comentTableHeader">
		<tr>
		<td>
			<form id="miFormBuscadorComent" method="post" onsubmit="opcionComentario('buscar'); return false;" class="form-inline">
				<div class="form-group">
					<input name="campoBuscar" class="form-control" id="campoBuscarCom" type="text" placeholder="Buscar">
				</div>
					<input type="submit" class="btn btn-default" value="Buscar" id="btnBuscarCom">
			</form>
		</td>
		<td>
			<a onclick="opcionComentario(0, ${tarea.id}, ${proyecto.id},'crear')" class="btn btn-warning" id="nuevoComentarioBtn">Nuevo Comentario</a>
		</td>
		</tr>
	</table>
		
		
<div id="myModalComent" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"></div>


	<c:choose>
		<c:when test="${not empty tarea.comentarios}">
			<table class="table table-striped table-bordered table-responsive" id="tablaTareas">
				<tr>
					<th></th>
					<th id="thComentario">Comentario</th>
					<th>Opciones</th>
				</tr>
				<c:forEach items="${tarea.comentarios}" var="c">
					<tr>
						<c:choose>
							<c:when test="${not c.usuario.activo}">
								<td style="color: red;">${c.usuario.nombreCompleto}</td>
							</c:when>
							<c:otherwise>
								<td>${c.usuario.nombreCompleto}</td>
							</c:otherwise>
						</c:choose>
						
						<td rowspan="2"><textarea rows="3" cols="90" class="textAreaDesc" readonly>${c.comentario}</textarea></td>
						<td rowspan="2" class="tdOpciones">
							<a onclick="opcionComentario(${c.id}, ${tarea.id}, ${proyecto.id},'editar')" class="btn btn-primary">Editar</a>
						</td>
					</tr>
					<tr>
						<td class="tdFecha">${c.fecha}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h3><b>No hay comentarios para esta tarea.</b></h3>
		</c:otherwise>
	</c:choose>


<c:import url="/general/template_bottom.jsp" />