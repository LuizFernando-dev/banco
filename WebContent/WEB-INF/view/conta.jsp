<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Banco Mundial</title>
	<script type="text/javascript" src="resources/js/funcoes.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/css/estilo.css">
</head>
<body>
	<div>${msg }</div>
	<h1>Bem vindo ${conta.titular } ao banco Mundial!</h1>
	<p>Saldo:${conta.saldo } </p><br>
	<p>Numero da conta:${conta.id } </p><br>
	<p>Agencia: 1 </p> <br>
	<p>Titular: ${conta.titular}</p><br>
	
	<button onclick="sacar()">Sacar</button><br>
	<button onclick="depositar()">Depositar</button><br>
	<button onclick="transferir()">Transferir</button><br>
	<button onclick="atualizar()">Atualizar</button><br>
	<div id="historico">
		<form action="/BancoMundial/historico">
			<input type="hidden" value="${conta.cpf }" name="cpf"><input type="submit" value="ver historico">
		</form>
	</div>
	
	
	<div id="depositar" class="esconde">
		<form action="/BancoMundial/operacoes" method="post">
			<input type="hidden" value="deposito" name="tipo">
			<input type="hidden" value="${conta.cpf }" name="cpf">
			R$:<input type="number" placeholder="Valor do deposito: " name="valor"><input type="submit" value="depositar agora">
		</form>
	</div>
	
	<div id="saque" class="esconde">
		<form action="/BancoMundial/operacoes" method="post">
			<input type="hidden" value="saque" name="tipo">
			<input type="hidden" value="${conta.cpf }" name="cpf">
			R$:<input type="number" placeholder="Valor do saque: " name="valor"><input type="submit" value="Sacar">
		</form>
	</div>
	
	<div id="transferir" class="esconde">
		<form action="/BancoMundial/transferir">
			<input type="text" placeholder="CPF destino: " name="destino">
			<input type="hidden" value="${conta.cpf }" name="cpf">
			R$:<input type="number" placeholder="Valor do saque: " name="valor"><input type="submit" value="Sacar">
		</form>
	</div>
	
	<div id="sair">
		<form action="/BancoMundial/">
			<input type="submit" value="Sair">
		</form>
	</div>
	
	<div id="atualizar" class="esconde">
		<form action="/BancoMundial/atualizar">
			<input type="hidden" value="${conta.cpf }" name="id">
			<input type="text" placeholder="Nome:" value="${conta.titular }" name="nome">
			<input type="text" placeholder="CPF:" value="${conta.cpf }" name="cpf">
			<input type="submit" value="Atualizar dados">
		</form>
	</div> 
	
	
</body>
</html>