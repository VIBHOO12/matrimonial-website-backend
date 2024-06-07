package com.infosys.services;

import java.util.List;

import com.infosys.entities.Registration;



public interface RegistrationInterface {
	public List<Registration> getAllRegistration();
	public Registration addRegistration(Registration registration);
	public Registration getRegistrationInfoById(int id);
	Registration updateRegistration(int id, Registration registration);
    void deleteRegistration(int id);
    Registration findByUserName(String userName);
}
