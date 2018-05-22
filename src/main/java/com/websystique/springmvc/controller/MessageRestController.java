package com.websystique.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.websystique.springmvc.model.Message;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.service.MessageService;
import com.websystique.springmvc.service.UserService;




@RestController
public class MessageRestController {

	@Autowired
	MessageService messageService = new MessageService();

	@RequestMapping(value = "/restMsg/", method = RequestMethod.GET)
	public ResponseEntity<List<Message>> getMessages() {
		List<Message> messagesList = messageService.getAllSpringMessages();
//		Messages  messages = messageService.getAllMessages();
		
		/*if(messageService.getAllSpringMessages().isEmpty()){
			return new ResponseEntity<List<Message>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}*/
		return new ResponseEntity<List<Message>>(messagesList,HttpStatus.OK);
	
	
	}
	

	
	//-------------------Retrieve All Users--------------------------------------------------------
	
	@Autowired
	UserService userService;  //Service which will do all data retrieval/manipulation work
	@RequestMapping(value = "/restUser/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
//		users.add();
		List<User> users = userService.findAllUsers();
		if(users.isEmpty()){
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	//-------------------Retrieve All Users--------------------------------------------------------
	

}
