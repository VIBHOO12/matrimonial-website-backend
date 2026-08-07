package com.infosys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.infosys.entities.Location;
import com.infosys.entities.Message;
import com.infosys.services.MessageService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class MessageController {
	
	@Autowired// used for dependency injection
	private MessageService service;
	
	@PostMapping("/message")
    public ResponseEntity<Message> saveLocation(@RequestBody Message message) {
		Message savedLocation = service.saveMessage(message);
        return new ResponseEntity<>(savedLocation, HttpStatus.CREATED);
    }

    @GetMapping("message/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable Integer id) {
    	Message message = service.getMessageById(id);
        if (message != null) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("message/all")
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> message = service.getAllMessages();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("message/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable Integer id, @RequestBody Message updateMessage) {
    	Message message = service.updateMessage(id, updateMessage);
        if (message != null) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("message/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Integer id) {
    	service.deleteMessage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
