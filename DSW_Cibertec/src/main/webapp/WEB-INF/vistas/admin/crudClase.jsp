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
		<h3>Crud de Clase</h3>
		<div class="col-md-23">
			<form id="idFormElimina" action="eliminarClase">
				<input type="hidden" id="id_elimina" name="idclase">
			</form>
			<form accept-charset="UTF-8" action="filtrarClase"
				class="simple_form" id="defaultForm2" method="post">
				<div class="row" style="height: 70px">
					<div class="col-md-2">
						<input class="form-control" id="id_nonbre_filtro" name="nombre"
							placeholder="Ingrese el curso" type="text" maxlength="30" />
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

							<table id="tableClase" class="table table-striped table-bordered">
								<thead>
									<tr>
										<th>ID</th>
										<th>Seccion</th>
										<th>Curso</th>
										<th>Docente</th>
										<th>Inscritos</th>
										<th>Editar</th>
										<th>Eliminar</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${sessionScope.clases}" var="x">
										<tr>
											<td>${x.idclase}</td>
											<td>${x.seccion.codigo}</td>
											<td>${x.curso.nombre}</td>
											<td>${x.docente.nombre}</td>
											<td>${x.alum_ins}</td>
											<td>
												<button type='button' data-toggle='modal'
													onclick="editar('${x.idclase}','${x.seccion.idseccion}','${x.curso.idcurso}','${x.docente.iddocente}','${x.alum_ins}');"
													class='btn btn-success'>
													<svg width="25px" viewBox="0 0 16 16"
														class="bi bi-check-circle-fill" fill="black"
														xmlns="http://www.w3.org/2000/svg">
																  <path fill-rule="evenodd"
															d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z" />
																</svg>
												</button>
											</td>
											<td>
												<button type='button' data-toggle='modal'
													onclick="eliminar('${x.idclase}');" class='btn btn-success'>
													<svg width="25px" viewBox="0 0 16 16"
														class="bi bi-x-octagon-fill" fill="black"
														xmlns="http://www.w3.org/2000/svg">
																  <path fill-rule="evenodd"
															d="M11.46.146A.5.5 0 0 0 11.107 0H4.893a.5.5 0 0 0-.353.146L.146 4.54A.5.5 0 0 0 0 4.893v6.214a.5.5 0 0 0 .146.353l4.394 4.394a.5.5 0 0 0 .353.146h6.214a.5.5 0 0 0 .353-.146l4.394-4.394a.5.5 0 0 0 .146-.353V4.893a.5.5 0 0 0-.146-.353L11.46.146zm-6.106 4.5a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z" />
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
							Clase
						</h4>
					</div>
					<div class="modal-body" style="padding: 20px 10px;">
						<form id="id_form_registra" accept-charset="UTF-8"
							action="registrarClase" class="form-horizontal" method="post">
							<div class="panel-group" id="steps">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#steps"
												href="#stepOne">Datos de la Clase</a>
										</h4>
									</div>
									<div id="stepOne" class="panel-collapse collapse in">
										<div class="panel-body">
											<div class="form-group">
												<label class="col-lg-3 control-label" for="reg_seccion">Seccion</label>
												<div class="col-lg-5">
													<select id="reg_seccion" name="idseccion"
														class='form-control'>
														<option value="-1">Seleccione</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="reg_curso">Curso</label>
												<div class="col-lg-5">
													<select id="reg_curso" name="idcurso" class='form-control'>
														<option value="-1">Seleccione</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="reg_docente">Docente</label>
												<div class="col-lg-5">
													<select id="reg_docente" name="iddocente"
														class='form-control'>
														<option value="-1">Seleccione</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="reg_ins">Inscritos</label>
												<div class="col-lg-5">
													<input class="form-control" id="reg_ins" name="ins"
														placeholder="Ingrese los Inscritos" type="number" />
												</div>
											</div>
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
							<span class="glyphicon glyphicon-ok-sign"></span> Actualiza Clase
						</h4>
					</div>
					<div class="modal-body" style="padding: 20px 10px;">
						<form id="id_form_actualiza" accept-charset="UTF-8"
							action="actualizarClase" class="form-horizontal" method="post">
							<div class="panel-group" id="steps">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#steps"
												href="#stepOne">Datos de la Clase</a>
										</h4>
									</div>
									<div id="stepOne" class="panel-collapse collapse in">
										<div class="panel-body">
											<div class="form-group">
												<label class="col-lg-3 control-label" for="ac_idclase">ID</label>
												<div class="col-lg-5">
													<input class="form-control" id="ac_idclase" readonly
														name="ac_idclase" type="text" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="ac_seccion">Seccion</label>
												<div class="col-lg-5">
													<select id="ac_seccion" name="idseccion"
														class='form-control'>
														<option value="-1">Seleccione</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="ac_curso">Curso</label>
												<div class="col-lg-5">
													<select id="ac_curso" name="idcurso" class='form-control'>
														<option value="-1">Seleccione</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="ac_docente">Docente</label>
												<div class="col-lg-5">
													<select id="ac_docente" name="iddocente"
														class='form-control'>
														<option value="-1">Seleccione</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="ac_ins">Inscritos</label>
												<div class="col-lg-5">
													<input class="form-control" id="ac_ins" name="ins"
														placeholder="Ingrese los Inscritos" type="number" />
												</div>
											</div>
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
							<span class="glyphicon glyphicon-ok-sign"></span> Eliminar Clase
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
		$(document).ready(
				function() {
					$('#tableClase').DataTable();
					$.getJSON("getAllCurso", {}, function(data, q, t) {
						$.each(data, function(index, item) {
							$("#reg_curso").append(
									"<option value="+item.idcurso+">"
											+ item.nombre + "</option>");
							$("#ac_curso").append(
									"<option value="+item.idcurso+">"
											+ item.nombre + "</option>");
						});
					});
					$.getJSON("getAllSeccion", {}, function(data, q, t) {
						$.each(data, function(index, item) {
							$("#reg_seccion").append(
									"<option value="+item.idseccion+">"
											+ item.codigo + "</option>");
							$("#ac_seccion").append(
									"<option value="+item.idseccion+">"
											+ item.codigo + "</option>");
						});
					});
					$.getJSON("getAllDocente", {}, function(data, q, t) {
						$.each(data, function(index, item) {
							$("#reg_docente").append(
									"<option value="+item.iddocente+">"
											+ item.nombre + "</option>");
							$("#ac_docente").append(
									"<option value="+item.iddocente+">"
											+ item.nombre + "</option>");
						});
					});
				});
		function registrar() {
			$('#idModalRegistra').modal("show");
		}
		function editar(id, sec, cur, doc, ins) {
			$('#ac_idclase').val(id);
			$('#ac_seccion').val(sec);
			$('#ac_curso').val(cur);
			$('#ac_docente').val(doc);
			$('#ac_ins').val(ins);
			$('#idModalActualiza').modal("show");
		}
		function eliminar(idclase) {
			$('#id_elimina').val(idclase);
			$('#idFormElimina').submit();
		}
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
