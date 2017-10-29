<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Pasajeros</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<header class='page-header'>
			<div class="container-fluid bg-1">
				<img src="img/logo.jpg" class="img-responsive"
					style="display: inline" alt="" width="100" height="100">
				<h1 class="margin" style="display: inline; margin-left: 100px">Auto
					Rent</h1>
			</div>
		</header>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">Seleccione Cantidad de Pasajeros:</div>
				<div class="panel-body">
					<form action="vehiculos" method="GET">
						<div class="form-group">
							<div class="row">
								<div class="col-sm-4">
									<label for="sel1">Cantidad de pasajeros:</label> 
									<select	class="form-control" id="sel1" name="cantidad">
										<c:forEach var="i" begin="1" end="${max}">
											<option value="${i}">${i}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-sm-4">
									<label for="sel1">Sucursal de retiro:</label> 
									<select class="form-control" id="sel2" name="sucursal">
										<c:forEach var="s" items="${sucursal}">
											<option value="${s.ciudad}">${s.ciudad}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="row">
								<div class="col-sm-4">
									<label for="fch_desde">Reserva desde:</label> 
									<input type="date" name="fch_desde" class="form-control"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="row">
								<div class="col-sm-4">
									<label for="fch_hasta">Reserva hasta:</label> 
									<input type="date" name="fch_hasta" class="form-control"/>
								</div>
							</div>
						</div>

						<button type="submit" class="btn btn-primary">Enviar</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>