package com.wipro.assetmanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidUsernamePasswordException extends RuntimeException {
	
	public InvalidUsernamePasswordException(String message) {
		super(message);
	}

}
