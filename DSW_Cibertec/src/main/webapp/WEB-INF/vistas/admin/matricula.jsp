<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link href="../css/dashboard.css" rel="stylesheet">
<link href="../css/styleMaestro.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../nav.jsp" />
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="menuAdmin.jsp" />
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4 pt-5">
				<div>
					<form action="registrarMatricula" method="post">
						<h4>Datos de la Matricula</h4>
						<div class="form-row">
							<div class="form-group col-md-5">
								<input type="hidden" id="idalumno" name="idalumno"> <input
									type="hidden" id="idturno" name="idturno"> <input
									type="hidden" id="idcarrera" name="idcarrera"> <input
									type="text" class="form-control" id="inputAlumno"
									placeholder="Alumno" readonly="readonly">
							</div>
							<div class="form-group offset-md-1">
								<button class="btn btn-primary" id="btnAlumno" type="button"
									data-toggle="collapse" data-target="#collapseExample"
									aria-controls="collapseExample">Buscar Alumno</button>
							</div>
						</div>
						<div class="from-row col-md-12">
							<div class="collapse col-md-12" id="collapseExample">
								<div class="card card-body col-md-12 row">
									<table class="col-md-12 row">
										<thead class="col-md-12 row">
											<tr class='col-md-12 row'>
												<th class='col-md-1 textAlineado'>ID</th>
												<th class='col-md-4 textAlineado'>Nombre</th>
												<th class='col-md-2 textAlineado'>DNI</th>
												<th class='col-md-3 textAlineado'>Correo</th>
												<th class='col-md-2 textAlineado'>Escoger</th>
											</tr>
										</thead>
										<tbody class='col-md-12' id="tbodyAlumno">
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-5">
								<label for="selectCarrera">Carrera</label> <select
									id="selectcarrera" class="form-control">
									<option value="-1" selected>Seleccione</option>
								</select>
							</div>
							<div class="form-group col-md-2">
								<label for="selectTurno">Turno</label> <select id="selectturno"
									class="form-control">
									<option value="-1" selected>Seleccione</option>
									<option value="1">Ma�ana</option>
									<option value="2">Tarde</option>
									<option value="3">Noche</option>
								</select>
							</div>
							<div class="form-group">
								<label for="inputSeccion">Periodo</label> <input type="text"
									class="form-control" id="inputPeriodo" placeholder="Periodo"
									name="periodo">
							</div>
						</div>
						<h4>Datos del Colegio</h4>
						<div class="form-row">
							<div class="form-group col-md-7">
								<label for="inputColegio">Nombre de Colegio</label> <input
									type="text" class="form-control" id="inputColegio"
									placeholder="Nombre de Colegio" name="nombreColegio">
							</div>
							<div class="form-group col-md-2">
								<label for="inputCodModular">Cod. Modular</label> <input
									type="text" class="form-control" id="inputCodModular"
									placeholder="Codigo" name="codModular">
							</div>
							<div class="form-group col-md-2">
								<label for="inputA�oTermino">A�o de Termino</label> <input
									type="text" class="form-control" id="inputA�oTermino"
									name="finColegio">
							</div>
						</div>
						<h4>Constancia</h4>
						<div class="form-row">
							<div class="custom-file">
								<input type="file" class="custom-file-input"
									id="inputGroupFile01" aria-describedby="inputGroupFileAddon01"
									name="archivo"> <label class="custom-file-label"
									for="inputGroupFile01">Subir Constancia</label>


							</div>
						</div>
						<div class="form-group row pt-3">
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary">Registrar
									Matricula</button>
							</div>
						</div>
					</form>
				</div>
			</main>
		</div>
	</div>
	<script>
		function cargarAlSelec(idalumno, nombre) {
			var nom = nombre;
			$("#idalumno").val(idalumno);
			$("#inputAlumno").val(nom);
		}
		$.getJSON('getAllCarrera', function(data) {
			$.each(data, function(index, value) {
				$("#selectcarrera").append(
						"<option value="+value.idcarrera+">" + value.nombre
								+ "</option>");
			});
		});
		$.getJSON('getAlumnosNoMatriculados',function(data) {
			$.each(data,function(index, value) {
				$("#tbodyAlumno")
						.append(
								"<tr class='col-md-12row''><td class='col-md-1 textAlineado'>"
										+ value.idalumno
										+ "</td><td class='col-md-4 textAlineado'>"
										+ value.nombre
										+ "</td><td class='col-md-2 textAlineado'>"
										+ value.dni
										+ "</td><td class='col-md-3 textAlineado'>"
										+ value.correo
										+ "</td><td class='col-md-2 textAlineado'><button type='button' class='btn btn-primary' data-toggle='collapse' data-target='#collapseExample' aria-controls='collapseExample' id='btnAlumnoSelec' onclick='cargarAlSelec("
										+ value.idalumno
										+ ",&quot;"
										+ value.nombre
										+ "&quot;)'>Escoger</button></td></tr>");
			});
		});
		$("#selectcarrera").change(function() {
			$("#idcarrera").val($(this).val());
		});
		$("#selectturno").change(function() {
			$("#idturno").val($(this).val());
		});
		$("#btnAlumno").click(function() {
			$("#collapseExample").collapse('show');
		});
		$("#btnAlumnoSelec").click(function() {
			$("#collapseExample").collapse('toggle');
			$('.collapse').collapse();
		});
	</script>
</body>
</html>
