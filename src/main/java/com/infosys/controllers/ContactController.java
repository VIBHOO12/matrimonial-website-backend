package com.infosys.controllers;

import java.util.List;
import java.util.Optional;

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

import com.infosys.entities.Contact;
import com.infosys.services.ContactInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ContactController {
	
	@Autowired
    private  ContactInterface service;

    @PostMapping("/contact")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        Contact savedContact = service.saveContact(contact);
        return ResponseEntity.ok(savedContact);
    }

    @GetMapping("/contact")
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = service.getAllContacts();
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("contact/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Integer id) {
        Optional<Contact> contact = service.getContactById(id);
        return contact.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("contact/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Integer id, @RequestBody Contact contact) {
        try {
            Contact updatedContact = service.updateContact(id, contact);
            return ResponseEntity.ok(updatedContact);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("contact/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Integer id) {
    	service.deleteContact(id);
        return ResponseEntity.noContent().build();
    }

}