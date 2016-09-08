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
			 	<td>${proyecto.descripcion}</td>
			</tr>
			<tr>
		 	<th>Usuario Principal</th>
		 	<c:if test="${not empty proyecto.usuarioPrincipal}">
				<td>${proyecto.usuarioPrincipal.nombreCompleto}</td>
			</c:if>
			</tr>
		</table>
      </div>
      <div class="modal-footer">
      	<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
      </div>
    </div>
</div>
