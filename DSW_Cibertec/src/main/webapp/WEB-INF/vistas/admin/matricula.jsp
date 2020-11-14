<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
	<script src="../js/dashboard.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	<link href="../css/dashboard.css" rel="stylesheet">	    
  </head>
  <body>
    <jsp:include page="../nav.jsp" />
  <div class="container-fluid">
  <div class="row">
	<jsp:include page="menuAdmin.jsp" />

	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4 pt-5">
      	<div>
	      	<form action="">
	      		<h4>Datos de la Matricula</h4>
	      		<div class="form-row">
					<div class="form-group col-md-5">
						<input type="hidden" id="idalumno">	
			    		<input type="text" class="form-control" id="inputAlumno" placeholder="Alumno" readonly="readonly">		  	
			  		</div>
			  		<div class="form-group offset-md-1">
			  			<button class="btn btn-primary" id="btnAlumno" type="button" data-toggle="collapse" data-target="#collapseExample" aria-controls="collapseExample">
					    	Buscar Alumno
					  	</button>
			  		</div>
				</div>	
				<div class="from-row">
					<div class="collapse col-12" id="collapseExample">
						<div class="card card-body">
						    <table>
						    	<thead>
						    		<tr>
										<th>ID</th>
										<th>Nombre</th>
										<th>DNI</th>
										<th>Correo</th>
										<th>Telefono</th>
									</tr>
						    	</thead>
						    	<tbody id="tbodyAlumno">
						    	
						    	</tbody>
						    </table>
						</div>
					</div>
				</div>
		      	<div class="form-row">
		      		<div class="form-group col-md-5">
				      <label for="selectCarrera">Carrera</label>
				      <select id="selectCarrera" class="form-control">
				        <option selected>Escoja...</option>
				      </select>
				    </div>
				    <div class="form-group col-md-2">
				      <label for="selectTurno">Turno</label>
				      <select id="selectTurno" class="form-control">
				        <option selected>Mañana</option>
				        <option>Tarde</option>
				        <option>Noche</option>
				      </select>
				    </div>
		      		<div class="form-group">
				    	<label for="inputSeccion">Seccion</label>
				    	<input type="text" class="form-control" id="inputSeccion" placeholder="Seccion">
				  	</div>				  					    
		      	</div>
		      	<h4>Datos del Colegio</h4>
		      	<div class="form-row">
		      		<div class="form-group col-md-7">
				      <label for="inputColegio">Nombre de Colegio</label>
				      <input type="text" class="form-control" id="inputColegio" placeholder="Nombre de Colegio">	
				    </div>
				    <div class="form-group col-md-2">
				      <label for="inputCodModular">Cod. Modular</label>
				      <input type="text" class="form-control" id="inputCodModular" placeholder="Codigo">	
				    </div>
				    <div class="form-group col-md-2">
				      <label for="inputAñoTermino">Año de Termino</label>
				      <input type="text" class="form-control" id="inputAñoTermino">	
				    </div>
		      	</div>
		      	<h4>Constancia</h4>
		      	<div class="form-row">
		      		<div class="custom-file">
					  <input type="file" class="custom-file-input" id="customFile">
					  <label class="custom-file-label col-md-4" for="customFile">Subir Constancia</label>
					</div>
		      	</div>
		      	<div class="form-group row pt-3">
					<div class="col-sm-10">
				      <button type="submit" class="btn btn-primary">Registrar Matricula</button>
				    </div>
				</div>
	      	</form>
      	</div>
    </main>
    </div>
    </div>
        <script>
		    $.getJSON('getAlumnosNoMatriculados', function(data) {
		    	$.each(data, function (index, value) {
		            $("#tbodyAlumno").append("<tr><td>"+value.idalumno+"</td><td>"+value.nombre+"</td><td>"+value.dni+"</td><td>"+value.correo+"</td><td>"+value.telefono+"</td></tr>");
		        });
		     });
			$("#btnAlumno").click(function(){
				$("#collapseExample").collapse('show');
			});
	    </script>
	</body>
</html>
