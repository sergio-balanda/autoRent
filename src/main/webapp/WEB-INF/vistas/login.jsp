<%@include file='../../includes/head.jsp'%>
</head>
<body class='bkgd'>
	<header class='page-header'>
		<nav class='navbar navbar-inverse navbar-fixed-top'>
			<div class='container-fluid'>
				<div class='navbar-header'>
					<a class='navbar-brand' href='index'>AutoRent</a>
				</div>
				<ul class='nav navbar-nav'>
					<li><a href='index'>Home</a></li>
					<li class='disabled'><a href='#'>Sucursales</a></li>
					<li><a href='listado-vehiculos'>Vehiculos</a></li>
					<li class='disabled'><a href='#'>Accesorios</a></li>
					<li class='disabled'><a href='#'>Servicios</a></li>
				</ul>
				<ul class='nav navbar-nav navbar-right'>
					<c:set var="usuario" value="${usuario}" scope="session" />
					<c:if test="${empty usuario.nombre}">
						<li><a href='registro-usuario'><span
								class='glyphicon glyphicon-user'></span>&nbsp;Registrarse</a></li>
						<li class='active'><a href='#'><span
								class='glyphicon glyphicon-log-in'></span>&nbsp;Login</a></li>
					</c:if>
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
	<div class="container">
		<br>
		<div class="card" style="background: rgba(255, 255, 255, 0.7);">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<div class="page-header text-center">
						<h1>
							<strong>Login</strong>
						</h1>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<form:form action="confirmar-login" method="POST"
						modelAttribute="usuario">
						<br>
						<div class="form-group">
							<label for="email">E-Mail</label>
							<form:input path="email" id="email" type="email"
								class="form-control" placeholder="ejemplo@ejemplo.com" />
						</div>
						<div class="form-group">
							<label for="password">Password</label>
							<form:input path="password" type="password" id="password"
								class="form-control" placeholder="********" />
						</div>
						<c:if test="${not empty error}">
							<div class="alert alert-danger alert-dismissable">
								<a href="#" class="close" data-dismiss="alert"
									aria-label="close">&times;</a> <strong>${error}!</strong>
							</div>
						</c:if>
						<br>
						<div class="form-group text-center">
							<button class="btn btn-block btn-success" name="submit"
								type="submit" value="login">Ingresar</button>
						</div>
					</form:form>
					<br> <br>
					<p class="text-center">
						<a href="registro-usuario">¿No tienes una cuenta?</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>