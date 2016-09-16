<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<div class="modal-dialog" role="dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"><b>${tarea.nombre}</b></h4>
      </div>
      <div class="modal-body" id="modal-body">
		<table class="table table-bordered">
			<tr>
			 	<th>ID de la Tarea</th>
			 	<td>${tarea.id}</td>
			</tr>
			<tr>
			 	<th>Titulo</th>
			 	<td>${tarea.descripcion}</td>
			</tr>
			<tr>
		 		<th>Horas Totales</th>
		 		<td>${tarea.totalHoras}</td>
			</tr>
			<tr>
				<th>Horas Restantes</th>
				<td>${tarea.horasRestantes}</td>
			</tr>
		</table>
      </div>
      <div class="modal-footer">
      	<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
      </div>
    </div>
</div>
