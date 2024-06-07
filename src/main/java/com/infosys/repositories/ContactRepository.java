package com.infosys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.entities.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer>{

}