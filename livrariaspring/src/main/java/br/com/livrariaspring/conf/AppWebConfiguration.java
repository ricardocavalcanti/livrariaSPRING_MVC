package br.com.livrariaspring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.livrariaspring.controllers.HomeController;
import br.com.livrariaspring.dao.ProdutoDao;

@EnableWebMvc
@ComponentScan(basePackageClasses = { HomeController.class, ProdutoDao.class })
public class AppWebConfiguration {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {

		System.out.println("AppWebConfiguration");

		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");

		return resolver;

	}

}
