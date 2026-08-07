package com.infosys.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int msgId;
	private String fromUsername;
	private String toUsername;
	private String message;
	private LocalDateTime sentTime;
	@ManyToOne(fetch = FetchType.LAZY) // Many messages can be associated with one registration
	@JoinColumn(name="rid")
	@JsonIgnore
	private Registration registration;
	public Message() {
		super();
	}
	public Message(int msgId, String fromUsername, String toUsername, String message, LocalDateTime sentTime,
			Registration registration) {
		super();
		this.msgId = msgId;
		this.fromUsername = fromUsername;
		this.toUsername = toUsername;
		this.message = message;
		this.sentTime = sentTime;
		this.registration = registration;
	}
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public String getFromUsername() {
		return fromUsername;
	}
	public void setFromUsername(String fromUsername) {
		this.fromUsername = fromUsername;
	}
	public String getToUsername() {
		return toUsername;
	}
	public void setToUsername(String toUsername) {
		this.toUsername = toUsername;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getSentTime() {
		return sentTime;
	}
	public void setSentTime(LocalDateTime sentTime) {
		this.sentTime = sentTime;
	}
	public Registration getRegistration() {
		return registration;
	}
	public void setRegistration(Registration registration) {
		this.registration = registration;
	}
	@Override
	public String toString() {
		return "Message [msgId=" + msgId + ", fromUsername=" + fromUsername + ", toUsername=" + toUsername
				+ ", message=" + message + ", sentTime=" + sentTime + ", registration=" + registration + "]";
	}
	
}
