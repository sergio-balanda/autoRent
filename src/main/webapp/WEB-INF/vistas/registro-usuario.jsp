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
						<li class='active'><a href='#'><span class='glyphicon glyphicon-user'></span>&nbsp;Registrarse</a></li>
						<li><a href='login'><span class='glyphicon glyphicon-log-in'></span>&nbsp;Login</a></li>
					</c:if>
					<c:if test="${not empty usuario.nombre}">
						<li style="color: #9d9d9d; padding-top: 1em;">
								Bienvenido, ${usuario.nombre}.
						</li>
						<li><a href='logout'><span class='glyphicon glyphicon-log-out'></span>&nbsp;Logout</a></li>
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
						<h1><strong>Crea tu cuenta</strong></h1>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<form:form action="registrar-usuario" method="POST"
						modelAttribute="usuario">
						<br>
						<div class="form-group">
							<label for="nombre">Nombre y Apellido</label>
							<form:input path="nombre" id="nombre" type="text"
								class="form-control" placeholder="Nombre y Apellido" required="REQUIRED"/>
						</div>
						<div class="form-group">
							<label for="email">E-Mail</label>
							<form:input path="email" id="email" type="email"
								class="form-control" placeholder="ejemplo@ejemplo.com" required="REQUIRED"/>
						</div>
						<div class="form-group">
							<label for="password">Password</label>
							<form:input path="password" type="password" id="password"
								class="form-control" placeholder="********" required="REQUIRED"/>
						</div>
						<div class="form-group">
							<label for="cuit">Cuit</label>
							<form:input path="cuit" type="text" id="cuit"
								class="form-control" placeholder="Cuit" required="REQUIRED"/>
						</div>
						<br>
						<div class="form-group">
							<button type="submit" class="btn btn-block btn-success">
								Registrarse
							</button>
						</div>
					</form:form>
					<br>
					<br>
				</div>
			</div>
		</div>
	</div>
</body>
</html>