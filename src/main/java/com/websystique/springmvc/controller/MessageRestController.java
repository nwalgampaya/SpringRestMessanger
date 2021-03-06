package com.websystique.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
//	, produces = MediaType.APPLICATION_XML_VALUE
	@RequestMapping(value="/restDbMsg/{id}",method = RequestMethod.GET)
	public ResponseEntity<Message> getMessage(@PathVariable("id") int id){
		System.out.println("Fetching User with id " + id);
		Message message = messageService.getMsgFromDB(id);
		
		if(message == null){
			return new ResponseEntity<Message>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<Message>(message,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/restDbMsg/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Message> updateMessage(@PathVariable("id") int id, @RequestBody Message msg) {
		System.out.println("Updating User " + id);

		if (msg == null) {
			System.out.println("msg with id " + id + " not found");
			return new ResponseEntity<Message>(HttpStatus.NOT_FOUND);
		}

		messageService.updateMessage(id, msg.getMessage(), msg.getAuthor());
		msg.setId(id);
		
		
		return new ResponseEntity<Message>(messageService.getMsgFromDB(id), HttpStatus.OK);
	}
	

	
	@RequestMapping(value = "/restDbMsg/", method = RequestMethod.POST)
	public ResponseEntity<Message> createUser(@RequestBody Message message, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + message.getMessage());

		/*if (userService.isUserExist(message)) {
			System.out.println("A User with name " + user.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
*/
		messageService.createMessage(message);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/restDbMsg/{id}").buildAndExpand(message.getId()).toUri());
		return new ResponseEntity<Message>(message,HttpStatus.OK);
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
