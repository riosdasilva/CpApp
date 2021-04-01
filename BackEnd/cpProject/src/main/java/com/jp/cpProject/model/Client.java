package com.jp.cpProject.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity 
@DiscriminatorValue("C")
public class Client extends User {

	public Client(String birthday, String email, String name, String nationaly, String password) {
		super(birthday, email, name, nationaly, password);
	}
	public Client() {
		super(null, null, null, null, null);
	}

}
