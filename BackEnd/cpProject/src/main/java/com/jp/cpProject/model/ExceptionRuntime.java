package com.jp.cpProject.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class ExceptionRuntime extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ExceptionRuntime(String exception) {
		super(exception);
		
	}

}
