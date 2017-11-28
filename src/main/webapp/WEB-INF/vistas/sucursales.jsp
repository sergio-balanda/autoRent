<%@include file='../../includes/head.jsp'%>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAB6-rXJKVrLDnT3yW-MZRzNemS-Ll-GyU&callback=initMap" async defer>
</script>
</head>
<body class='bgbars'>
	<c:if test="${usuario.administrador==true}">
		<c:redirect url="controlReservas" />
	</c:if>
	<header class='page-header'>
		<nav class='navbar navbar-inverse navbar-fixed-top'>
			<div class='container-fluid'>
				<div class='navbar-header'>
					<a class='navbar-brand' href='index'>AutoRent</a>
				</div>
				<ul class='nav navbar-nav'>
					<li ><a href='index'>Home</a></li>
					<li class='active'><a href='#'>Sucursales</a></li>
					<li><a href='listado-vehiculos'>Vehiculos</a></li>
					<li><a href='listado-accesorios'>Accesorios</a></li>
					<li class='disabled'><a href='#'>Servicios</a></li>
				</ul>
				<ul class='nav navbar-nav navbar-right'>
					<c:set var="usuario" value="${usuario}" scope="session" />
					<c:if test="${empty usuario.nombre}">
						<li><a href='registro-usuario'><span class='glyphicon glyphicon-user'></span>&nbsp;Registrarse</a></li>
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
	<main style='margin-top: -20px;'>
		<div class='container' style='background: white; margin-top: 20px; min-height: 709px;'>
			<div class="alert alert-warning" style='margin-top: 20px;'>
				<span style="margin-left: 1em; margin-right: 0.5em;" class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
				En el siguiente mapa pod&eacute;s encontrar nuestras sucursales.
			</div>
			<div id="map"></div>
			<script>
				function initMap() {
					var sucursales = [
						['Jose Bonifacio 846, Capital Federal - Buenos Aires', -34.627652, -58.439621, 1],
						['Rafael Obligado 120, Bariloche - Rio Negro', -41.131931, -71.271800, 2],
						['Alonso de Ubeda 433, Cordoba - Cordoba', -31.361453, -64.196297, 3],
						['Aeropuerto, Iguazu - Misiones', -25.731574, -54.476577, 4],
						['Aeropuerto, Rio Grande - Tierra del Fuego', -53.781544, -67.753519, 5]
					];
					var argentina = {lat: -40.184, lng: -64.884};
					var map = new google.maps.Map(document.getElementById('map'), {
						zoom: 4,
						center: argentina,
						mapTypeId: google.maps.MapTypeId.ROADMAP,
						disableDefaultUI: true,
						fullscreenControl: true,
						zoomControl: true
					});
					var infowindow = new google.maps.InfoWindow();
					var marker, i;
					for (i = 0; i < sucursales.length; i++) {  
						marker = new google.maps.Marker({
							position: new google.maps.LatLng(sucursales[i][1], sucursales[i][2]),
							map: map
						});
						google.maps.event.addListener(marker, 'click', (function(marker, i) {
							return function() {
								infowindow.setContent(sucursales[i][0]);
								infowindow.open(map, marker);
							}
						})(marker, i));
					}
				}
		    </script>
		</div>
	</main>
</body>
</html>