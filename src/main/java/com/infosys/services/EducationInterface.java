package com.infosys.services;

import java.util.List;

import com.infosys.entities.Education;

public interface EducationInterface {
	public List<Education> getAllEducation();
	public Education addEducation(Education education);
	public Education getEducationById(int id);
	Education updateEducation(int id, Education education); 
	void deleteEducation(int id);
}
