package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentImple;

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.dao"})
public class JdbcConfig {
	
	@Bean("ds")
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getTempalte() {
	JdbcTemplate jdbcTemplate = new JdbcTemplate();	
	jdbcTemplate.setDataSource(getDataSource());
	return jdbcTemplate;
	}
	
//	@Bean("studentDao")
//	public StudentDao getStudentDao() {
//		StudentImple studentDao = new StudentImple();
//		studentDao.setJdbcTemplate(getTempalte());
//		return studentDao;
//	}
	
	
}
