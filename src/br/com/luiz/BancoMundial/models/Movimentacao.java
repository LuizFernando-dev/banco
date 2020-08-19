package br.com.luiz.BancoMundial.models;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Movimentacao {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String descricao;
	private double valor;
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Date data = Calendar.getInstance().getTime();
	@ManyToOne
	private Conta conta;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Conta getConta() {
		return conta;
	}
	
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Movimentação de " + descricao + " no valor de R$: " + valor;
	}
	
	public Date getData() {
		return data;
	}
	
	
}
