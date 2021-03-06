package com.websystique.springmvc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.Dao.MessageDao;
import com.websystique.springmvc.model.Message;
import com.websystique.springmvc.model.Messages;

@Service
public class MessageService {
	@Autowired
	List<Message> messages ;
	
	@Autowired
	MessageDao messageDao;
//	= new ArrayList()
//	List<Message>
	public List<Message> getAllSpringMessages(){
		
		System.out.println("**************In Service********");
//		List<Message> messages = new ArrayList<>();
 		Message m1 = new Message(1l,"Nalin ",new Date(), "Me");
		Message m2 = new Message(2l,"JSOn ",new Date(), "Me");
		messages.add(m1);
		messages.add(m2);
		
		messages.forEach(item -> System.out.println("######" +item.toString()));
		return messages;
	}
	
	public List<Message> getAllMsgFromDB(){
		
		List<Message> allMessages = messageDao.getAllMessage();
		return allMessages;
	}

	public Message getMsgFromDB(Integer id) {

		Message message = messageDao.getMessage(id);
		return message;
	}
	public void createMessage(Message message) {
		
		String messages = message.getMessage();
		String author = message.getAuthor();
		messageDao.create(messages, author);
	}
	
	public void updateMessage(int id,String message, String author) {
		
		messageDao.update(id, message, author);
	}
	public Messages getAllMessages()
	{
		Messages list = new Messages();
	    list.setMessageList(new ArrayList<Message>());
	     
	    list.getMessageList().add(new Message(1, "Lokesh Gupta",new Date(),"Nalin"));
	    list.getMessageList().add(new Message(2, "Alex Kolenchiskey",new Date(),"Nalin"));
	    list.getMessageList().add(new Message(3, "David Kameron",new Date(),"Nalin"));
	     
	    return list;
	}
}
