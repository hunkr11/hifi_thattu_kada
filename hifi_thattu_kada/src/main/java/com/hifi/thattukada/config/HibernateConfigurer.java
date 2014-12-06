package com.hifi.thattukada.config;

import java.util.Properties;

import javax.activation.DataSource;
import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class HibernateConfigurer {
	private static final String PROPERTY_NAME_DATABASE_DRIVER="spring.datasource.driverClassName";	
	private static final String PROPERTY_NAME_DATABASE_URL="spring.datasource.url";
	private static final String PROPERTY_NAME_DATABASE_USERNAME="spring.datasource.username";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD="spring.datasource.password";
	
	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";

    
    @Resource
    private Environment env;
    
    @Bean
    public DataSource dataSource() {
    	
    	System.out.println("\n\n-- HIBERNATE CONFIGURATION DATA SOURCE-- \n\n");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
         
        dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
        dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
        dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
        dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));         
        return (DataSource) dataSource;
    }
     
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
    	System.out.println("\n\n-- LOCAL SESSION FACTORY BEAN-- \n\n");
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource((javax.sql.DataSource) dataSource());
        sessionFactoryBean.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
        sessionFactoryBean.setHibernateProperties(hibProperties());
        return sessionFactoryBean;
    }
     
    private Properties hibProperties() {
        Properties properties = new Properties();
        properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
        return properties; 
    }
     
    @Bean
    public HibernateTransactionManager transactionManager() {
    	System.out.println("\n\n-- TRANSACTION MANAGER-- \n\n");
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
