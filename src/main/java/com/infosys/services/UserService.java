package com.infosys.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entities.User;
import com.infosys.repositories.UserRepository;

@Service
public class UserService implements UserServiceInterface {
	
	@Autowired
	UserRepository repository;
	
	
	@Override
	public List<User> getAllUser() {
		return repository.findAll();
	}
	
	 @Override
	    public User addUser(User user) {
	        // Check if the Registration object is null
	     /*   if (user.getRegistration() == null) {
	            throw new IllegalArgumentException("Registration object cannot be null");
	        }
	        
	        // Extract the rid from the provided user
	        int rid = user.getRegistration().getRid();
	        // Fetch the Registration entity by rid
	        Registration registration = Regirepository.findById(rid)
	                .orElseThrow(() -> new IllegalArgumentException("Invalid rid: " + rid));
	        // Set the Registration entity to the User
	        user.setRegistration(registration);
	        // Save the User entity */
	       return repository.save(user);
	    }
	
	@Override
	public User getUserById(int id) {
		return repository.findById(id).get();
	}
	
	 @Override
	    public User updateUser(int id, User newUser) {
	        User existingUser = repository.findById(id).orElse(null);
	        if (existingUser != null) {
	            existingUser.setFirstName(newUser.getFirstName());
	            existingUser.setLastName(newUser.getLastName());
	            
	            return repository.save(existingUser);
	        }
	        return null;
	    }

	    @Override
	    public void deleteUser(int id) {
	        repository.deleteById(id);
	    }
	
}
