package com.infosys.services;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.infosys.entities.Personal;
import com.infosys.entities.Registration;
import com.infosys.repositories.PersonalRepository;

@Service
public class PersonalService implements PersonalInterface {
    
    @Autowired
    PersonalRepository repository;
    
    @Override
    public Personal createPersonal(Registration registration, MultipartFile file, String bloodGroup) throws IOException {

        Personal personal = new Personal();
        personal.setBloodGroup(bloodGroup);
        personal.setRegistration(registration);

        if (file != null && !file.isEmpty()) {
            personal.setPhotograph(file.getBytes());
        }
        return repository.save(personal);
    }

    
    @Override
    public Personal getPersonalById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Personal> getAllPersonal() {
        List<Personal> allPersonal = repository.findAll();
        return allPersonal.stream()
            .map(info -> new Personal(info.getPersonalId(), info.getRegistration(), info.getPhotograph(), info.getBloodGroup()))
            .collect(Collectors.toList());
    }
 
    @Override
    public Personal updatePersonal(Integer id, Personal updatedPersonal) {
        if (repository.existsById(id)) {
            updatedPersonal.setPersonalId(id);;
            return repository.save(updatedPersonal);
        }
        return null; 
    }

    @Override
    public void deletePersonal(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Personal savePersonal(Personal personal) {
        throw new UnsupportedOperationException("Unimplemented method 'savePersonalInfo'");
    }
}
