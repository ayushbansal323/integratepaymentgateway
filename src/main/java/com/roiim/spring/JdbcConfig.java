package com.roiim.spring;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.util.ResourceUtils;

import com.roiim.dao.CustomerDAO;
import com.roiim.dao.impl.CustomerDAOImpl;
import com.roiim.restapi.CustomerAPI;
import com.roiim.restapi.PaymentAPI;


@Configuration
@ComponentScan(basePackages = "com.roiim")
public class JdbcConfig {

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = null;
		try {
			File file = ResourceUtils.getFile("classpath:config/database.properties");
			FileReader fileReader;
			
				fileReader = new FileReader(file);
			
			Properties properties = new Properties();
			properties.load(fileReader);
			
			String URL = properties.getProperty("URL");
			String USER = properties.getProperty("USER");
			String PASSWORD = properties.getProperty("PASSWORD");
			
			ds = new DriverManagerDataSource();
			ds.setDriverClassName("org.postgresql.Driver");
			ds.setUrl(URL);
			ds.setUsername(USER);
			ds.setPassword(PASSWORD);
			return ds;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ds;
	}

	@Bean
	public JdbcTemplate jt(DataSource ds) {
		return new JdbcTemplate(ds);
	}
	
	@Bean
	public CustomerDAO customerDao() {
		return new CustomerDAOImpl();
	}
	
	@Bean
	public CustomerAPI customerAPI() {
		return new CustomerAPI();
	}
	
	@Bean
	public PaymentAPI paymentAPI() {
		return new PaymentAPI();
	}
}
