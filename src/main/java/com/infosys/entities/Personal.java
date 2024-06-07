package com.infosys.entities;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;

@Entity
public class Personal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personalId;
	
	@OneToOne
	@JoinColumn(name="rid")
	private Registration registration;
	@Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "photograph", columnDefinition="LONGBLOB")
    private byte[] photograph;
    private String bloodGroup;
	public Personal() {
		super();
	}
	public Personal(int personalId, Registration registration, byte[] photograph, String bloodGroup) {
		super();
		this.personalId = personalId;
		this.registration = registration;
		this.photograph = photograph;
		this.bloodGroup = bloodGroup;
	}
	public int getPersonalId() {
		return personalId;
	}
	public void setPersonalId(int personalId) {
		this.personalId = personalId;
	}
	public Registration getRegistration() {
		return registration;
	}
	public void setRegistration(Registration registration) {
		this.registration = registration;
	}
	public byte[] getPhotograph() {
		return photograph;
	}
	public void setPhotograph(byte[] photograph) {
		this.photograph = photograph;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	@Override
	public String toString() {
		return "Personal [personalId=" + personalId + ", registration=" + registration + ", photograph="
				+ Arrays.toString(photograph) + ", bloodGroup=" + bloodGroup + "]";
	}
	
    
    
    
	
	
}
