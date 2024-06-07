package com.infosys.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Family {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int familyId;
	
	@OneToOne
	@JoinColumn(name="rid")
	private Registration registration;
	private String familyStatus;
	private String familyType;
	private String fatherName;
	public Family() {
		super();
	}
	public Family(int familyId, Registration registration, String familyStatus, String familyType, String fatherName) {
		super();
		this.familyId = familyId;
		this.registration = registration;
		this.familyStatus = familyStatus;
		this.familyType = familyType;
		this.fatherName = fatherName;
	}
	public int getFamilyId() {
		return familyId;
	}
	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}
	public Registration getRegistration() {
		return registration;
	}
	public void setRegistration(Registration registration) {
		this.registration = registration;
	}
	public String getFamilyStatus() {
		return familyStatus;
	}
	public void setFamilyStatus(String familyStatus) {
		this.familyStatus = familyStatus;
	}
	public String getFamilyType() {
		return familyType;
	}
	public void setFamilyType(String familyType) {
		this.familyType = familyType;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	@Override
	public String toString() {
		return "Family [familyId=" + familyId + ", registration=" + registration + ", familyStatus=" + familyStatus
				+ ", familyType=" + familyType + ", fatherName=" + fatherName + "]";
	}
	
	
}
