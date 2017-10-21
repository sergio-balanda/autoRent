<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Pasajeros</title>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
<body>
	<div class="page-header">
		<h1 class="text-center">Empezar con la reserva</h1>
	</div>
	<div class="container">
		<div class="row">
			<div class="col">
				<form:form action="reservar" method="post" modelAttribute="vehiculos">
					
					<div class="form-group">
                            <span class="">Cantidad de personas</span>
                            <form:select path="cantidadDePersonas">
                                <c:forEach varStatus="i" begin="1" end="5">
                                    <form:option value="${i.index}">${i.index}</form:option>
                                </c:forEach>
                            </form:select>
                     </div>
					
					
					<button type="submit" class="btn btn-primary">Enviar</button>
				</form:form>
			</div>
		</div>
	</div>
	<hr>	
	<div class="row">
		<div class="alert alert-success">
		  funciona con <strong>2 y 3</strong>
		</div>
	</div>
	
</body>
</html>