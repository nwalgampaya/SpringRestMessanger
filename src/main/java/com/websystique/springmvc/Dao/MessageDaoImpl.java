package com.websystique.springmvc.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Message;

@Repository
public class MessageDaoImpl implements MessageDao{

//	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
	
/*    @Override
	public void setDataSource(DataSource ds) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);

	}
*/
	@Override
	public void create(String message, String author) {
		 String SQL = "insert into Message (message, created, author) values (?, ?, ?)";
	      jdbcTemplate.update( SQL, message, new Date(), author);
	      System.out.println("Created Record message = " + message + " author = " + author);
//	      return;		
	}

//	@Override
	public void update(int id, String message, String author) {
		 String SQL = "UPDATE Message SET message= ? , author=? where id =?"  ;
	      jdbcTemplate.update( SQL, message, author, id);
	      System.out.println("Updated Record message = " + message + " author = " + author);
//	      return;		
	      
	} 
	@Override
	public List<Message> getAllMessage() {
		 String SQL = "select * from Message";
		 
		 
		 List<Message> messages = jdbcTemplate.query(SQL, 
	                new BeanPropertyRowMapper(Message.class));

	   /*     List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);
	        List<Message> messages = new ArrayList<>();
	        
	        rows.stream().forEach((row) -> {
	            System.out.printf("%s ", row.get("message"));
	            System.out.printf("%s ", row.get("author"));
//	            System.out.println(row.get("Price"));
	            messages.add(row.get(1));
	        });*/
		return messages;
	}
	
	@Override
	public Message getMessage(Integer id) {
		String SQL = "select * from Message where id= ?";
		 
		 
//		Message messages = jdbcTemplate.query(SQL, 
//	                new BeanPropertyRowMapper(Message.class));
		Message messages = (Message) jdbcTemplate.queryForObject(SQL, 
		         new Object[]{id},new BeanPropertyRowMapper( Message.class));
		      

		 return messages;
	}


}
