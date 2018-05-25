package com.websystique.springmvc.Dao;

import java.util.List;

import javax.sql.DataSource;

import com.websystique.springmvc.model.Message;

public interface MessageDao {

	// public void setDataSource(DataSource ds);

	/**
	 * This is the method to be used to create a record in the Student table.
	 */
	public void create(String message, String author);

	/**
	 * This is the method to be used to list down a record from the Student table
	 * corresponding to a passed student id.
	 */
	public Message getMessage(Integer id);

	public List<Message> getAllMessage();

	public void update(int id, String message, String author);
}
