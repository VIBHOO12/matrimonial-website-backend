package com.infosys.services;

import java.util.List;

import com.infosys.entities.Message;

public interface MessageInterface {
	Message saveMessage(Message message);
	Message getMessageById(Integer id);
	List<Message> getAllMessages();
	Message updateMessage(Integer id, Message updatedMessage);
	void deleteMessage(Integer id);
}
