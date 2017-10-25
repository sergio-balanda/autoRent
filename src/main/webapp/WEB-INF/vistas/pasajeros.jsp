<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
				<form action="vehiculos" method="GET">
					
					<div class="form-group">
                            <span class="">Cantidad de personas</span>
                            <select id="cantidad" name="cantidad">
                                <c:forEach var="i" begin="1" end="${max}">
							    	<option value="${i}">${i}</option>
							    </c:forEach>
                            </select>
                     </div>
					
					
					<button type="submit" class="btn btn-primary">Enviar</button>
				</form>
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