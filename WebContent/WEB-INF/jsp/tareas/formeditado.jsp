<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
	formInit("Tareas");
</script>


<div class="modal-dialog" role="dialog">
	 <div class="modal-content">
	    <div class="modal-header">
       		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        	<h4 class="modal-title" id="myModalLabel"><b>Editar Tarea</b></h4>
      </div>
		<div class="modal-body" id="modal-body">


			<div class="form form-group table">
				<form:form method="post" modelAttribute="tareaForm" action="guardartarea.html" class="form" id="form">
					<form:input path="id" type="hidden" />
					<form:input path="idProyecto" type="hidden"/>
					<form:input path="duracionReal" type="hidden"/>
					<div class="form-group">
						<label for="titulo">Titulo</label>
						<form:input class="form-control required" path="titulo" type="text" />
					</div>
					<div class="form-group">
						<label for="descripcion">Descripcion</label>
						<form:textarea rows="3" cols="70" class="form-control required" path="descripcion" />
					</div>
					<div class="form-group">
						<label for="Prioridad">Prioridad</label>
						<form:select id="select-multiple" class="js-example-basic-single js-states form-control" 
							path="prioridad" itemLabel="prioridad" itemValue="id">
							<option value="Alta"> Alta</option>
							<option value="Media">Media</option>
							<option value="Baja">Baja</option>
					</form:select>
					</div>
					<div class="form-group">
						<label for="totalHoras">Duracion Estimada en Horas<span style="color: red;">Tiene hasta ${tiempoProyecto} para asignar</span></label>
						<form:input class="form-control" path="duracionEstimada" min="0" max="${tiempoProyecto}" type="number"/>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-success" value="Guardar">
					</div>
				</form:form>
			</div>
			

		</div>
      <div class="modal-footer">
      	<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
      </div>
    </div>
</div>