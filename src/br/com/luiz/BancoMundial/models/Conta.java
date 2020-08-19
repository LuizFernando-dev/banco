package br.com.luiz.BancoMundial.models;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;

@Entity
public class Conta {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String senha;
	private String titular;
	private double saldo = 0;
	private String cpf;
	private static int agencia = 1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitular() {
		return this.titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public static int getAgencia() {
		return agencia;
	}

	public static void setAgencia(int agencia) {
		Conta.agencia = agencia;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public void operacao(double valor,String tipo) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bancomundial");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Movimentacao mv = new Movimentacao();
		
		if(tipo.contains("saque")) {
			
			mv.setDescricao("Saque");
			mv.setValor(valor);
			mv.setConta(this);
			if(valor > 0 && valor <= saldo)  {
				em.find(Conta.class, id).setSaldo(this.saldo - valor);
				em.persist(mv);
			}
		}else {
			if(tipo.contains("deposito")) {
				mv.setDescricao("Deposito");
				mv.setValor(valor);
				mv.setConta(this);
				if(valor > 0) {
					em.find(Conta.class, id).setSaldo(this.saldo + valor);
					em.persist(mv);
				}
			}
		
		
		}
		
		em.getTransaction().commit();
	}
	
	public void transferir(int destino, double valor) {
		Conta c = new Conta();
		Movimentacao mv = new Movimentacao();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bancomundial");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		mv.setDescricao("Transferencia");
		mv.setValor(valor);
		mv.setConta(this);
		
		if(saldo > valor) {
			c = em.find(Conta.class, destino);
			c.setSaldo(c.getSaldo() + valor);
			em.find(Conta.class, id).setSaldo(saldo - valor);
			em.persist(mv);
			
			em.getTransaction().commit();
		}
	}
	
	public void atualizar(int id, String cpfNovo, String nome) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bancomundial");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Conta c = em.find(Conta.class, id);
		c.setCpf(cpfNovo);
		c.setTitular(nome);
		em.getTransaction().commit();
		
		
	}
	
	public boolean senhaEhValida() {
		if(senha.length() >= 6) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean verificaSenha(String senha) {
		if(this.senha.contains(senha)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean cpfEhValido(String cpf) {
		
		System.out.println("tamanho do cpf: "+cpf.length());
		if(cpf.length() != 11 ) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean mudarSenha(String senha) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bancomundial");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.find(Conta.class, id).setSenha(senha);
		this.senha = senha;
		em.getTransaction().commit();
		
		if(this.senha.contains(senha)) {
			return true;
		}else {
			return false;
		}
		
	}

}
