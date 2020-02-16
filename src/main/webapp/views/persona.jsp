<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="cargarPersona()">
	<h4>REGISTRAR PERSONA</h4>
	<div>
		<form action="/registrar" method="post">
			<input type="text" name="nombre">
			<button type="submit">REGISTRAR</button>
		</form>
	</div>
	<h4>LISTA</h4>
	<div>
		<c:forEach items="${lista}" var="persona">
			<div>${persona.nombre}</div>
			<span><a href="/eliminar?id=${persona.id}">Eliminar</a></span>
		</c:forEach>
	</div>
	<hr>
	<div>
		<form>
			<input type="text" name="nombre" id="nombre">
			<button type="button" onclick="regpersona()">REGISTRAR</button>
		</form>
	</div>
	<h4>LISTA</h4>
	<div id="lista"></div>
</body>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
	function cargarPersona() {
		$.ajax({
			type : "POST",
			url : "/cargarpersona",
			dataType : "json",
			async : false,
			contentType : "application/json",
			success : function(data) {
				console.log(data);
				//var datos = JSON.parse(data);
				var cadena = '';
				data.forEach(function(val, i) {
					cadena += '<div>' + val.nombre
							+ '</div><span><a href="javascript:void(0)" onclick="elimpersona('+val.id+')">Eliminar</a></span>';
				});

				$("#lista").html(cadena);
			}

		})
	}

	function regpersona() {
		var persona = {
			"nombre" : $("#nombre").val()
		};
		console.log(persona);

		$.ajax({
			type : "POST",
			url : '/regpersona',
			dataType : 'json',
			async : false,
			data : JSON.stringify(persona),
			contentType : 'application/json',
			success : function(data) {
				console.log(data);
				cargarPersona();
			}
		})
	}

	function elimpersona(id) {
		var persona={"id":id};
		$.ajax({
			type : "POST",
			url : '/elimpersona',
			dataType : 'json',
			async : false,
			data : JSON.stringify(persona),
			contentType : 'application/json',
			success : function(data) {
				console.log(data);
				cargarPersona();
			}
		});
	}
</script>
</html>