<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
  <c:choose>
		<c:when test="${not empty comentarios}">
			<table class="table table-striped table-bordered table-responsive" id="tablaTareas">
				<tr>
					<th></th>
					<th id="thComentario">Comentario</th>
					<th>Opciones</th>
				</tr>
				<c:forEach items="${comentarios}" var="c">
					<tr>
						<c:choose>
							<c:when test="${not c.usuario.estado}">
								<td style="color: red;">${c.usuario.nombreCompleto} (inactivo)</td>
							</c:when>
							<c:otherwise>
								<td>${c.usuario.nombreCompleto}</td>
							</c:otherwise>
						</c:choose>
						
						<td rowspan="2"><textarea rows="3" cols="90" class="textAreaDesc" readonly>${c.comentario}</textarea></td>
						<td rowspan="2" class="tdOpciones">
							<a href="<c:url value="/comentarios/borrarcomentario.html?idC=${c.id}&idT=${tarea.id}&idP=${proyecto.id} "/>" 
									class="btn btn-danger">Borrar</a>
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
  