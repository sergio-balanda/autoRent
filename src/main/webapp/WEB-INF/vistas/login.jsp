<%@include file='../../includes/head.jsp'%>
<title>Login</title>
</head>
<body>
	<div class="container">
		<br>
		<div class="card">
			<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="page-header text-center">
					<h1><a href="index">AutoRent</a> Login</h1>
				</div>
			</div>	
			</div>
			<div class="row">

				<div class="col-md-4 col-md-offset-4">

					<form:form action="confimar-login" method="POST"
						modelAttribute="usuario">
						<div class="form-group">
							<label for="email">E-Mail</label>
							<form:input path="email" id="email" type="email"
								class="form-control" />
						</div>
						<div class="form-group">
							<label for="password">Password</label>
							<form:input path="password" type="password" id="password"
								class="form-control" />
						</div>
						<div class="form-group text-center">
							<a href="index" class="btn btn-lg btn-danger">Cancelar</a>
							<button class="btn btn-lg btn-primary" name="submit"
								type="submit" value="login">Ingresar</button>

						</div>
					</form:form>
					<br>
					<p class="text-center text-muted">No tienes una cuenta, registrate haciendo click <a href="registro-usuario">aqu&iacute;.</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>