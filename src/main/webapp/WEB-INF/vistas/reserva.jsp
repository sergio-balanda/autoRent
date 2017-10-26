<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reserva</title>
</head>
<body>
	<p>La idea seria que muestra los autos en un option, un input con
		el valor de una sucursal el id, y los datos de la reserva.</p>
	<form:form>
		<div class="col-md-6">
			<div class="form-group">
				<select class="form-control" required="required">
					<option value="">Seleccione auto</option>
					<c:forEach items="${vehiculos}" var="vehiculo">
						<option value="<c:out value="${vehiculo.idVehiculo}"/>"><c:out
								value="${vehiculo.modelo}" /></option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<a href="/" class="btn btn-danger">Cancelar</a>
				<button class="btn btn-success" name="submit" type="submit"
					value="guardar">Guardar</button>
			</div>
	</form:form>
</body>
</html>