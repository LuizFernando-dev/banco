package br.com.luiz.BancoMundial.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.luiz.BancoMundial.models.ConsultaContas;
import br.com.luiz.BancoMundial.models.Conta;
import br.com.luiz.BancoMundial.models.Movimentacao;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/cadastro")
	public String cadastro(Conta conta, RedirectAttributes redirect) {
		ConsultaContas cc = new ConsultaContas();
		if(cc.consultaCpf(conta.getCpf())){
			if(conta.senhaEhValida() && conta.cpfEhValido(conta.getCpf())) {
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("bancomundial");
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				em.persist(conta);
				em.getTransaction().commit();
				
				redirect.addFlashAttribute("msg", "cadastro feito com sucesso, agora faça seu login abaixo: ");
				return "redirect:login";
				
				
			}else {
				redirect.addFlashAttribute("msg", "Erro ao cadastrar usuario verique seus dados e tente novamente ");
				return "redirect:login";
			}
		}
		
		return "redirect:login";
	}
	
	@RequestMapping("/loginConta")
	public ModelAndView conta(String cpf, String verificaSenha, HttpSession session) {
		Conta c = new Conta();
		ConsultaContas cc = new ConsultaContas();
		c = cc.consultaConta(cpf);
		System.out.println(cpf);
		if(c.getSenha().equals(verificaSenha)) {
			ModelAndView mv = new ModelAndView("/conta");
			mv.addObject("conta", c);
			session.setAttribute("logado", c);
			return mv;
		}
		
		ModelAndView mv = new ModelAndView("/loginInvalido");
		
		return mv;
		
	}

	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	

	
	@RequestMapping("/operacoes")
	public ModelAndView depositar(String cpf, double valor, String tipo, RedirectAttributes redirect) {
		Conta c = new Conta();
		ConsultaContas cc = new ConsultaContas();
		c = cc.consultaConta(cpf);
			
		c.operacao(valor, tipo);
		
		redirect.addFlashAttribute("msg", "operação realizada com sucesso");
		
		return new ModelAndView("redirect:loginConta?cpf="+cpf+"&verificaSenha="+c.getSenha());
		
	}
	
	
	@RequestMapping("/transferir")
	public String transferir(String cpf, double valor, String destino) {
		Conta c = new Conta();
		Conta contaDestino = new Conta();
		ConsultaContas cc = new ConsultaContas();
		c = cc.consultaConta(cpf);
		contaDestino = cc.consultaConta(destino);
	
			
		c.transferir(contaDestino.getId(), valor);
	
		return "redirect:loginConta?cpf"+cpf+"&verificaSenha="+c.getSenha();
		
	}
	
	@RequestMapping("/atualizar")
	public String atualizar(String nome, String id, String cpf, RedirectAttributes redirect) {
		ConsultaContas cc = new ConsultaContas();
		Conta c = cc.consultaConta(id);
		c.atualizar(c.getId(), cpf, nome);
		
		redirect.addFlashAttribute("msg", "dados atualizados com sucesso!");
		
		return "redirect:loginConta?cpf"+cpf+"&verificaSenha="+c.getSenha();
		
	}
	
	@RequestMapping("/historico")
	public ModelAndView historico(String cpf) {
		
		ConsultaContas cc = new ConsultaContas();
		
		List<Movimentacao> lista = cc.consultaMovimentacoes(cpf);
		
		ModelAndView mav = new ModelAndView("/historico");
		mav.addObject("lista",lista);
		
		return mav;
	}
	
	@RequestMapping("/mudarSenha")
	public String mudaSenha(String cpf, String senha, RedirectAttributes redirect) {
		ConsultaContas cc = new ConsultaContas();
		Conta c = cc.consultaConta(cpf);
		if(c.mudarSenha(senha)) {
			return "login";
		}else {
			redirect.addFlashAttribute("msg", "erro ao redefinir senha");
			return "login";
		}
	}
	

}
