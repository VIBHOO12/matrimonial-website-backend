package com.infosys.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.entities.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Integer>{
	Optional<Registration> findByUserName(String userName);
	 Optional<Registration> findByEmail(String email);
}