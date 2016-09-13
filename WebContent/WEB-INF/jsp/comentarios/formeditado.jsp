<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />




<div class="form form-group table">
	<form:form method="post" modelAttribute="comentarioForm" action="guardarcomentario.html" class="form">
		<form:input path="id" type="hidden" />
		<form:input path="idUsuario" type="hidden" />
		<form:input path="idTarea" type="hidden" />
		<form:input path="idProyecto" type="hidden" value="${proyecto.id}" />
		<form:input path="estado" type="hidden" />
		<div class="form-group">
			<label for="comentario">Comentario</label>
			<form:textarea class="form-control" path="comentario" type="text" />
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-success" value="Guardar">
			<a href="<c:url value="/tareas/vertarea.html?idT=${comentarioForm.idTarea}&idP=${proyecto.id}" />" class="btn btn-danger">Volver </a>
		</div>
	</form:form>
</div>

<c:import url="/general/template_bottom.jsp" />