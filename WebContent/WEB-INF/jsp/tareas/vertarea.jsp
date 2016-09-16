<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />

<script>
	$(function(){
		listarInit("Comentario");
	});
</script>
<div class="row">

	<a href="<c:url value="/proyectos/listar.html"/>" class="btn btn-default pull-right">Volver</a>
<div class="col-md-6 col-md-offset-3">

<h2><b>${proyecto.nombre}</b></h2>

<table class="table">
	<td>
		<h2><b>${tarea.titulo}</b></h2>
	</td>
</table>

	<button type="button" data-toggle="modal" onclick="opcionTarea(${proyecto.id}, ${tarea.id},'editar')" 
				class="btn btn-primary" id="editarBtn">Editar</button>

<table class="table table-striped table-bordered table-hover table-responsive">
	<tr>
	    <th>ID</th>
	    <td>${tarea.id}</td>
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
    	<th>Fecha de Alta</th>
    	<td>${tarea.fechaAlta}</td>
    </tr>
    <tr>
    	<th>Prioridad</th>
    	<td>
    		<c:choose>
				<c:when test="${tarea.prioridad == '1' }">
					<h3><span class="label label-danger label-vista">Alta</span></h3>
				</c:when>
				<c:when test="${tarea.prioridad == '2' }">
					<h3><span class="label label-warning label-vista">Media</span></h3>
				</c:when>
				<c:otherwise>
					<h3><span class="label label-success label-vista">Baja</span></h3>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
</table>

<div id="myModalTarea" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"></div>

</div>
</div>


<!-- Comentarios -->

<hr>
<h2><b>Comentarios</b></h2>

<a onclick="opcionComentario(0, ${tarea.id}, ${proyecto.id},'crear')" class="btn btn-warning" id="nuevoComentarioBtn">Nuevo Comentario</a>


<form id="miFormBuscadorComent" method="post" onsubmit="opcionComentario(0,0,0,'buscar'); return false;" 
		class="form-inline" modelAttribute="buscarForm">
	<div class="form-group">
		<input name="campoBuscar" class="form-control" id="campoBuscarComent" type="text" placeholder="Buscar Comentario">
		<input name="idTarea" type="hidden" value="${tarea.id}" />
		<input name="idProy" type="hidden" value="${proyecto.id}" />
	</div>
		<input type="submit" class="btn btn-default" value="Buscar" id="btnBuscarCom">
</form>	
	
		
<div id="myModalComent" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"></div>

<div id="divComentarios"></div>



<c:import url="/general/template_bottom.jsp" />