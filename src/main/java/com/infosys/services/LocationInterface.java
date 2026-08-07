package com.infosys.services;

import java.util.List;

import com.infosys.entities.Location;

public interface LocationInterface {
	Location saveLocation(Location location);
	Location getLocationById(Integer id);
	List<Location> getAllLocations();
	Location updateLocation(Integer id, Location updatedLocation);
	void deleteLocation(Integer id);
}
