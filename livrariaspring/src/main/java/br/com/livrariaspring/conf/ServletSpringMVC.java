package br.com.livrariaspring.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
	
		return null;
		
	}

	//INFORMA AS CLASSE DE CONFIGURACAO DOS CONTROLERS
	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] { AppWebConfiguration.class, JPAConfiguration.class };
		
	}
    
	// INFORMA AO SERVIDOR A PARTIR DE QUE CAMINHO SERA CONFIGURADO ATRAVES DO SPRING
	@Override
	protected String[] getServletMappings() {
		
		System.out.println("ServletSpringMVC");
		
		return new String[] {"/"};
		
	}
	
	

}
