<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
	<form action="/spring-casadocodigo/produtos" method="POST">
	    <div class="form-group">
	        <label>Título</label>
	        <input type="text" name="titulo" />
	    </div>
	    <div class="form-group">
	        <label>Descrição</label>
	        <textarea rows="10" cols="20" name="descricao"></textarea>
	    </div>
	    <div class="form-group">
	        <label>Páginas</label>
	        <input type="text" name="paginas" />
	    </div>
	    
	    <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
		    <div class="form-group">
		        <label>${tipoPreco}</label>
		        <input type="text" name="precos[${status.index}].valor">
		        <input type="hidden" name="precos[${status.index}].tipo" value="${tipoPreco}">
		    </div>
		</c:forEach>
		
	    <button type="submit">Cadastrar</button>
	</form>
</div>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>