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
					<li><a href='#'>Sucursales</a></li>
					<li><a href='vehiculos'>Vehiculos</a></li>
					<li><a href='#'>Accesorios</a></li>
					<li><a href='#'>Servicios</a></li>
				</ul>
				<ul class='nav navbar-nav navbar-right'>
					<li><a href='#'><span class='glyphicon glyphicon-user'></span>
							Registrarse</a></li>
					<li><a href='login'><span class='glyphicon glyphicon-log-in'></span>
							Login</a></li>
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
				<form action='vehiculos' method='GET'>
					<h1 style='margin-bottom: 20px;'>
						<b>Alquiler de autom&oacute;viles</b>
					</h1>
					<div class='container-fluid text-left'>
						<label for='pasajeros'>Cantidad de pasajeros:</label>
						<select	class='form-control' id='pasajeros' name='pasajeros' required>
							<c:forEach var='p' begin='1' end='${maximaCantidadPasajeros}'>
								<option value='${p}'>${p}</option>
							</c:forEach>
						</select>
					</div>
					<br>
					<div class='container-fluid text-left'>
						<label for='sucursal'>Sucursal de retiro:</label> 
						<select	class='form-control' id='sucursal' name='sucursal' required>
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
					<div class='alert alert-danger' style='display: none; margin: 20px 0px;' id='error'>
						<strong>Error!</strong><br> La fecha del campo 'Reservar desde' no
						puede ser mayor que la del campo 'Reservar hasta'.
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