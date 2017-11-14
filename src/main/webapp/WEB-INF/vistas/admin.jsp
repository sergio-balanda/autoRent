<%@include file='../../includes/head.jsp'%>
<title>Zona admin</title>
</head>
<body>

	<c:set var="usuario" value="${usuario}" scope="session" />
	<c:if
		test="${not empty usuario.administrador and not usuario.administrador}">
		<c:set var="inicio" value="login" />
	</c:if>
	<c:if
		test="${not empty usuario.administrador and usuario.administrador}">
		<div class="jumbotron">
			<div class="container">
				<p class="text-right text-muted">
					<b>Usuario:<b> ${usuario.nombre} para salir click <a
							href="logout">aqu&iacute;.</a>
				</p>

				<h1>Zona Admin</h1>
				<h2>
					ADMIN
					<c:out value="${usuario.nombre}" />
				</h2>
			</div>
		</div>
		<div class="container">
			<p>Cantidad de puntos ${usuario.puntos}</p>
			<p>ID de usuario ${usuario.id}</p>
		</div>
	</c:if>

</body>
</html>