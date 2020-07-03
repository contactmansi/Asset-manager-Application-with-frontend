package com.wipro.assetmanager.controller;

import com.wipro.assetmanager.dto.AssetDto;
import com.wipro.assetmanager.dto.EmployeeDto;
import com.wipro.assetmanager.service.AssetService;
import com.wipro.assetmanager.service.EmployeeService;
import com.wipro.assetmanager.service.UserService;
import com.wipro.assetmanager.dto.UserDto;
import com.wipro.assetmanager.exceptions.InvalidUsernamePasswordException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	public UserService userService;

	@Autowired
	public EmployeeService employeeService;
	
	@Autowired
	public AssetService assetService;
	
	//UPDATE ASSET
	@PutMapping("/updateasset")
	public ResponseEntity updateAsset(@RequestBody AssetDto asset) {
		assetService.updateAsset(asset);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	//View list of assets
	@RequestMapping("/viewassetlist")
	public ResponseEntity viewAssetList(@RequestParam(required=false) String assetId, 
			@RequestParam(required=false) String employeeId) {
		Object list = assetService.viewAssetList(assetId,employeeId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	//Add Asset
	@PostMapping("/addasset")
	public ResponseEntity addAsset(@RequestBody AssetDto asset) {
		assetService.addAsset(asset);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	//Add Employee
	@PostMapping("/addemployee")
	public ResponseEntity addEmployee(@RequestBody EmployeeDto employee) {
		employeeService.addEmployee(employee);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	//Login
	@PostMapping("/login")
	public ResponseEntity<HttpStatus> login(@RequestBody UserDto user) {
		System.out.println("---------- Sending login input details ------");
		HttpStatus response = userService.loginUser(user);
		System.out.println(response);
		return new ResponseEntity<HttpStatus>(response);
		
		/*try {
			userService.loginUser(user);
			//System.out.println("---------- Processed loginUser service -------");
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		catch(Exception e) {
			throw new InvalidUsernamePasswordException("------- Invalid Username or Password ----");
		}*/


		/*
		 * ResponseEntity response =
		 * Optional.ofNullable(userService.loginUser(user)).orElseThrow(() -> new
		 * InvalidUsernamePasswordException("------- Invalid Username or Password ----")
		 * );
		 */	

	}
}
