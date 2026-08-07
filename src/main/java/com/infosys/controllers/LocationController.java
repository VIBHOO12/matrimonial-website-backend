package com.infosys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entities.Location;
import com.infosys.services.LocationService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LocationController {
	
	@Autowired
    private LocationService locationService;

    @PostMapping("/location")
    public ResponseEntity<Location> saveLocation(@RequestBody Location location) {
        Location savedLocation = locationService.saveLocation(location);
        return new ResponseEntity<>(savedLocation, HttpStatus.CREATED);
    }

    @GetMapping("location/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Integer id) {
    	Location location = locationService.getLocationById(id);
        if (location != null) {
            return new ResponseEntity<>(location, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("location/all")
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> location = locationService.getAllLocations();
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @PutMapping("location/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Integer id, @RequestBody Location updateLocation) {
    	Location location = locationService.updateLocation(id, updateLocation);
        if (location != null) {
            return new ResponseEntity<>(location, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("location/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Integer id) {
    	locationService.deleteLocation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
