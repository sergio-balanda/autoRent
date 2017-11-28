<%@include file='../../includes/head.jsp'%>
</head>
<body class='bgbars'>
	<header class='page-header'>
		<nav class='navbar navbar-inverse navbar-fixed-top'>
			<div class='container-fluid'>
				<div class='navbar-header'>
					<a class='navbar-brand' href='listado-reservas'>AutoRent</a>
				</div>
				<ul class='nav navbar-nav'>
					<li><a href='listado-reservas'>Reservas</a></li>
					<li class='active'><a href='#'>Alquileres</a></li>
					<li class='disabled'><a href='#'>Usuarios</a></li>
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
			<div class="alert alert-warning" style='margin-top: 20px; margin-bottom: 5em;'>
				<span style="margin-left: 1em; margin-right: 0.5em;" class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>
				Listado de alquileres.
			</div>
			<table class="table table-hover text-center">
				<thead>
					<tr>
						<th class="text-center">C&oacute;digo</th>
						<th class="text-center">Estado</th>
						<th class="text-center">Costo</th>
						<th class="text-center">Acci&oacute;n</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${alquileres}" var="alquiler">
						<tr>
							<td><c:out value="${alquiler.idAlquiler}" /></td>
							<c:choose>
								<c:when test="${alquiler.finalizada eq true}">
									<td>Finalizado</td>
								</c:when>
								<c:when test="${alquiler.finalizada eq false}">
									<td>Vigente</td>
								</c:when>
							</c:choose>
							<td><c:out value="$ ${alquiler.precioFinal}" /></td>
							<td>
								<a href='detalle-alquiler?alquiler=<c:out value="${alquiler.idAlquiler}" />' class="btn btn-primary" role="button">
									Ver Detalle&nbsp;&nbsp;
									<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</main>
</body>
</html>