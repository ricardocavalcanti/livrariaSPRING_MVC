package br.com.livrariaspring.conf;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return null;

	}

	// INFORMA AS CLASSE DE CONFIGURACAO DOS CONTROLERS
	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class[] { AppWebConfiguration.class, JPAConfiguration.class };

	}

	// INFORMA AO SERVIDOR A PARTIR DE QUE CAMINHO SERA CONFIGURADO ATRAVES DO
	// SPRING
	@Override
	protected String[] getServletMappings() {

		System.out.println("ServletSpringMVC");

		return new String[] { "/" };

	}

	// CONFIGURANDO UTF-8
	@Override
	protected Filter[] getServletFilters() {

		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");

		return new Filter[] { characterEncodingFilter };

	}

}
