package com.ashish.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages  = "com.ashish.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	// set up variable to hold the properties
	@Autowired
	private Environment env;
	
	// set up a logger for logs
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	

	// define a bean for ViewResolver()
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	// define a bean for security datasource
	
	@Bean
	public DataSource securityDataSource() {
		
		// create a connection pool
		ComboPooledDataSource securityDataSource = 
				new ComboPooledDataSource();
		// set the jdbc driver class
		
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		// log the connection props
		myLogger.info(">>>> jdbc.url="+env.getProperty("jdbc.url"));
		myLogger.info(">>>> jdbc.user="+env.getProperty("jdbc.user"));
		
		// set the database connections props
		
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		securityDataSource.setInitialPoolSize(
				getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(
				getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(
				getIntProperty("connection.pool.maxPoolSize"));
		
		securityDataSource.setMaxIdleTime(
				getIntProperty("connection.pool.maxIdleTime"));
		
		//set the connection pool props
		return securityDataSource;
	}
	
	private int getIntProperty(String propName) {
		
		String propVal = env.getProperty(propName);
		
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}
	
	
}
















