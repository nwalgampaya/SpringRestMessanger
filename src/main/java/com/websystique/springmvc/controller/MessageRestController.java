package com.websystique.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
	
	@RequestMapping(value = "/restDbMsg/", method = RequestMethod.GET)
	public ResponseEntity<List<Message>> getAllMessage() {
		List<Message> messagesList = messageService.getAllMsgFromDB();
//		Messages  messages = messageService.getAllMessages();
		
		if(messageService.getAllMsgFromDB().isEmpty()){
			return new ResponseEntity<List<Message>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Message>>(messagesList,HttpStatus.OK);
	
	
	} 
	
//	getMsgFromDB
	
	@RequestMapping(value="/restDbMsg/{id}",method = RequestMethod.GET)
	public ResponseEntity<Message> getMessage(@PathVariable("id") int id){
		System.out.println("Fetching User with id " + id);
		Message message = messageService.getMsgFromDB(id);
		
		if(message == null){
			return new ResponseEntity<Message>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<Message>(message,HttpStatus.OK);
	}
	
/*	@RequestMapping(value = "/createMsg/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody Message message, 	UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + message.getMessage());

		if (userService.isUserExist(user)) {
			System.out.println("A User with name " + user.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		messageService.createMessage(message, author);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}*/

	
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
