<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script>
	$(function(){
		formInit("proyecto");	
	});
</script>



<div class="modal-dialog" role="dialog">
	 <div class="modal-content">
	    <div class="modal-header">
       		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        	<h4 class="modal-title" id="myModalLabel"><b>Nuevo Proyecto</b></h4>
      </div>
		<div class="modal-body" id="modal-body">

			<div class="form form-group table">
				<form:form method="post" modelAttribute="proyectoForm" action="guardarproyecto.html" class="form" id="form">
					<form:input path="id" type="hidden" />
					
					<div class="form-group">
						<label for="nombre">Nombre</label>
						<form:input class="form-control required" path="nombre" type="text" />
					</div>
					<div class="form-group">
						<label for="descripcion">Descripcion</label>
						<form:textarea class="form-control required" path="descripcion" />
					</div>
					<div class="form-group">
						<label for="totalHoras">Duracion Estimada en Horas</label>
						<form:input class="form-control required" path="tiempoEstimado"  max="1000" min="0" type="number"/>
					</div>
			<c:choose>
			<c:when test="${empty usuarios}">
						<div class="alert alert-warning">
			   			<strong>No tiene Usuarios!</strong> Debe crear un usuuario para asignar al proyecto.
			   			<a href="../usuarios/nuevousuario.html" class="btn btn-warning">Nuevo Usuario</a>
			    		</div>
			</c:when>
			<c:otherwise>
					<div class="form-group">
						<label for="idUsuarioPrincipal">Usuario Principal</label>
						<form:select path="idUsuarioPrincipal" id="select-single" class="js-example-basic-single js-states form-control" items="${usuarios}" itemLabel="nombreCompleto" itemValue="id">
					</form:select>
					</div>
						<div class="form-group">
						<label for="idUsuarios">Usuarios</label>
						<form:select id="select-multiple" class="js-example-basic-multiple js-states form-control" multiple="multiple" 
							path="idUsuarios" items="${usuarios}" itemLabel="nombreCompleto" itemValue="id">
					</form:select>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-success" value="Guardar">
					</div>
			</c:otherwise>
			</c:choose>
				</form:form>
			</div>
		</div>
		

      <div class="modal-footer">
      	<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
      </div>
    </div>
</div>