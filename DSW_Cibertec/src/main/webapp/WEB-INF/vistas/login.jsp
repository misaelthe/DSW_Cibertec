<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrapValidator.js"></script>

<link rel="stylesheet" href="css/form-elements.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrapValidator.css">

 
<title>Intranet Instituto - Cibertec</title>
</head>   
<body>    
        <div class="top-content">
            <div class="inner-bg">
                <div class="container">								
                	<c:if test="${sessionScope.mensaje != null}">
						<div class="alert alert-success fade in" id="success-alert">
							<a href="#" class="close" data-dismiss="alert">&times;</a>
							<strong>${sessionScope.mensaje}</strong>
						</div>
					</c:if>
				    <c:remove var="mensaje" />
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>Ingreso al Login</h3>
                            		<p>Ingrese su usuario y contraseña:</p>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form id="id_form"  action="enviarlogin" method="post" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">Usuario</label>
			                        	<input type="text" name="login" placeholder="Usuario..." class="form-username form-control" id="form-username">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">ContraseÃ±a</label>
			                        	<input type="password" name="password" placeholder="Contraseña..." class="form-password form-control" id="form-password">
			                        </div>
			                        <button type="submit" class="btn" id="validateBtn">Ingresar</button>
			                    </form>
		                    </div>
                        </div>
                    </div>
                    
                </div>
            </div>
            
        </div>
    
<script type="text/javascript">
	$("#success-alert").fadeTo(1000, 500).slideUp(500, function(){$("#success-alert").slideUp(500);});
</script>

<script type="text/javascript">
$(document).ready(function() {
    $('#id_form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	login: {
                validators: {
                    notEmpty: {
                        message: 'El usuario es un campo obligatorio'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'La contraseña es un campo obligatorio'
                    }
                }
            }
        }   
    });
    $('#validateBtn').click(function() {
        $('#id_form').bootstrapValidator('validate');
    });
});
</script>

</body>
</html>