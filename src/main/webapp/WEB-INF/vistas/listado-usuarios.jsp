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
					<li><a href='listado-alquileres'>Alquileres</a></li>
					<li class='active'><a href='#'>Usuarios</a></li>
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
			<div class="alert alert-warning" style='margin-top: 20px; margin-bottom: 3em;'>
				<span style="margin-left: 1em; margin-right: 0.5em;" class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>
				Listado de usuarios.
			</div>
			<a class="btn btn-block btn-primary" href="registro-administrador" style='margin-bottom: 2em;'>
				<span style="margin-left: 1em; margin-right: 0.5em;" class="glyphicon glyphicon-user" aria-hidden="true"></span>
				&nbsp;Registrar Administrador
			</a>
			<table class="table table-hover text-center">
				<thead>
					<tr>
						<th class="text-center">E-Mail</th>
						<th class="text-center">Nombre</th>
						<th class="text-center">Cuit</th>
						<th class="text-center">Rol</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${usuariosList}" var="usuarioList">
						<tr>
							<td><c:out value="${usuarioList.email}" /></td>
							<td><c:out value="${usuarioList.nombre}" /></td>
							<td><c:out value="${usuarioList.cuit}" /></td><c:choose>
								<c:when test="${usuarioList.administrador eq true}">
									<td>Administrador</td>
								</c:when>
								<c:when test="${usuarioList.administrador eq false}">
									<td>Cliente</td>
								</c:when>
							</c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</main>
</body>
</html>