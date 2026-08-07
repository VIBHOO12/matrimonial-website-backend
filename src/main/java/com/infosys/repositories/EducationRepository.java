package com.infosys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.entities.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education,Integer>{

}
