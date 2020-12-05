<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
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
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
				<div class="col-12">
					<img class="img-fluid" src="../bannercibertec.png" />
				</div>
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Bienvenido Administrador</h1>
				</div>
				<div class="card-group">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Ultimos Anuncios</h5>
							<p class="card-text">Ultimos Anuncios emitidos por la
								institucion.Enterate las ultimas noticias y mantente informado.</p>
							<p class="card-text">
								<small class="text-muted">Actualizado hace 3 minutos</small>
							</p>
						</div>
					</div>
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Revicion de Notificaciones</h5>
							<p class="card-text">No se olvide de revisar las ultimas
								solicitudes de registro de matricula de los alumnos, es
								importante que sea parte de su trabajo rutinario</p>
							<p class="card-text"></p>
						</div>
					</div>
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Servicios Informaticos</h5>
							<p class="card-text">Contactate con nuestros servicios si
								tienes algun inconveniente en el dia a dia</p>
							<p class="card-text">Servicios informáticos (01) 4192900
								anexo 7777</p>
							<p class="card-text">Aula Virtual aulavirtual@cibertec.pe</p>
							<p class="card-text"></p>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>
</body>
</html>
