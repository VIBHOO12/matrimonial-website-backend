package com.infosys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infosys.entities.Message;
import com.infosys.repositories.MessageRepository;

@Service
public class MessageService implements MessageInterface{
    
    @Autowired
    private MessageRepository repository;

    @Override
    public Message saveMessage(Message message) {
        return repository.save(message);
    }

    @Override
    public Message getMessageById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Message> getAllMessages() {
        return repository.findAll();
    }

    @Override
    public Message updateMessage(Integer id, Message updatedMessage) {
        if (repository.existsById(id)) {
        	updatedMessage.setMsgId(id); 
            return repository.save(updatedMessage);
        }
        return null; 
    }

    @Override
    public void deleteMessage(Integer id) {
        repository.deleteById(id);
    }
}
