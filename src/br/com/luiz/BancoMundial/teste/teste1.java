package br.com.luiz.BancoMundial.teste;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class teste1 {
	
	@DateTimeFormat(pattern="dd/mm/yyy")
	private static Calendar data = Calendar.getInstance();
	
	public static void main(String[] args) {
		
		String nome = "123";
		
		System.out.println(nome.length());
		
		
		
		
		
		System.out.println(data.getTimeZone());
		
	}
	

}
