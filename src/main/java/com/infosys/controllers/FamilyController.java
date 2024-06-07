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

import com.infosys.entities.Family;
import com.infosys.services.FamilyService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class FamilyController {
	
	@Autowired// used for dependency injection
	FamilyService familyInfoService;
	
	@GetMapping("/family")
	public List<Family> getAllFamily(){
		return familyInfoService.getAllFamily();
	}
	
	@PostMapping("/family")
	public Family addFamily(@RequestBody Family family) {
		return familyInfoService.addFamily(family);
	}
	
	@GetMapping("/family/{id}")
	public Family getFamilyById(@PathVariable("id") int id) {
		return familyInfoService.getFamilyById(id);
	}
	
	 @PutMapping("/family/{id}")
	    public Family updateFamily(@PathVariable("id") int id, @RequestBody Family family) {
	        return familyInfoService.updateFamily(id, family);
	    }
	    
    @DeleteMapping("/family/{id}")
    public ResponseEntity<Void> deleteFamily(@PathVariable("id") int id) {
    	familyInfoService.deleteFamily(id);
        return ResponseEntity.noContent().build();
    }
}
