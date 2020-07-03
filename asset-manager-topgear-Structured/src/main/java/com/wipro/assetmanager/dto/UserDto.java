package com.wipro.assetmanager.dto;

import javax.validation.constraints.NotNull;

public class UserDto {

	@NotNull
	private String username;
	@NotNull
	private String password;	
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
