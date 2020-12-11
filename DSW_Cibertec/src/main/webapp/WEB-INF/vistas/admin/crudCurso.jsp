<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="esS">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="../js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/bootstrapValidator.js"></script>
<link rel="stylesheet" href="../css/bootstrap.css" />
<link rel="stylesheet" href="../css/dataTables.bootstrap.min.css" />
<link rel="stylesheet" href="../css/bootstrapValidator.css" />
</head>
<body>
	<div class="container">
		<h3>Crud de Curso</h3>
		<div class="col-md-23">
			<form accept-charset="UTF-8" action="filtrarCurso"
				class="simple_form" id="defaultForm2" method="post">
				<div class="row" style="height: 70px">
					<div class="col-md-2">
						<input class="form-control" id="id_nonbre_filtro" name="nombre"
							placeholder="Ingrese el nombre" type="text" maxlength="30" />
					</div>
					<div class="col-md-2">
						<button type="submit" class="btn btn-primary" style="width: 150px">FILTRA</button>
					</div>
					<div class="col-md-2">
						<button type="button" data-toggle='modal' onclick="registrar();"
							class='btn btn-success' id="validateBtnw2" style="width: 150px">REGISTRA</button>
					</div>
					<div class="col-md-4">
						<c:if test="${sessionScope.MENSAJE != null }">
							<div class="alert alert-success" id="success-alert">
								<button type="button" class="close" data-dismiss="alert">x</button>
								${sessionScope.MENSAJE}
							</div>
						</c:if>
						<c:remove var="MENSAJE" />
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<div class="content">
							<table id="tableAlumno"
								class="table table-striped table-bordered">
								<thead>
									<tr>
										<th>ID</th>
										<th>Nombre</th>
										<th>Carrera</th>
										<th>Ciclo</th>
										<th>Actualiza</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${sessionScope.cursos}" var="x">
										<tr>
											<td>${x.idcurso}</td>
											<td>${x.nombre}</td>
											<td>${x.carrera.nombre}</td>
											<td>${x.ciclo}</td>
											<td>
												<button type='button' data-toggle='modal'
													onclick="editar('${x.idcurso}','${x.nombre}','${x.carrera.nombre}','${x.ciclo}');"
													class='btn btn-success'>
													<svg width="25px" viewBox="0 0 16 16"
														class="bi bi-check-circle-fill" fill="black"
														xmlns="http://www.w3.org/2000/svg">
																  <path fill-rule="evenodd"
															d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z" />
																</svg>
												</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</form>
			<div>
				<a class="btn btn-primary btn-lg" href="verIndexAdmin">Regresar</a>
			</div>
		</div>
		<div class="modal fade" id="idModalRegistra">
			<div class="modal-dialog" style="width: 60%">
				<div class="modal-content">
					<div class="modal-header" style="padding: 35px 50px">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4>
							<span class="glyphicon glyphicon-ok-sign"></span> Registro de
							Curso
						</h4>
					</div>
					<div class="modal-body" style="padding: 20px 10px;">
						<form id="id_form_registra" accept-charset="UTF-8"
							action="registrarCurso" class="form-horizontal" method="post">
							<div class="panel-group" id="steps">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#steps"
												href="#stepOne">Datos del Curso</a>
										</h4>
									</div>
									<div id="stepOne" class="panel-collapse collapse in">
										<div class="panel-body">
											<div class="form-group">
												<label class="col-lg-3 control-label" for="reg_nombre">Nombre</label>
												<div class="col-lg-5">
													<input class="form-control" id="reg_nombre" name="nombre"
														placeholder="Ingrese el Nombre" type="text" maxlength="50" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="reg_dni">Carrera</label>
												<div class="col-lg-5">
													<select class="custom-select d-block w-100"
														id="reglistadoCarrera" required name="idcarrera">
														<option value="-1">Escoja ...</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="reg_ciclo">Ciclo</label>
												<div class="col-lg-5">
													<input class="form-control" id="reg_ciclo" name="ciclo"
														placeholder="Ingrese el Ciclo" type="text" />
												</div>
											</div>
											<input name="nombre" type="hidden" /> <input
												name="idcarrera" type="hidden" /> <input
												name="ciclo" type="hidden" />
											<div class="form-group">
												<div class="col-lg-9 col-lg-offset-3">
													<button type="submit" class="btn btn-primary"
														id="idBtnRegistra">REGISTRA</button>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="idModalActualiza">
			<div class="modal-dialog" style="width: 60%">
				<div class="modal-content">
					<div class="modal-header" style="padding: 35px 50px">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4>
							<span class="glyphicon glyphicon-ok-sign"></span> Actualiza
							Curso
						</h4>
					</div>
					<div class="modal-body" style="padding: 20px 10px;">
						<form id="id_form_actualiza" accept-charset="UTF-8"
							action="actualizarCurso" class="form-horizontal" method="post">
							<div class="panel-group" id="steps">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#steps"
												href="#stepOne">Datos del Curso</a>
										</h4>
									</div>
									<div id="stepOne" class="panel-collapse collapse in">
										<div class="panel-body">
											<div class="form-group">
												<label class="col-lg-3 control-label" for="ac_idcurso">ID</label>
												<div class="col-lg-5">
													<input class="form-control" id="ac_idcurso" readonly
														name="idcurso" type="text" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="ac_nombre">Nombre</label>
												<div class="col-lg-5">
													<input class="form-control" id="ac_nombre" name="nombre"
														placeholder="Ingrese el Nombre" type="text" maxlength="50" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="ac_dni">Carrera</label>
												<div class="col-lg-5">
													<select class="custom-select d-block w-100"
														id="aclistadoCarrera" required name="idcarrera">
														<option value="-1">Escoja ...</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="ac_ciclo">Ciclo</label>
												<div class="col-lg-5">
													<input class="form-control" id="ac_ciclo" name="ciclo"
														placeholder="Ingrese el Ciclo" type="number" />
												</div>
											</div>
											<input name="idclase" id="ac_idusuario"
												type="hidden" /> <input name="usuario.credencial"
												id="ac_credencial" type="hidden" /> <input
												name="usuario.password" id="ac_password" type="hidden" /> 
											<div class="form-group">
												<div class="col-lg-9 col-lg-offset-3">
													<button type="submit" class="btn btn-primary"
														id="idBtnActualiza">Actualiza</button>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="idModalElimina">
			<div class="modal-dialog" style="width: 60%">
				<div class="modal-content">
					<div class="modal-header" style="padding: 35px 50px">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4>
							<span class="glyphicon glyphicon-ok-sign"></span> Eliminar
							Curso
						</h4>
					</div>
					<div class="modal-footer">
						<button type="button" id="idBtnElimina" name="modalDe"
							class="btn btn-primary">ELIMINAR</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cerrar</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
			$("#success-alert").slideUp(500);
		});
	</script>
	<script type="text/javascript">
		function registrar() {
			$('#idModalRegistra').modal("show");
		}
		function editar(id, nombre, idcar, cic) {
			$('#ac_idcurso').val(id);
			$('#ac_nombre').val(nombre);
			$('#ac_carrera').val(idcar);
			$('#ac_ciclo').val(cic);
			$('#idModalActualiza').modal("show");
		}
		$.getJSON("getCarreras",function(data) {
					$.each(data,function(index, value) {
						$("#reglistadoCarrera").append(
								"<option value="+item.idcarrera+">"
										+ item.nombre + "</option>");
						$("#aclistadoCarrera").append(
								"<option value="+item.idcarrera+">"
										+ item.nombre + "</option>");
					});
				});
		$(document).ready(function() {
			$('#tableAlumno').DataTable();
		});
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#id_form_registra').bootstrapValidator({
				message : 'This value is not valid',
				feedbackIcons : {
					valid : 'glyphicon glyphicon-ok',
					invalid : 'glyphicon glyphicon-remove',
					validating : 'glyphicon glyphicon-refresh'
				},
				fields : {

				}
			});
		});
	</script>
</body>
</html>