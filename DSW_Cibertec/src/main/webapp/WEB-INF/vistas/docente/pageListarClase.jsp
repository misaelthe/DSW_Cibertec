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
<link href="css/dashboard.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="menuDocente.jsp" />

			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Seleccione la Clase</h1>
				</div>
				<div class="from-row">
					<div class="col-12">
						<div class="card card-body">
							<table>
								<thead>
									<tr>
										<th>ID</th>
										<th>Curso</th>
										<th>Seccion</th>
										<th>Ver Nota</th>
									</tr>
								</thead>
								<tbody id="tbodyClases">

								</tbody>
							</table>
						</div>
					</div>
				</div>
				<form action="verPageListarAlumnos" method="post" id="formEnvio">
					<input type="hidden" name="idclase" id="idclase">
				</form>

			</main>
		</div>
	</div>
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
	<script src="js/dashboard.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$.getJSON("getClasesAlumno",function(data) {
			$.each(data,function(index, value) {
												$("#tbodyClases")
														.append(
																"<tr class='arClases'><td>"
																		+ value.idclase
																		+ "</td><td>"
																		+ value.curso.idcurso
																		+ "</td><td>"
																		+ value.seccion.idseccion
																		+ "</td><td><button class='btn btn-success' onclick='verNota("
																		+ value.idclase
																		+ ")'></button></td></tr>");
											});
						});
		$(".arClases").click(function() {

		});
		function verNota(idclase) {
			$("#idclase").val(idclase);
			$("#formEnvio").submit();
		}
	</script>

</body>
</html>
