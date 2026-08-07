package com.infosys.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int replyId;
	private String name;
	private String email;
	private String country;
	private String message;
	public Reply() {
		super();
	}
	public Reply(int replyId, String name, String email, String country, String message) {
		super();
		this.replyId = replyId;
		this.name = name;
		this.email = email;
		this.country = country;
		this.message = message;
	}
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", name=" + name + ", email=" + email + ", country=" + country
				+ ", message=" + message + "]";
	}
}
