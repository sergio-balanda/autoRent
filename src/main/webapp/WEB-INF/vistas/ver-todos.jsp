<%@include file='../../includes/head.jsp' %>
<title>Vehiculos</title>
</head>
<body>
	<c:set var="usuario" value="${usuario}" scope="session"/>
	<c:if test="${not empty usuario}">
		<p class="text-right text-muted"><b>Usuario:<b> ${usuario.nombre} para salir click click <a href="logout">aqu&iacute;.</a></p>
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
				<div class="panel-heading">Ver todos las reservas</div>
				<div class="panel-body">
					<form action="generar-reserva" method="GET">
					<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>id</th>
								<th>costo</th>
								<th>fechainicio</th>
								<th>fechafin</th>
							</tr>
						</thead>
						<tbody>
							<!--<c:set var="id_vehiculo" value="${0}" />-->
							<c:forEach items="${reserva}" var="reservas" >
								<tr>
									<td><c:out value="${reservas.idReserva}" /></td>
									<td><c:out value="${reservas.costoOrigen}" /></td>
									<td><c:out value="${reservas.fechaInicio}" /></td>
									<td><c:out value="${reservas.fechaFin}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</form>
					<a href="pasajeros" class="btn btn-info">Volver</a>
				</div>
			</div>
		</div>
	</div>
</body>

									
									
									
									
									
									