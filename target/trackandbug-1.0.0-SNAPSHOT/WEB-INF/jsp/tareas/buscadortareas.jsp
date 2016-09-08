<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<form id="miFormBuscadorTareas" method="post" action="buscartareas.html" class="form-inline">
		<div class="form-group">
			<input name="campoBuscar" class="form-control" id="campoBuscar" type="text" placeholder="Buscar">
		</div>
			<input type="button" class="btn btn-default" value="Buscar" id="btnBuscarTarea">
	</form>

    <table class="table table-striped table-bordered table-hover table-responsive">
		<tr>
			<th>Id</th>
			<th>Titulo</th>
			<th>Horas Totales</th>
			<th>Horas Restantes</th>
			<th>Opciones</th>
		</tr>
		<c:forEach items="${tareas}" var="t">
			<tr>
				<td>${t.id}</td>
				<td>${t.titulo}</td>
				<td>${t.totalHoras}</td>
				<td>${t.horasRestantes}</td>
				<td>
					<button type="button" data-toggle="modal" data-id-proyecto="${t.id}" class="btn btn-primary btn-ver-proyecto">Ver</button>
										
					<a href="editarproyecto.html?id=${t.id}" class="btn btn-success">Editar</a>
					
					<a href="borrarproyecto.html?id=${t.id}" class="btn btn-danger">Borrar</a>
					
				</td>
			</tr>
			
			
			
		</c:forEach>
	</table>
