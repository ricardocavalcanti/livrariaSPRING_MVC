package br.com.livrariaspring.conf;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
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

	//METODO PARA CONFIGURAR MENSAGENS ERRO DA TELA
	@Bean
	public MessageSource messageSource() {

		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(1);
		
		return messageSource;
		

	}
	
   //CONVERTENDO DATAS	
//   @Bean
//	public FormattingConversionService mcvConversionService() {
//		
//	   DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
//	   DateFormatterRegistrar registrar = new DateFormatterRegistrar();
//	   
//	   registrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
//	   registrar.registerFormatters(conversionService);
//	   
//	   return conversionService;
//		
//	}
   
   
   @Bean
   public FormattingConversionService mvcConversionService() {
       DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(true);

       DateFormatterRegistrar registrar = new DateFormatterRegistrar();
       registrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
       registrar.registerFormatters(conversionService);

       return conversionService;
   }
}
