package com.jp.cpProject.jwt.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jp.cpProject.model.Client;
import com.jp.cpProject.model.Inspector;
import com.jp.cpProject.repository.ClientRepository;
import com.jp.cpProject.repository.InspectorRepository;

@Service
public class JWTUserDetailsService implements UserDetailsService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private InspectorRepository inspectorRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		if ("javainuse".equals(email)) { // debug

			return null;

		} else {

			for (Client u : clientRepository.findAllClient()) {
				if (u.getEmail().equals(email)) {
					return u;
				}
			}

			for (Inspector u : inspectorRepository.findAll()) {
				if (u.getEmail().equals(email)) {
					return u;
				}
			}

			throw new UsernameNotFoundException("User not found with email: " + email);

		}
	}
}