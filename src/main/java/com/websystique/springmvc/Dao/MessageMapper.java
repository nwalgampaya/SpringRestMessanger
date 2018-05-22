package com.websystique.springmvc.Dao;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.websystique.springmvc.model.Message;

public class MessageMapper implements RowMapper<Message>{

	@Override
	public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
		Message message = new Message();
		message.setId(rs.getInt("id"));
		message.setMessage(rs.getString("message"));
		message.setAuthor(rs.getString("author"));
	      
	      return message;
	}

}
