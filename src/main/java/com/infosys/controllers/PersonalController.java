package com.infosys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infosys.entities.Personal;
import com.infosys.entities.Registration;
import com.infosys.services.PersonalService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class PersonalController {
	
	@Autowired// used for dependency injection
	PersonalService personalInfoService;
	
	@PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> createPersonalInfo(
            @RequestParam("registration") String registrationJson,
            @RequestParam("file") MultipartFile file,
            @RequestParam("bloodGroup") String bloodGroup) {
        try {
            // Convert the registration JSON string to Registration object
            ObjectMapper objectMapper = new ObjectMapper();
            Registration registration = objectMapper.readValue(registrationJson, Registration.class);

            Personal personal = personalInfoService.createPersonal(registration, file, bloodGroup);
            return new ResponseEntity<>(personal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to upload file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personal> getPersonalInfoById(@PathVariable Integer id) {
        Personal personal = personalInfoService.getPersonalById(id);
        if (personal != null) {
            return new ResponseEntity<>(personal, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Personal>> getAllPersonalInfo() {
        List<Personal> personal = personalInfoService.getAllPersonal();
        return new ResponseEntity<>(personal, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<?> updatePersonalInfo(
            @PathVariable Integer id,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam("bloodGroup") String bloodGroup,
            @RequestParam("registration") String registrationJson) {
        try {
            // Convert the registration JSON string to Registration object
            ObjectMapper objectMapper = new ObjectMapper();
            Registration registration = objectMapper.readValue(registrationJson, Registration.class);

            Personal updatedPersonalInfo = personalInfoService.updatePersonalInfo(id, file, bloodGroup, registration);
            if (updatedPersonalInfo != null) {
                return new ResponseEntity<>(updatedPersonalInfo, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update personal info: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonalInfo(@PathVariable Integer id) {
    	personalInfoService.deletePersonal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/{id}/photo")
    public ResponseEntity<byte[]> getPhoto(@PathVariable Integer id) {
        Personal personal = personalInfoService.getPersonalById(id);
        if (personal == null || personal.getPhotograph() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"photo.jpg\"")
                .contentType(MediaType.IMAGE_JPEG)
                .body(personal.getPhotograph());
    }
}
