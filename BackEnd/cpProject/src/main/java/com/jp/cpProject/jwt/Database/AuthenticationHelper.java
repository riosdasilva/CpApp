package com.jp.cpProject.jwt.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.cpProject.jwt.JwtTokenUtil;
import com.jp.cpProject.repository.ClientRepository;

/**
 * Methods to authorize the access into the system from the token
 *
 */
@Service
public class AuthenticationHelper {

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	private final static String INVALIDITY_MESSAGE = "O token não é válido para o user ";

	/**
	 * checks if a token is associated with a given Patient code
	 * 
	 * @param token the token
	 * @param email the code to be compared with the code associated with the token
	 * @return true if the code is associated with the token, false otherwise
	 */
	public boolean isPatientCodeInToken(String token, String email) {
		final String username = jwtTokenUtil.getUsernameFromBearerToken(token);
		boolean match = true;
		if (!email.equals(username)) {
			match = false;
			throw new RuntimeException(INVALIDITY_MESSAGE + username);
		}
		return match;
	}

}
