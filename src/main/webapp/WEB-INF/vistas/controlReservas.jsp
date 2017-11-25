<%@include file='../../includes/head.jsp'%>
<title>Lista de reservas</title>
</head>
<body class='bgbars'>
	<header class='page-header'>
		<nav class='navbar navbar-inverse navbar-fixed-top'>
			<div class='container-fluid'>
				<div class='navbar-header'>
					<a class='navbar-brand' href='#'>AutoRent</a>
				</div>
				<ul class='nav navbar-nav'>
					<li class='active'><a href='#'>Reservas</a></li>
					<li><a href='#'>Alquileres</a></li>
					<li><a href='#'>Usuarios</a></li>
				</ul>
				<ul class='nav navbar-nav navbar-right'>
					<c:set var="usuario" value="${usuario}" scope="session" />
					<c:if test="${not empty usuario.nombre}">
						<li style="color: #9d9d9d; padding-top: 1em;">Bienvenido,
							${usuario.nombre}.</li>
						<li><a href='logout'><span
								class='glyphicon glyphicon-log-out'></span>&nbsp;Logout</a></li>
					</c:if>
				</ul>
			</div>
		</nav>
	</header>
	<main style='margin-top: -20px;'>
		<div class='container' style='background: white; margin-top: 20px; min-height: 709px;'>
			<div class="panel panel-warning" style='margin-top: 20px;'>
				<div class="panel-heading">
					<span style="margin-left: 1em; margin-right: 0.5em;" class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>Lista de reservas
				</div>
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
							<c:forEach items="${reservas}" var="reserva">
								<tr>
									<td><c:out value="${reserva.idReserva}" /></td>
									<td><c:out value="${reserva.costoOrigen}" /></td>
									<td><c:out value="${reserva.fechaInicio}" /></td>
									<td><c:out value="${reserva.fechaFin}" /></td>
									<td><a
										href='detalle-reserva?reserva=<c:out value="${reserva.idReserva}" />'
										class="btn btn-primary" role="button">Seleccionar</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>
</body>
</html>