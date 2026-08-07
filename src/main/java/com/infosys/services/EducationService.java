package com.infosys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entities.Education;
import com.infosys.repositories.EducationRepository;

@Service
public class EducationService implements EducationInterface{
    
    @Autowired
    EducationRepository repository;

    @Override
    public List<Education> getAllEducation() {
        return repository.findAll();
    }

    @Override
    public Education addEducation(Education education) {
        return repository.save(education);
    }

    @Override
    public Education getEducationById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Education updateEducation(int id, Education newEducation) {
        Education existingEducation = repository.findById(id).orElse(null);
        if (existingEducation != null) {
            existingEducation.setEducationFiled(newEducation.getEducationFiled());
            existingEducation.setEducationLevel(newEducation.getEducationLevel());
            // Set other fields as needed
            return repository.save(existingEducation);
        }
        return null;
    }

    @Override
    public void deleteEducation(int id) {
        repository.deleteById(id);
    }
}
