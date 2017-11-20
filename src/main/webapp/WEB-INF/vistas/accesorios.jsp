<%@include file='../../includes/head.jsp'%>
<title>Accesorios</title>
</head>
<body>

<div class="row">
<div class="col-xs-8 col-xs-offset-2">
<form action="vehiculos" method="POST">
	<div class="form-group">
		<div class="row">
			<div class="col-md-12">	
			<c:forEach var="accesorio" items="${accesorios}">
				<div class="checkbox">
				  <label><input type="checkbox" value="${accesorio.idAccesorio}">${accesorio.nombre} ${accesorio.costoDia}</label>
				</div>
			</c:forEach>
			</div>
		</div>
	</div>
	<button type="submit" class="btn btn-primary" id="submit">Enviar</button>
</form>
</div>
</div>
		como carajo guardar los todos los checkbox que seleccionas.
</body>
</html>