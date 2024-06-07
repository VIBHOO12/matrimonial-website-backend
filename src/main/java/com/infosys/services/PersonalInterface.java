package com.infosys.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.infosys.entities.Personal;
import com.infosys.entities.Registration;


public interface PersonalInterface {
	
    Personal savePersonal(Personal personal);
    Personal createPersonal(Registration registration, MultipartFile file, String bloodGroup) throws IOException;
    Personal getPersonalById(Integer id);
    List<Personal> getAllPersonal();
    Personal updatePersonal(Integer id, Personal updatedPersonal);
    void deletePersonal(Integer id);
}
