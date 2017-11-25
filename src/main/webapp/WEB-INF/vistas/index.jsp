<%@include file='../../includes/head.jsp'%>
<script type='text/javascript'>
	function validar() {
		var desde = document.getElementById('fechaDesde').value;
		var hasta = document.getElementById('fechaHasta').value;
		var error = document.getElementById('error');
		var submit = document.getElementById('submit');
		desde = new Date(desde);
		hasta = new Date(hasta);
		if (desde > hasta) {
			submit.disabled = true;
			error.style.display = 'block';
		} else {
			submit.disabled = false;
			error.style.display = 'none';
		}
	}
</script>
</head>
<body class='bkgd'>
	<header class='page-header'>
		<nav class='navbar navbar-inverse navbar-fixed-top'>
			<div class='container-fluid'>
				<div class='navbar-header'>
					<a class='navbar-brand' href='#'>AutoRent</a>
				</div>
				<ul class='nav navbar-nav'>
					<li class='active'><a href='#'>Home</a></li>
					<li class='disabled'><a href='#'>Sucursales</a></li>
					<li><a href='listado-vehiculos'>Vehiculos</a></li>
					<li class='disabled'><a href='#'>Accesorios</a></li>
					<li class='disabled'><a href='#'>Servicios</a></li>
				</ul>
				<ul class='nav navbar-nav navbar-right'>
					<c:set var="usuario" value="${usuario}" scope="session" />
					<c:if test="${empty usuario.nombre}">
						<!--
						<li><a href='registro-usuario'><span class='glyphicon glyphicon-user'></span>Registrarse</a></li>
						<li><a href='login'><span class='glyphicon glyphicon-log-in'></span>Login</a></li>
						-->
						<li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b> <span class="caret"></span></a>
			<ul id="login-dp" class="dropdown-menu">
				<li>
					 <div class="row">
							<div class="col-md-12">
								Login via
								<div class="social-buttons">
									<a href="#" class="btn btn-fb"><i class="fa fa-facebook"></i> Facebook</a>
									<a href="#" class="btn btn-tw"><i class="fa fa-twitter"></i> Twitter</a>
								</div>
                                or
								 <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
										<div class="form-group">
											 <label class="sr-only" for="exampleInputEmail2">Email address</label>
											 <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Email address" required>
										</div>
										<div class="form-group">
											 <label class="sr-only" for="exampleInputPassword2">Password</label>
											 <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password" required>
                                             <div class="help-block text-right"><a href="">Forget the password ?</a></div>
										</div>
										<div class="form-group">
											 <button type="submit" class="btn btn-primary btn-block">Sign in</button>
										</div>
										<div class="checkbox">
											 <label>
											 <input type="checkbox"> keep me logged-in
											 </label>
										</div>
								 </form>
							</div>
							<div class="bottom text-center">
								New here ? <a href="#"><b>Join Us</b></a>
							</div>
					 </div>
				</li>
			</ul>
        </li>
					</c:if> <c:if test="${not empty usuario.nombre}">
						<li>
							<h5>Bienvenido, ${usuario.nombre} para salir click <a href="logout">aqu&iacute;.</a></h5>
						</li>
					</c:if>
				</ul>
			</div>
		</nav>
	</header>
	<main>
	<div class='container-fluid text-center'>
		<div class='row content'>
			<div class='col-sm-1 sidenav'></div>
			<div class='col-sm-4 well'
				style='background: rgba(255, 230, 128, 0.8) !important;'>
				<form action='elegir-vehiculo' method='GET'>
					<h1 style='margin-bottom: 20px;'>
						<b>Alquiler de autom&oacute;viles</b>
					</h1>
					<div class='container-fluid text-left'>
						<label for='pasajeros'>Cantidad de pasajeros:</label> <select
							class='form-control' id='pasajeros' name='pasajeros' required>
							<c:forEach var='p' begin='1' end='${maximaCantidadPasajeros}'>
								<option value='${p}'>${p}</option>
							</c:forEach>
						</select>
					</div>
					<br>
					<div class='container-fluid text-left'>
						<label for='sucursal'>Sucursal de retiro:</label> <select
							class='form-control' id='sucursal' name='sucursal' required>
							<c:forEach var='s' items='${sucursal}'>
								<option value='${s.ciudad}'>${s.ciudad}</option>
							</c:forEach>
						</select>
					</div>
					<br>
					<div class='col-sm-6 text-left'>
						<label for='fechaDesde'>Reservar desde:</label> <input type='date'
							onChange='validar()' name='fechaDesde' id='fechaDesde'
							class='form-control' required />
					</div>
					<div class='col-sm-6 text-left'>
						<label for='fechaHasta'>Reservar hasta:</label> <input type='date'
							onChange='validar()' name='fechaHasta' id='fechaHasta'
							class='form-control' required />
					</div>
					<div class='clear'></div>
					<div class='alert alert-danger'
						style='display: none; margin: 20px 0px;' id='error'>
						<strong>Error!</strong><br> La fecha del campo 'Reservar
						desde' no puede ser mayor que la del campo 'Reservar hasta'.
					</div>
					<div class='col-lg-12 text-right' style='margin: 20px 0px;'>
						<button type='submit' class='btn btn-success btn-lg' id='submit'>Enviar</button>
					</div>
					<br>
				</form>
			</div>
		</div>
	</div>
	</main>
</body>
</html>