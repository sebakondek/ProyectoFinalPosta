<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<div class="modal-dialog" role="dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"><b>${usuario.nombreCompleto}</b></h4>
      </div>
      <div class="modal-body" id="modal-body">
		<div class="table">
			<table class="table table-bordered">
				<tr>
				 	<th>ID del Usuario</th>
				 	<td>${usuario.id}</td>
				</tr>
				<tr>
					<th>Usuario</th>
					<td>${usuario.usuario}</td>
				</tr>
				<tr>
					<th>Activo</th>
					<td>
						<c:choose>
							<c:when test="${usuario.activo}">SI</c:when>
							<c:otherwise>NO</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</table>
		</div>
      </div>
      <div class="modal-footer">
      	<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
      </div>
    </div>
</div>
