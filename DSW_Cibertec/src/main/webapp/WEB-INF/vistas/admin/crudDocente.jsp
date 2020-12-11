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
		<h3>Crud de Docente</h3>
		<div class="col-md-23">
			<form id="idFormElimina" action="eliminarDocente">
				<input type="hidden" id="id_elimina" name="idalumno">
			</form>

			<form accept-charset="UTF-8" action="filtrarDocente"
				class="simple_form" id="defaultForm2" method="post">
				<div class="row" style="height: 70px">
					<div class="col-md-2">
						<input class="form-control" id="id_nonbre_filtro" name="nom"
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
										<th>DNI</th>
										<th>Correo</th>
										<th>Direccion</th>
										<th>Fec. Nac.</th>
										<th>Telefono</th>
										<th>Actualiza</th>
										<th>Elimina</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${sessionScope.docente}" var="x">
										<tr>
											<td>${x.iddocente}</td>
											<td>${x.nombre}</td>
											<td>${x.dni}</td>
											<td>${x.correo}</td>
											<td>${x.direccion}</td>
											<td><fmt:formatDate value="${x.fecnac}"
													pattern="yyyy-MM-dd" /></td>
											<td>${x.telefono}</td>
											<td>
												<button type='button' data-toggle='modal'
													onclick="editar('${x.iddocente}','${x.nombre}','${x.dni}','${x.correo}','${x.direccion}','<fmt:formatDate value="${x.fecnac}" pattern="yyyy-MM-dd"/>','${x.telefono}','${x.usuario.idusuario}','${x.usuario.usuario}','${x.usuario.password}','${x.usuario.credencial}');"
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
													onclick="eliminar('${x.iddocente}');"
													class='btn btn-success'>
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
							Docente
						</h4>
					</div>
					<div class="modal-body" style="padding: 20px 10px;">
						<form id="id_form_registra" accept-charset="UTF-8"
							action="registrarDocente" class="form-horizontal" method="post">
							<div class="panel-group" id="steps">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#steps"
												href="#stepOne">Datos del Docente</a>
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
												<label class="col-lg-3 control-label" for="reg_dni">DNI</label>
												<div class="col-lg-5">
													<input class="form-control" id="reg_dni" name="dni"
														placeholder="Ingrese el DNI" type="text" maxlength="8" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="reg_correo">Correo</label>
												<div class="col-lg-5">
													<input class="form-control" id="reg_correo" name="correo"
														placeholder="Ingrese el correo" type="text" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="reg_direc">Direccion</label>
												<div class="col-lg-5">
													<input class="form-control" id="reg_direc" name="direccion"
														placeholder="Ingrese la direccion" type="text" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="reg_fecnac">Fecha
													de Nac.</label>
												<div class="col-lg-5">
													<input class="form-control" id="reg_fecnac" name="fecnac"
														placeholder="Ingrese la fecha de nacimiento" type="date" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="reg_telefono">Telefono</label>
												<div class="col-lg-5">
													<input class="form-control" id="reg_telefono"
														name="telefono" placeholder="Ingrese el telefono"
														type="text" />
												</div>
											</div>
											<input name="iddocente" type="hidden" /> <input
												name="usuario.idusuario" type="hidden" /> <input
												name="usuario.credencial" type="hidden" /> <input
												name="usuario.password" type="hidden" /> <input
												name="usuario.usuario" type="hidden" />
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
							Docente
						</h4>
					</div>
					<div class="modal-body" style="padding: 20px 10px;">
						<form id="id_form_actualiza" accept-charset="UTF-8"
							action="actualizarDocente" class="form-horizontal" method="post">
							<div class="panel-group" id="steps">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#steps"
												href="#stepOne">Datos del Docente</a>
										</h4>
									</div>
									<div id="stepOne" class="panel-collapse collapse in">
										<div class="panel-body">
											<div class="form-group">
												<label class="col-lg-3 control-label" for="ac_iddocennte">ID</label>
												<div class="col-lg-5">
													<input class="form-control" id="ac_iddocennte" readonly
														name="iddocente" type="text" />
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
												<label class="col-lg-3 control-label" for="ac_dni">DNI</label>
												<div class="col-lg-5">
													<input class="form-control" id="ac_dni" name="dni"
														placeholder="Ingrese el DNI" type="text" maxlength="8" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="ac_correo">Correo</label>
												<div class="col-lg-5">
													<input class="form-control" id="ac_correo" name="correo"
														placeholder="Ingrese el correo" type="email" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="ac_direccion">Direccion</label>
												<div class="col-lg-5">
													<input class="form-control" id="ac_direccion"
														name="direccion" placeholder="Ingrese la direccion"
														type="text" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="ac_fecnac">Fecha
													de Nacimiento</label>
												<div class="col-lg-5">
													<input class="form-control" id="ac_fecnac" name="fecnac"
														placeholder="Ingrese la fecha de nacimiento" type="text" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="ac_telefono">Telefono</label>
												<div class="col-lg-5">
													<input class="form-control" id="ac_telefono"
														name="telefono" placeholder="Ingrese el telefono"
														type="text" />
												</div>
											</div>
											<input name="usuario.idusuario" id="ac_idusuario"
												type="hidden" /> <input name="usuario.credencial"
												id="ac_credencial" type="hidden" /> <input
												name="usuario.password" id="ac_password" type="hidden" /> <input
												name="usuario.usuario" id="ac_usuario" type="hidden" />
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
							Docente
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
		function editar(id, nombre, dni, cor, direc, fecnac, tel, idu, usu,
				con, cre) {
			$('#ac_iddocennte').val(id);
			$('#ac_nombre').val(nombre);
			$('#ac_dni').val(dni);
			$('#ac_correo').val(cor);
			$('#ac_direccion').val(direc);
			$('#ac_fecnac').val(fecnac);
			$('#ac_telefono').val(tel);
			$('#ac_idusuario').val(idu);
			$('#ac_usuario').val(usu);
			$('#ac_password').val(con);
			$('#ac_credencial').val(cre);
			$('#idModalActualiza').modal("show");
		}
		function eliminar(iddocente) {
			$('#id_elimina').val(iddocente);
			$('#idFormElimina').submit();
		}
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
