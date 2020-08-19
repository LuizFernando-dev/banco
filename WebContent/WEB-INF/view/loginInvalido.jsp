<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>faça seu login</title>
	<link rel="stylesheet" type="text/css" href="resources/css/estilo.css">
	<script type="text/javascript" src="resources/js/funcoes.js"></script>
</head>
<body>
	<h1>Banco Mundial</h1><br>
	<form action="/BancoMundial/loginConta" id="login" method="post">
		<p>CPF: <input type="text" name="cpf"></p>
		<p>Senha: <input type="password" name="verificaSenha"></p>
		<p><input type="submit" name="enviar" value="Entrar"></p>
	</form>
	<h3>Senha ou CPF incorreto, tente novamente</h3>
	esqueceu a senha? <button onclick="mudarSenha()" id="btn-senha">redefinir senha</button>
	<form action="/BancoMundial/mudarSenha" id="mudarSenha" class="esconde" method="post">
	Seu CPF:<input type="text" placeholder="digite o cpf cadastrado" name="cpf">
	Nova Senha:<input type="password" placeholder="nova senha" name="senha"><input type="submit" value="Salvar">
	</form>
</body>
</html>