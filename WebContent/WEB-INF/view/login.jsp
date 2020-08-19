<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>faça seu login</title>
	<link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>
	<h1>Banco Mundial</h1><br>
	<div>${msg }</div>
	<fieldset>
	<legend>Faça login na sua conta</legend>
		<form action="/BancoMundial/loginConta" method="post">
			<label for="cpf">CPF: </label>
			<input type="text" name="cpf"><br>
			<label for="verificaSenha">Senha: </label>
			<input type="password" name="verificaSenha">
			<p><input type="submit" name="enviar" value="Entrar"></p>
		</form>
	</fieldset>
	
</body>
</html>