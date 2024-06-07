package com.infosys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entities.Message;
import com.infosys.repositories.MessageRepository;

@Service
public class MessageService implements MessageInterface{
    
    @Autowired
    MessageRepository repository;

    @Override
    public List<Message> getAllMessage() {
        return repository.findAll();
    }

    @Override
    public Message addMessage(Message message) {
        return repository.save(message);
    }

    @Override
    public Message getMessageById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Message updateMessage(int id, Message newMessage) {
        Message existingMessage = repository.findById(id).orElse(null);
        if (existingMessage != null) {
            existingMessage.setFromUsername(newMessage.getFromUsername());
            existingMessage.setToUsername(newMessage.getToUsername());
            existingMessage.setMessage(newMessage.getMessage());
            return repository.save(existingMessage);
        }
        return null;
    }

    @Override
    public void deleteMessage(int id) {
        repository.deleteById(id);
    }
}
