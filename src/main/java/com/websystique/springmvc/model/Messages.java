package com.websystique.springmvc.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Service;

@Service
public class Messages {

	@XmlElement(name="message")
    private List<Message> messageList;
 
    public List<Message> getMessageList() {
        return messageList;
    }
 
    public void setMessageList(List<Message> employeeList) {
        this.messageList = employeeList;
    }
}
