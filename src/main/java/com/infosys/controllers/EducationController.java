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

import com.infosys.entities.Education;
import com.infosys.services.EducationService;
@RestController
//spring restful service
//@Controller+@ResponsBody //spring mvc 
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class EducationController {

	@Autowired// used for dependency injection
	EducationService educationCareerService;
	
	@GetMapping("/edu")
	public List<Education> getAllEducation(){
		return educationCareerService.getAllEducation();
	}
	
	@PostMapping("/edu")
	public Education addEducation(@RequestBody Education education) {
		return educationCareerService.addEducation(education);
	}
	
	@GetMapping("/edu/{id}")
	public Education getEducationById(@PathVariable("id") int id) {
		return educationCareerService.getEducationById(id);
	}
	
	 @PutMapping("/edu/{id}")
	    public Education updateUser(@PathVariable("id") int id, @RequestBody Education education) {
	        return educationCareerService.updateEducation(id, education);
	    }
	    
    @DeleteMapping("/edu/{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable("id") int id) {
    	educationCareerService.deleteEducation(id);
        return ResponseEntity.noContent().build();
    }
	
}
