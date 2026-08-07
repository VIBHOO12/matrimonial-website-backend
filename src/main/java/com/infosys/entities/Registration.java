package com.infosys.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rid;
	
	@JsonIgnore
	@OneToOne(mappedBy = "registration" , cascade = CascadeType.ALL, orphanRemoval = true)
	private User user;
	
	@JsonIgnore
	@OneToOne(mappedBy = "registration", cascade = CascadeType.ALL, orphanRemoval = true)
	private Education education;
	
	@JsonIgnore
	@OneToOne(mappedBy = "registration", cascade = CascadeType.ALL, orphanRemoval = true)
	private Family family;
	
	@JsonIgnore
	@OneToOne(mappedBy = "registration", cascade = CascadeType.ALL, orphanRemoval = true)
	private Personal personal;
	
	@JsonIgnore
	@OneToMany(mappedBy = "registration", cascade = CascadeType.ALL)
	private List<Location> location;
	
	@JsonIgnore
	@OneToMany(mappedBy = "registration", cascade = CascadeType.ALL)
	private List<Message> message;
	
	@Column(unique=true)
	private String userName;
	private String email;
	private String password;
	public Registration() {
		super();
	}
	public Registration(int rid, User user, Education education, Family family, Personal personal,
			List<Location> location, List<Message> message, String userName, String email, String password) {
		super();
		this.rid = rid;
		this.user = user;
		this.education = education;
		this.family = family;
		this.personal = personal;
		this.location = location;
		this.message = message;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Education getEducation() {
		return education;
	}
	public void setEducation(Education education) {
		this.education = education;
	}
	public Family getFamily() {
		return family;
	}
	public void setFamily(Family family) {
		this.family = family;
	}
	public Personal getPersonal() {
		return personal;
	}
	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
	public List<Location> getLocation() {
		return location;
	}
	public void setLocation(List<Location> location) {
		this.location = location;
	}
	public List<Message> getMessage() {
		return message;
	}
	public void setMessage(List<Message> message) {
		this.message = message;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Registration [rid=" + rid + ", user=" + user + ", education=" + education + ", family=" + family
				+ ", personal=" + personal + ", location=" + location + ", message=" + message + ", userName="
				+ userName + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
	
	
	
}