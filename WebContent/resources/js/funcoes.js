function depositar(){
	var deposito = document.getElementById("depositar");
	deposito.classList.remove("esconde");
	var saque = document.getElementById("saque");
	saque.classList.add("esconde");
	var trans = document.getElementById("transferir");
	trans.classList.add("esconde");
	var atl = document.getElementById("atualizar");
	atl.classList.add("esconde");

}

function sacar(){
	var saque = document.getElementById("saque");
	saque.classList.remove("esconde");
	var dep = document.getElementById("deposito");
	dep.classList.add("esconde");
	var trans = document.getElementById("transferir");
	trans.classList.add("esconde");
	var atl = document.getElementById("atualizar");
	atl.classList.add("esconde");
}

function transferir(){
	var trans = document.getElementById("transferir");
	trans.classList.remove("esconde");
	var dep = document.getElementById("deposito");
	dep.classList.add("esconde");
	var saque = document.getElementById("saque");
	saque.classList.add("esconde");
	var atl = document.getElementById("atualizar");
	atl.classList.add("esconde");
}

function atualizar(){
	var atl = document.getElementById("atualizar");
	atl.classList.remove("esconde");
	var dep = document.getElementById("deposito");
	dep.classList.add("esconde");
	var saque = document.getElementById("saque");
	saque.classList.add("esconde");
	var trans = document.getElementById("transferir");
	trans.classList.add("esconde");
}

function mudarSenha(){
	var form = document.getElementById("mudarSenha");
	form.classList.remove("esconde");
	var formPrincipal = document.getElementById("login");
	formPrincipal.classList.add("esconde");
	var botao = document.getElementById("btn-senha");
	botao.classList.add("esconde");
}