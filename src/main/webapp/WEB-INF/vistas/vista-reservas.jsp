<%@include file='../../includes/head.jsp'%>
<title>Lista de reservas</title>
</head>
<body>

	<c:set var="usuario" value="${usuario}" scope="session" />
	<c:if
		test="${not empty usuario.administrador and not usuario.administrador}">
		<c:set var="inicio" value="login" />
	</c:if>
	<c:if
		test="${not empty usuario.administrador and usuario.administrador}">
		<div class="container">
			<header class='page-header'>
				<div class="container-fluid bg-1">
					<img src="img/logo.jpg" class="img-responsive"
						style="display: inline" alt="" width="100" height="100">
					<h1 class="margin" style="display: inline; margin-left: 100px">Auto
						Rent</h1>
					<p class="text-right text-muted">
					<b>Usuario:</b> ${usuario.nombre} para salir click <a href="logout">aqu&iacute;.</a>
				</p>
				</div>
				<h1>Zona de Admininistracion</h1>
			</header>
			<div class="panel-group">
				<div class="panel panel-default">
					<div class="panel-heading">Lista de reservas</div>
					<div class="panel-body">
						<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>Reserva</th>
								<th>Costo</th>
								<th>Fecha inicio</th>
								<th>Fecha fin</th>
								<th>Ver Reserva</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${reservas}" var="reserva" >
								<tr>
						
									<td><c:out value="${reserva.idReserva}" /></td>
									<td><c:out value="${reserva.costoOrigen}" /></td>
									<td><c:out value="${reserva.fechaInicio}" /></td>
									<td><c:out value="${reserva.fechaFin}" /></td>
									<td><a href='devolver-id-reserva?reserva=<c:out value="${reserva.idReserva}" />'class="btn btn-primary" role="button">Seleccionar</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</div>
				</div>
			</div>
		</div>
	</c:if>
</body>
</html>