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
	            existingUser.setAge(newUser.getAge());
	            existingUser.setGender(newUser.getGender());
	            existingUser.setDateOfBirth(newUser.getDateOfBirth());
	            return repository.save(existingUser);
	        }
	        return null;
	    }

	    @Override
	    public void deleteUser(int id) {
	        repository.deleteById(id);
	    }
	
}
