package com.hifi.thattukada.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	
	
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    	System.out.println(" \n\n -- CONFIGURATIOn START -- \n \n");
        configurer.enable();
    }
    /*      	with reference to http://fruzenshtein.com/spring-mvc-hibernate-maven-crud/
     */
  /*  private Properties hibProperties() {
        	Properties properties = new Properties();
            properties.put("hibernate.show_sql", "true");
            properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect ");
            return properties;
    } */
        
    @Bean
    public InternalResourceViewResolver viewResolver() {
    	System.out.println(" \n\n -- ADDING VIEW RESOLVER -- \n \n");
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
