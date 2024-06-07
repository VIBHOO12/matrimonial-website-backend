package com.infosys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entities.Registration;
//import com.infosys.entities.User;
import com.infosys.repositories.RegistrationRepository;

import jakarta.transaction.Transactional;

@Service
public class RegistrationService implements RegistrationInterface{
	@Autowired
	RegistrationRepository repository;
	
	@Override
	public List<Registration> getAllRegistration() {
		return repository.findAll();
	}
	
	@Override
	public Registration addRegistration(Registration registration) {
		return repository.save(registration);
	}
	
	@Override
	public Registration getRegistrationInfoById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	@Transactional
    public Registration updateRegistration(int rid, Registration newRegistration) {
        Registration existingRegistration = repository.findById(rid).orElse(null);
        if (existingRegistration != null) {
            existingRegistration.setUserName(newRegistration.getUserName());
            existingRegistration.setEmail(newRegistration.getEmail());
            existingRegistration.setPassword(newRegistration.getPassword());
            return repository.save(existingRegistration);
        }
        return null; 
    }

	@Transactional
    public void deleteRegistration(int rid) {
        Registration registration = repository.findById(rid).orElse(null);
        if (registration != null) {
            repository.delete(registration);
        }
    }
    
    @Override
    public Registration findByUserName(String userName) {
        return repository.findByUserName(userName).orElse(null);
    }
	
}