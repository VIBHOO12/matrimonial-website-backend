package com.infosys.services;

import java.util.List;

import com.infosys.entities.Message;

public interface MessageInterface {
	
	public List<Message> getAllMessage();
	public Message addMessage(Message message);
	public Message getMessageById(int id);
	Message updateMessage(int id, Message message); 
	void deleteMessage(int id);
}
