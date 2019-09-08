package br.com.livrariaspring.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class JPAConfiguration {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		factoryBean.setJpaVendorAdapter(vendorAdapter);

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("root");
		dataSource.setPassword("12345");
		dataSource.setUrl("jdbc:mysql://localhost:3306/livrariaspring");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

		factoryBean.setDataSource(dataSource);

		Properties propiedades = new Properties();
		propiedades.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
		propiedades.setProperty("hibernate.show_sql", "true");
		propiedades.setProperty("hibernate.hbm2ddl.auto", "create");

		factoryBean.setJpaProperties(propiedades);
		factoryBean.setPackagesToScan("br.com.livrariaspring.models");

		return factoryBean;

	}

	  @Bean
	    public JpaTransactionManager transactionManager(EntityManagerFactory emf){
	        return new JpaTransactionManager(emf);
	    }

}
