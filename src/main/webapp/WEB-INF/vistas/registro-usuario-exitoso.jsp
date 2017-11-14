<%@include file='../../includes/head.jsp'%>
<title>Registro ok</title>
</head>
</head>
<body>
	<div class="jumbotron">
		<h1>Welcome ${username}</h1>
		<p>Bootstrap is the most popular HTML, CSS, and JS framework for
			developing responsive, mobile-first projects on the web.</p>
	</div>

	<div class="container">
		<p>Registro exitoso</p>
		<p>${usermail}</p>
		<a href="login?email=<c:out value="${usermail}"/>"
			class="btn btn-primary">Ingresar con los datos de su cuenta</a>
	</div>
</body>
</html>