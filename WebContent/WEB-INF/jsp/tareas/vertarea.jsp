<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />

<script>
	listarInit("Comentarios");
</script>

<table class="table table-striped table-bordered table-hover table-responsive">
	<tr>
	    <th>ID:</th>
	    <td>${tarea.id}</td>
 	</tr>
    <tr>
	    <th>Titulo:</th>
	    <td>${tarea.titulo}</td>
	</tr>
    <tr>
	    <th>Duración Estimada:</th>
	    <td>${tarea.duracionEstimada}</td>
    </tr>
    <tr>
	    <th>Descripción:</th>
	    <td>${tarea.descripcion}</td>
    </tr>
</table>


<form id="miFormBuscadorComent" method="post" onsubmit="opcionComentario(0,'buscar'); return false;" class="form-inline">
	<div class="form-group">
		<input name="campoBuscar" class="form-control" id="campoBuscarCom" type="text" placeholder="Buscar">
	</div>
		<input type="submit" class="btn btn-default" value="Buscar" id="btnBuscarCom">
</form>


<!-- Comentarios -->
		
		<table class="table table-striped table-bordered table-hover table-responsive">
		<tr>
			<th>Id</th>
			<th>Comentario</th>
			<th>Usuario</th>
			<th>Fecha</th>
			<th>Opciones</th>
		</tr>
		<c:forEach items="${tarea.comentarios}" var="c">
			<tr>
				<td>${c.id}</td>
				<td>${c.comentario}</td>
				<td>${c.usuario.nombreCompleto}</td>
				<td>${c.fecha}</td>
				<td>
					<a href="<c:url value="/tareas/vertarea.html?id=${t.id}" />" class="btn btn-primary">Ver </a>
				</td>
			</tr>
		</c:forEach>
	</table>


<c:import url="/general/template_bottom.jsp" />