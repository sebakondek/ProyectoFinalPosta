<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script>
$(function(){
	formInit("tarea");
});

</script>


<div class="modal-dialog" role="dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"><b>Nueva Tarea</b></h4>
      </div>
      <div class="modal-body" id="modal-body">


			<div class="form form-group table">
				<form:form id="form" method="post" modelAttribute="tareaForm" action="../tareas/guardartarea.html" >
					<form:input path="id" type="hidden" />
					<form:input path="idProyecto" type="hidden"/>
					<form:input path="duracionReal" type="hidden"/>
					<div class="form-group">
						<label for="titulo">Titulo</label>
						<form:input class="form-control" path="titulo" pattern="[a-zA-Z0-9]+" data-error="enter valid username" type="text" required="required"/>
					</div>
					<div class="form-group">
						<label for="descripcion">Descripcion</label>
						<form:textarea class="form-control required" path="descripcion" name="descripcion" pattern="[a-zA-Z0-9]+" required="required"/>
					</div>
					<div class="form-group">
						<label for="totalHoras">Duracion Estimada en Horas <span style="color: red;">Tiene hasta ${tiempoProyecto} para asignar</span></label>
						<form:input class="form-control" path="duracionEstimada" max="${tiempoProyecto}" min="0" type="number" name="number" required="required"/>
					</div>
					<div class="form-group">
						<label for="prioridad">Prioridad</label>
						<form:select id="select-single" class="js-example-basic-single js-states form-control" 
								path="prioridad" itemLabel="prioridad" itemValue="id" required="required">
							<option value="1"> Alta</option>
							<option value="2">Media</option>
							<option value="3">Baja</option>
						</form:select>
					</div>
					<div class="form-group">
						<label for="tipoTarea">Tipo de Tarea</label>
						<form:select id="select-single" class="js-example-basic-single js-states form-control" 
								path="tipoTarea" itemLabel="tipoTarea" itemValue="id" required="required">
							<option value="1">Desarrollo</option>
							<option value="2">Análisis</option>
							<option value="3">Testing</option>
						</form:select>
					</div>
					<div class="form-group">
						<label for="idUsuarios">Usuarios de la Tarea</label>
						<form:select id="select-multiple" class="js-example-basic-multiple js-states form-control" multiple="multiple" 
							path="idUsuarios" items="${proyecto.usuarios}" itemLabel="nombreCompleto" itemValue="id">
						</form:select>
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