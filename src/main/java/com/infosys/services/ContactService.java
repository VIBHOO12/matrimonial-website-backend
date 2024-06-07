package com.infosys.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entities.Contact;
import com.infosys.repositories.ContactRepository;

@Service
public class ContactService implements ContactInterface {
    @Autowired
    private ContactRepository repository;

    @Override
    public Contact saveContact(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    @Override
    public Optional<Contact> getContactById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Contact updateContact(Integer id, Contact contact) {
        if (repository.existsById(id)) {
            contact.setContactId(id);;
            return repository.save(contact);
        }
        throw new RuntimeException("Contact not found");
    }

    @Override
    public void deleteContact(Integer id) {
        repository.deleteById(id);
    }
}