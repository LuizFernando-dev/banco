package br.com.luiz.BancoMundial.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.web.servlet.ModelAndView;

public class ConsultaContas {
	public Conta consultaConta(String cpf) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bancomundial");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createNativeQuery("select id from conta");
		List<Integer> contasBanco = q.getResultList();
		int index = contasBanco.get(contasBanco.size() - 1);
		
		Conta c = new Conta();
	
		for (int i = 1; i <= index; i++) {
			c = em.find(Conta.class, i);
			
			if(c != null) {
				if(c.getCpf().contains(cpf)) {
					System.out.println("login aceito");
					return c;
				}
			}		
			
		}
		
		return c;
	}
	
	
	public List<Movimentacao> consultaMovimentacoes(String cpf) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bancomundial");
		EntityManager em = emf.createEntityManager();
	
		
		this.consultaConta(cpf);
		
		Conta conta = this.consultaConta(cpf);
		
		
		String jpql = "select m from Movimentacao m where m.conta = :conta";
		Query query = em.createQuery(jpql);
		query.setParameter("conta", conta);
		
		List<Movimentacao> mv = query.getResultList();
		
		for (int i = 0; i < mv.size(); i++) {
			System.out.println(mv.get(i).getDescricao());
		}
		
		return mv;
	}
	
	public boolean consultaCpf(String cpf) {
		Conta conta = this.consultaConta(cpf);
		System.out.println(conta);
		if(conta.getCpf() != null) {
			return true;
		}else {
			return false;
		}
	 
	
	}
	

}
