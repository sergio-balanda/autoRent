<%@include file='../../includes/head.jsp' %>
</head>
<body class='bgbars'>
	<header class='page-header'>
		<nav class='navbar navbar-inverse navbar-fixed-top'>
			<div class='container-fluid'>
				<div class='navbar-header'>
					<a class='navbar-brand' href='index'>AutoRent</a>
				</div>
				<ul class='nav navbar-nav'>
					<li><a href='index'>Home</a></li>
					<li class='disabled'><a href='#'>Sucursales</a></li>
					<li><a href="listado-vehiculos">Vehiculos</a></li>
					<li class='active'><a href='#'>Accesorios</a></li>
					<li class='disabled'><a href='#'>Servicios</a></li>
				</ul>
				<ul class='nav navbar-nav navbar-right'>
					<c:set var="usuario" value="${usuario}" scope="session" />
					<c:if test="${empty usuario.nombre}">
							<li><a href='registro-usuario'><span class='glyphicon glyphicon-user'></span>Registrarse</a></li>
							<li><a href='login'><span class='glyphicon glyphicon-log-in'></span>Login</a></li>
						</c:if> <c:if test="${not empty usuario.nombre}">
							<li><h5>Bienvenido, ${usuario.nombre} para salir click  <a href="logout">aqu&iacute;.</a></h5></li>
						</c:if>
				</ul>
			</div>
		</nav>
	</header>
	<main style='margin-top: -20px;'>
		<div class='container' style='background: white; margin-top: 20px;'>
			<div class="alert alert-warning" style='margin-top: 20px;'>
				<span style="margin-left: 1em; margin-right: 0.5em;" class="glyphicon glyphicon-plus" aria-hidden="true"></span>
				Se muestran los Accesorios disponibles para su reserva.
			</div>
			<c:forEach items="${accesorios}" var="accesorio" >
				<c:if test="${accesorio.nombre != 'Ninguno'}">
				<div class='col-sm-4 well' style="text-align: center; background: rgba(255, 255, 255, 0.8) !important;">
					<h4><c:out value="${accesorio.nombre}" /></h4>
					<br>
					<img src="${accesorio.imagen}" class="img" style="display: inline" width="220" height="150"/>
					<br>
					<h5>
						<span style="margin-left: 1em; margin-right: 0.5em;" class="glyphicon glyphicon-usd" aria-hidden="true"></span>
						<c:out value="${accesorio.costoDia}" /> por d&iacutea.
					</h5>
				</div>
				</c:if>
			</c:forEach>
		</div>
	</main>
</body>
</html>