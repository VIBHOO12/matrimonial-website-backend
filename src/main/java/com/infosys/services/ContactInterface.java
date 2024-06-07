package com.infosys.services;

import java.util.List;
import java.util.Optional;

import com.infosys.entities.Contact;

public interface ContactInterface {
    Contact saveContact(Contact contact);
    List<Contact> getAllContacts();
    Optional<Contact> getContactById(Integer id);
    Contact updateContact(Integer id, Contact contact);
    void deleteContact(Integer id);
}