package com.infosys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entities.Message;
import com.infosys.services.MessageService;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class MessageController {
	
	@Autowired// used for dependency injection
	MessageService service;
	
	@GetMapping("/message")
	public List<Message> getAllMessage(){
		return service.getAllMessage();
	}
	
	@PostMapping("/message")
	public Message addMessage(@RequestBody Message message) {
		return service.addMessage(message);
	}
	
	@GetMapping("/message/{id}")
	public Message getMessageById(@PathVariable("id") int id) {
		return service.getMessageById(id);
	}
	
	 @PutMapping("/message/{id}")
	    public Message updateMessage(@PathVariable("id") int id, @RequestBody Message message) {
	        return service.updateMessage(id, message);
	    }
	    
    @DeleteMapping("/message/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable("id") int id) {
        service.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }
    
}
