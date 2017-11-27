<%@include file='../../includes/head.jsp'%>
<title>Usuario</title>
</head>
<body>
	<c:set var="usuario" value="${usuario}" scope="session" />
	<c:if
		test="${not empty usuario.administrador and not usuario.administrador}">
		<c:set var="inicio" value="login" />
	</c:if>
	<c:if test="${not empty usuario}">

		<br>
		<div class="container">
			<div class="row">
				<div class="text-right">
					<A href="logout">Logout</A> <br>
				</div>

				<div
					class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">

					<div class="page-header">
						<h3>Datos de usuario.</h3>
					</div>
					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">${usuario.nombre}</h3>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-3 col-lg-3 " align="center">
									<img alt="User Pic" src="img/logo.jpg"
										class="img-circle img-responsive">
								</div>

								<div class=" col-md-9 col-lg-9 ">
									<table class="table table-user-information">
										<tbody>
											<tr>
												<td>CUIT:</td>
												<td>${usuario.cuit}</td>
											</tr>
											<tr>
												<td>Email:</td>
												<td>${usuario.email}</td>
											</tr>
											<tr>
												<td>Puntos:</td>
												<td>${usuario.puntos}</td>
											</tr>


										</tbody>
									</table>

								</div>
							</div>
						</div>
						<div class="panel-footer text-center">
							<a href="index" class="btn btn-danger">Volver</a>
						</div>

					</div>
				</div>
			</div>
		</div>
	</c:if>

</body>
</html>