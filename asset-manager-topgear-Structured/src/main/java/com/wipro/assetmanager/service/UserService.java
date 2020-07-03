package com.wipro.assetmanager.service;

import com.wipro.assetmanager.dto.UserDto;
import com.wipro.assetmanager.exceptions.GenericException;
import com.wipro.assetmanager.exceptions.InvalidUsernamePasswordException;

import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Service
public class UserService {

	public HttpStatus loginUser(UserDto user) {
		System.out.println("----------Inside loginUser function block-------");

		if(Objects.nonNull(user) && 
				Optional.ofNullable(user.getUsername()).isPresent() && 
				Optional.ofNullable(user.getPassword()).isPresent()) {

			if(user.getUsername().equalsIgnoreCase("admin") && user.getPassword().equalsIgnoreCase("admin")) {
				System.out.println("----------Redirection to homepage-------"); 
				return HttpStatus.ACCEPTED; 
			} 
			else { 
				throw new GenericException("-- Invalid Username or Password ---");
				//throw new InvalidUsernamePasswordException("Invalid Username or Password"); 
			} 
		}

		return HttpStatus.NOT_FOUND;
	}
}


/*Optional.ofNullable(user);
		Optional.ofNullable(user.getUsername());
		/*
 * Optional.ofNullable(user).ofNullable(user.getUsername()).ofNullable(user.
 * getPassword()).map(response -> { //check for admin admin return
 * HttpStatus.ACCEPTED; }).orElseThrow(() -> new
 * InvalidUsernamePasswordException("------- Invalid Username or Password ----")
 * );
 * 

Optional<Object> result = Optional.ofNullable(user.getPassword()).map(response -> {
	System.out.println("----------Inside Optional function block-------");

	if( user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
		return HttpStatus.ACCEPTED;
	}
	else
		throw new InvalidUsernamePasswordException("Invalid Username or Password");
}); //.orElseThrow(() -> new InvalidUsernamePasswordException("------- Invalid Username or Password ----"));


/*Optional.ofNullable(user).map(response -> {
			System.out.println("----------Inside Optional function block-------");

			Optional.ofNullable(user.getUsername()).ifPresent(name -> name.equals("admin"));
			Optional.ofNullable(user.getPassword()).ifPresent(password ->password.equals("admin"));
			//flag = true; return HttpStatus.ACCEPTED;
			return HttpStatus.ACCEPTED;

		}).orElseThrow(() -> new InvalidUsernamePasswordException("------- Invalid Username or Password ----"));

 */


/*boolean flag = false;
		Optional.ofNullable(user).map(response -> {
			System.out.println("----------Inside Optional function block-------");

			Optional.ofNullable(user.getUsername()).ifPresent(name -> { 
				if( user.getUsername().equals("admin")) {

					Optional.ofNullable(user.getPassword()).ifPresent(password -> {
						if(  user.getPassword().equals("admin")) {
							//flag = true; return HttpStatus.ACCEPTED;
						}
					});
				}});
			return HttpStatus.ACCEPTED;

		}).orElseThrow(() -> new InvalidUsernamePasswordException("------- Invalid Username or Password ----"));

		System.out.println("----------Returning 404 response -------");
		return HttpStatus.NOT_FOUND;*/





/*
 * try { if(user != null) {
 * System.out.println("----------Check for username and password-------");
 * if(user.getUsername().equalsIgnoreCase("admin") &&
 * user.getPassword().equalsIgnoreCase("admin")) {
 * System.out.println("----------Redirection to homepage-------"); } else {
 * throw new
 * InvalidUsernamePasswordException("----Invalid Username or Password"); } } }
 * catch(Exception e) {
 * System.out.println("--------- Inside catch block--------");
 * e.printStackTrace(); }
 */

