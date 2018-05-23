package com.websystique.springmvc.client;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.websystique.springmvc.Dao.MessageDao;
import com.websystique.springmvc.configuration.HelloWorldConfiguration;
import com.websystique.springmvc.model.Message;

public class App {

	public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
        		HelloWorldConfiguration.class);
	
        MessageDao messageDao= applicationContext.getBean(MessageDao.class);
//        messageDao.create("test", "MMMEEEE");
        
        
        List<Message> messages = messageDao.getAllMessage();
        
        for (Message message : messages) {
			System.out.println(message.getId());
			System.out.println(message.getMessage());
			System.out.println(message.getAuthor());
		}
        
        applicationContext.close();
	}
 
}
