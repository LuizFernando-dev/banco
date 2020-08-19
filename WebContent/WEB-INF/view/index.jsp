<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/estilo.css">
<script type="text/javascript" src="resources/js/index.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>Bem vindo ao banco Mundial!</h1>
	<button onclick="formNovoUsuario()" id="btn">Criar uma conta</button>
	<form action="/BancoMundial/login">
		<input type="submit" id="btn" value="Login">
	</form>
	<form action="/BancoMundial/cadastro" class="esconde" id="form">
		Nome Completo: <input type="text" name="titular"><br> CPF
		: <input type="text" name="cpf"><br> Crie Uma Senha: <input
		type="password" name="senha"><br> <input type="submit"
			name="enviar">
	</form>
</body>
</html>