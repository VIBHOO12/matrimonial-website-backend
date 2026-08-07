package com.infosys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entities.Location;
import com.infosys.repositories.LocationRepository;

@Service
public class LocationService implements LocationInterface{
	
	@Autowired
	private LocationRepository repository;
	
    @Override
    public Location saveLocation(Location location) {
        return repository.save(location);
    }

    @Override
    public Location getLocationById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Location> getAllLocations() {
        return repository.findAll();
    }

    @Override
    public Location updateLocation(Integer id, Location updatedLocation) {
        if (repository.existsById(id)) {
        	updatedLocation.setLocationId(id); 
            return repository.save(updatedLocation);
        }
        return null; 
    }

    @Override
    public void deleteLocation(Integer id) {
        repository.deleteById(id);
    }
}
