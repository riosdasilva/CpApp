package com.jp.cpProject.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity 
@DiscriminatorValue("I")
public class Inspector extends User {
	
	public Inspector(String birthday, String email, String name, String nationaly, String password) {
		super(birthday, email, name, nationaly, password);
	}
	
	
}
