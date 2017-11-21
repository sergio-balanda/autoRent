<%@include file='../../includes/head.jsp'%>
<title>Pasajeros</title>
<script type="text/javascript">
	function validar() {
		var desde = document.getElementById('fechaDesde').value;
		var hasta = document.getElementById('fechaHasta').value;
		var error = document.getElementById('error');
		var submit = document.getElementById('submit');
		desde = new Date(desde);
		hasta = new Date(hasta);
		if (desde > hasta) {
			submit.disabled = true;
			error.style.display = "block";
		} else {
			submit.disabled = false;
			error.style.display = "none";
		}
	}
</script>
</head>
<body>
	<c:set var="usuario" value="${usuario}" scope="session"/>
	<c:if test="${not empty usuario}">
		<p class="text-right text-muted"><b>Usuario:<b> <a href="detalle-usuario">${usuario.nombre}</a> para salir click <a href="logout">aqu&iacute;.</a></p>
	</c:if>
	<c:if test="${empty usuario}">
	<p class="text-right text-muted"><a href="login">login</a></p>
	</c:if>
	
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
				<div class="row">
					<div class="col-md-5 col-xs-6">
						<div class="panel-body">
							<form action="vehiculos" method="GET">
								<div class="form-group">
									<div class="row">
										<div class="col-sm-12">
											<label for="sel1">Cantidad de pasajeros:</label> <select
												class="form-control" id="sel1" name="cantidad">
												<c:forEach var="i" begin="1" end="${maximaCantidadVehiculos}">
													<option value="${i}">${i}</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="row">
										<div class="col-md-12">
											<label for="sel1">Sucursal de retiro:</label> <select
												class="form-control" id="sel2" name="sucursal">
												<c:forEach var="s" items="${sucursal}">
													<option value="${s.ciudad}">${s.ciudad}</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="row">
										<div class="col-md-12">
											<label for="fechaDesde">Reserva desde:</label> <input
												type="date" onChange="validar()" name="fechaDesde"
												id="fch_desde" class="form-control" required />
										</div>
									</div>
								</div>


								<div class="form-group">
									<div class="row">
										<div class="col-md-12">
											<label for="fechaHasta">Reserva hasta:</label> <input
												type="date" onChange="validar()" name="fechaHasta"
												id="fch_hasta" class="form-control" required />
										</div>
									</div>
								</div>
								<div class="alert alert-danger" style="display: none;"
									id="error" class=>
									<strong>Error!</strong> La fecha del campo 'Reserva hasta:' no
									puede ser mayor que la del campo 'Reserva desde:'.
								</div>
								<button type="submit" class="btn btn-primary" id="submit">Enviar</button>
							</form> 
						</div>
					</div>


					<div class="col-md-7">
						<img alt="autorent" src="<c:url value="/img/res_car.png"/>"
							class="img-responsive" width="100%" />
					</div>

				</div>

			</div>
		</div>
	</div>
</body>
</html>