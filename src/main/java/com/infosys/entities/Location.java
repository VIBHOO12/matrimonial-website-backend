package com.infosys.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Location {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int locationId;
    private String name;
    private String email;
    private String location;
    private String date;
    private String time;
    @ManyToOne 
	@JoinColumn(name="rid")
	private Registration registration;
	public Location() {
		super();
	}
	public Location(int locationId, String name, String email, String location, String date, String time,
			Registration registration) {
		super();
		this.locationId = locationId;
		this.name = name;
		this.email = email;
		this.location = location;
		this.date = date;
		this.time = time;
		this.registration = registration;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Registration getRegistration() {
		return registration;
	}
	public void setRegistration(Registration registration) {
		this.registration = registration;
	}
	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", name=" + name + ", email=" + email + ", location=" + location
				+ ", date=" + date + ", time=" + time + ", registration=" + registration + "]";
	}
    
    
}
