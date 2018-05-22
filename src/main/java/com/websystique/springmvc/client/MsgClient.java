package com.websystique.springmvc.client;

import org.springframework.web.client.RestTemplate;



public class MsgClient {

	/*public static void main(String[] args) {

		Client client = ClientBuilder.newClient();

		WebTarget target = client.target("http://localhost:8080/Springmessanger/webapi/messages/msg");

		Invocation.Builder invocation = target.request(MediaType.APPLICATION_XML);
		Response response = invocation.get();

//		List<Message> message =(List<Message>) response.readEntity(Message.class);
		// List<Message> listOfEmployees = message.getMessage();

//		System.out.println("**************In Service********" + message.getAuthor());

		Messages messages = response.readEntity(Messages.class);
		List<Message> listOfMessages = messages.getMessageList();
		     
		System.out.println(response.getStatus());
		System.out.println(Arrays.toString( listOfMessages.toArray(new Message[listOfMessages.size()]) ));
		 
	}*/
	
	public static void main(String[] args) {
		final String uri = "http://localhost:8080/Spring4MVCRestMessanger/restMsg/";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	     
	    System.out.println(result);
	}
	
}
