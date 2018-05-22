package com.websystique.springmvc.Dao;

import java.util.Date;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.websystique.springmvc.model.Message;

public class MessageJDBCTemplate implements MessageDao{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);

	}

	@Override
	public void create(String message, String author) {
		 String SQL = "insert into Message (message, created, author) values (?, ?, ?)";
	      jdbcTemplateObject.update( SQL, message, new Date(), author);
	      System.out.println("Created Record message = " + message + " author = " + author);
	      return;		
	}

	@Override
	public Message getMessage(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
