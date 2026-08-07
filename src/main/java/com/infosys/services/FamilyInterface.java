package com.infosys.services;

import java.util.List;

import com.infosys.entities.Family;

public interface FamilyInterface {
	public List<Family> getAllFamily();
	public Family addFamily(Family family);
	public Family getFamilyById(int id);
	Family updateFamily(int id, Family family); 
	void deleteFamily(int id);
}
