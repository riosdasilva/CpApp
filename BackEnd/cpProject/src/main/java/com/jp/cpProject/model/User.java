package com.jp.cpProject.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public class User extends AbstractEntity {
	private String birthday;

	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	private String name;
	private String nationaly;

	private String password;

	public User(String birthday, String email, String name, String nationaly, String password) {
		this.birthday = birthday;
		this.email = email;
		this.name = name;
		this.nationaly = nationaly;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNationaly() {
		return nationaly;
	}

	public void setNationaly(String nationaly) {
		this.nationaly = nationaly;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthday() {
		return birthday;
	}

}
