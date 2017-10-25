<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vehiculos</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" >
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
  <h2>Vehiculos con >= cantidad</h2>            
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Patente</th>
        <th>Marca</th>
        <th>Modelo</th>
        <th>Capacidad Pasajeros</th>
        <th>Capacidad Valijas</th>
      </tr>
    </thead>
    <tbody>
     <c:forEach items="${v}" var="vh">
      <tr>
        <td><c:out value="${vh.patente}"/></td>
        <td><c:out value="${vh.marca}"/></td>
        <td><c:out value="${vh.modelo}"/></td>
        <td><c:out value="${vh.capacidadPasajeros}"/></td>
        <td><c:out value="${vh.capacidadValijas}"/></td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>