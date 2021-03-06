<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />



<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="form form-group table">
	<form:form method="post" modelAttribute="tareaForm" action="guardartarea.html" class="form">
		<form:input path="id" type="hidden" />
		<form:input path="horasRestantes" type="hidden" />
		<div class="form-group">
			<label for="titulo">Titulo</label>
			<form:input class="form-control" path="titulo" type="text" />
		</div>
		<div class="form-group">
			<label for="totalHoras">Horas Totales</label>
			<form:input class="form-control" path="totalHoras" type="number"/>
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-success" value="Guardar">
			<a href="<c:url value="/proyectos/listar.html" />" class="btn btn-danger">Volver </a>
		</div>
	</form:form>
</div>

<c:import url="/general/template_bottom.jsp" />