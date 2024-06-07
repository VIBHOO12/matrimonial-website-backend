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

import com.infosys.entities.Registration;
import com.infosys.services.RegistrationService;

@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api")
@RestController
public class RegistrationController {
	
	@Autowired
	RegistrationService service;
	
	@GetMapping("/rege")
	public List<Registration> getAllRegistration(){
		return service.getAllRegistration();
	}
	
	@PostMapping("/rege")
	public Registration addRegistration(@RequestBody Registration registration) {
		return service.addRegistration(registration);
	}
	
	@GetMapping("/rege/id/{id}")
	public Registration getRegistrationInfoById(@PathVariable("id") int id) {
		return service.getRegistrationInfoById(id);
	}
	
	 @GetMapping("/rege/username/{userName}")
	    public ResponseEntity<Registration> findByUserName(@PathVariable String userName) {
	        Registration registration = service.findByUserName(userName);
	        if (registration != null) {
	            return new ResponseEntity<>(registration, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	
	 @PutMapping("/rege/{id}")
	    public Registration updateRegistration(@PathVariable("id") int id, @RequestBody Registration registration) {
	        return service.updateRegistration(id, registration);
	    }
	    
	    @DeleteMapping("/rege/{id}")
	    public void deleteRegistration(@PathVariable("id") int id) {
	        service.deleteRegistration(id);
	    }
}
