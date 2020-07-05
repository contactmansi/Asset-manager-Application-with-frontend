package com.wipro.assetmanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GenericException extends RuntimeException {
	
	private String viewName;

	public GenericException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public GenericException(String message, String viewName) {
		super(message);
		this.viewName = viewName;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	
	

}
