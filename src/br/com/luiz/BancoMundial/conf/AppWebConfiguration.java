package br.com.luiz.BancoMundial.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.luiz.BancoMundial.controller.HomeController;

@EnableWebMvc
@ComponentScan(basePackageClasses = {HomeController.class})
public class AppWebConfiguration  extends WebMvcConfigurerAdapter{
	
	@Bean
	public InternalResourceViewResolver confJSP() {
		InternalResourceViewResolver ir = new InternalResourceViewResolver();
		ir.setPrefix("WEB-INF/view/");
		ir.setSuffix(".jsp");
		return ir;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
}
