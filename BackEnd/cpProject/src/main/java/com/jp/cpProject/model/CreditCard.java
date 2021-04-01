package com.jp.cpProject.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class CreditCard extends AbstractEntity {
	private String number;
	private String type;
	private String validity;

	@ManyToOne
	private User user;
	
	
	public CreditCard(String number, String type, String validity, User use) {
		this.number = number;
		this.type = type;
		this.validity = validity;
		this.user = use;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

}
