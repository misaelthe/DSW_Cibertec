<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
	<script src="js/dashboard.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	<link href="css/dashboard.css" rel="stylesheet">	    
  </head>
  <body>
  <jsp:include page="barraNotificaciones.jsp" />
  <div class="container-fluid">
  <div class="row">
	<jsp:include page="menu.jsp" />

	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4 pt-5">
      	<div>
	      		<h4>Registro de Notas</h4>
	      		<form>

				  <div class="form-group row">
				    <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Evaluacion Teorica 1</label>
				    <div class="col-sm-10">
				      <input type="number" class="form-control form-control-lg" id="colFormLabelLg" placeholder="col-form-label-lg">
				    </div>
				  </div>
				  
				  <div class="form-group row">
				    <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Evaluacion Teorica 2</label>
				    <div class="col-sm-10">
				      <input type="number" class="form-control form-control-lg" id="colFormLabelLg" placeholder="col-form-label-lg">
				    </div>
				  </div>
				  
				  <div class="form-group row">
				    <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Evaluacion Parcial</label>
				    <div class="col-sm-10">
				      <input type="number" class="form-control form-control-lg" id="colFormLabelLg" placeholder="col-form-label-lg">
				    </div>
				  </div>
				  
				  <div class="form-group row">
				    <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Evaluacion Teorica 3</label>
				    <div class="col-sm-10">
				      <input type="number" class="form-control form-control-lg" id="colFormLabelLg" placeholder="col-form-label-lg">
				    </div>
				  </div>
				  
				  <div class="form-group row">
				    <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Evaluacion Final</label>
				    <div class="col-sm-10">
				      <input type="number" class="form-control form-control-lg" id="colFormLabelLg" placeholder="col-form-label-lg">
				    </div>
				  </div>
				</form>

      	</div>
    </main>
    </div>
    </div>
        <script>
		    $.getJSON("getAlumnosDocenteCurso()", function(data) {
		    	$.each(data, function (index, value) {
		            $("#inputAlumno").val(value.nombre);
		        });
		     });
			$("#btnAlumno").click(function(){
				$("#collapseExample").collapse('show');
			});
	    </script>
	</body>
</html>
