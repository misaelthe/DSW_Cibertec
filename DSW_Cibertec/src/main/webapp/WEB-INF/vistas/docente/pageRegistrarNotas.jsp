<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link href="../css/dashboard.css" rel="stylesheet">
<link href="../css/styleMaestro.css" rel="stylesheet">
<script src="../css/bootstrapValidator.css"></script>
</head>
<body>
	<jsp:include page="../nav.jsp" />
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="menuDocente.jsp" />
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Seleccione el Alumno</h1>
				</div>
				<form action="registrarNotas" method="post" id="formRegistra"
					data-toggle="validator" role="form">
					<div class="form-group row">
						<label for="inTeo1" class="col-sm-2 col-form-label">Examen
							Teorico 1</label>
						<div class="col-sm-2">
							<input type="number" class="form-control" id="inTeo1"
								name="inTeo1" max="20">
						</div>
					</div>
					<div class="form-group row">
						<label for="inTeo2" class="col-sm-2 col-form-label">Examen
							Teorico 2</label>
						<div class="col-sm-2">
							<input type="number" class="form-control" id="inTeo2"
								name="inTeo2">
						</div>
					</div>
					<div class="form-group row">
						<label for="inPar" class="col-sm-2 col-form-label">Examen
							Parcial</label>
						<div class="col-sm-2">
							<input type="number" class="form-control" id="inPar" name="inPar">
						</div>
					</div>
					<div class="form-group row">
						<label for="inTeo3" class="col-sm-2 col-form-label">Examen
							Teorico 3</label>
						<div class="col-sm-2">
							<input type="number" class="form-control" id="inTeo3"
								name="inTeo3">
						</div>
					</div>
					<div class="form-group row">
						<label for="inFin" class="col-sm-2 col-form-label">Examen
							Final</label>
						<div class="col-sm-2">
							<input type="number" class="form-control" id="inFin" name="inFin">
						</div>
					</div>
					<div class="form-group row">
						<label for="inFin" class="col-sm-2 col-form-label">Promedio
							General </label>
						<div class="col-sm-2">
							<input type="number" class="form-control" id="inProm" readonly>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-10">
							<button type="submit" class="btn btn-primary">Registrar
								Nota</button>
						</div>
					</div>
				</form>

			</main>
		</div>
	</div>
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/bootstrapValidator.js"></script>
	<script type="text/javascript">
		$.getJSON("getNotaXAlumnoXClase", function(data) {
			$("#inTeo1").val(data.e1);
			$("#inTeo2").val(data.e2);
			$("#inPar").val(data.ep);
			$("#inTeo3").val(data.e3);
			$("#inFin").val(data.ef);
			$("#inProm").val(data.promedio);
		});
		$('#formRegistra').validator().on('submit', function(e) {
			if (e.isDefaultPrevented()) {
				// handle the invalid form...
			} else {
				// everything looks good!
			}
		})
	</script>
	<script type="text/javascript">
		$('#formRegistra')
				.bootstrapValidator(
						{
							message : 'This value is not valid',
							feedbackIcons : {
								valid : 'glyphicon glyphicon-ok',
								invalid : 'glyphicon glyphicon-remove',
								validating : 'glyphicon glyphicon-refresh'
							},
							fields : {
								"inTeo1" : {
									selector : '#inTeo1',
									validators : {
										integer : {
											message : 'Please enter the valid number ',
											min : 0,
											max : 20
										},
										regex : {
											regex : "/^\d{1,2}$/",
											message : "Formato de la ET01 es incorrecto"
										}
									}
								},
								"inTeo2" : {
									selector : '#inTeo2',
									validators : {
										stringLength : {
											message : 'La ET02 es entre 2 nro o caracteres',
											min : 2,
											max : 2
										},
										regex : {
											regex : "/^\d{2}[A-Z]{2}$/",
											message : "Formato de la ET02 es incorrecto"
										}
									}
								},
								"inPar" : {
									selector : '#inPar',
									validators : {
										stringLength : {
											message : 'El Examen Parcial es entre 2 nro o caracteres',
											min : 2,
											max : 2
										},
										regex : {
											regex : "/^\d{2}[A-Z]{2}$/",
											message : "Formato del examen parcial es incorrecto"
										}
									}
								},
								"inTeo3" : {
									selector : '#inTeo3',
									validators : {
										stringLength : {
											message : 'La ET03 es entre 2 nro o caracteres',
											min : 2,
											max : 2
										},
										regex : {
											regex : "/^\d{2}[A-Z]{2}$/",
											message : "Formato de la ET03 es incorrecto"
										}
									}
								},
								"inFin" : {
									selector : '#inFin',
									validators : {
										stringLength : {
											message : 'La EF es entre 2 nro o caracteres',
											min : 2,
											max : 2
										},
										regex : {
											regex : "/^\d{2}[A-Z]{2}$/",
											message : "Formato del EF es incorrecto"
										}
									}
								},
								"inProm" : {
									selector : '#inProm',
									validators : {
										stringLength : {
											message : 'La PG es entre 2 nro o caracteres',
											min : 2,
											max : 2
										},
										regex : {
											regex : "/^\d{2}[A-Z]{2}$/",
											message : "Formato del PG es incorrecto"
										},
									}
								},
							}
						});
	</script>
</body>
</html>
