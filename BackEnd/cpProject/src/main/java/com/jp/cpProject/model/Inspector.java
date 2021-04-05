package com.jp.cpProject.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Entity
@DiscriminatorValue("I")
public class Inspector extends User implements UserDetails {

	public Inspector(String birthday, String email, String name, String nationaly, String password) {
		super(birthday, email, name, nationaly, password);
	}

	public Inspector() {
		super(null, null, null, null, null);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}