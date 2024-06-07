package com.infosys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entities.Family;
import com.infosys.repositories.FamilyRepository;

@Service
public class FamilyService implements FamilyInterface{
    
    @Autowired
    FamilyRepository repository;

    @Override
    public List<Family> getAllFamily() {
        return repository.findAll();
    }

    @Override
    public Family addFamily(Family family) {
        return repository.save(family);
    }

    @Override
    public Family getFamilyById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Family updateFamily(int id, Family newFamily) {
        Family existingFamily = repository.findById(id).orElse(null);
        if (existingFamily != null) {
            existingFamily.setFamilyStatus(newFamily.getFamilyStatus());
            existingFamily.setFamilyType(newFamily.getFamilyType());
            existingFamily.setFatherName(newFamily.getFatherName());
            // Set other fields as needed
            return repository.save(existingFamily);
        }
        return null;
    }

    @Override
    public void deleteFamily(int id) {
        repository.deleteById(id);
    }
}
