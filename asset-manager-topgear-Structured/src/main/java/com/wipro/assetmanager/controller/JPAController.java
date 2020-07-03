package com.wipro.assetmanager.controller;

import com.wipro.assetmanager.dto.AssetDto;
import com.wipro.assetmanager.dto.EmployeeDto;
import com.wipro.assetmanager.service.AssetService;
import com.wipro.assetmanager.service.EmployeeService;
import com.wipro.assetmanager.service.UserService;
import com.wipro.assetmanager.dto.UserDto;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class JPAController {

	@Autowired
	public UserService userService;

	@Autowired
	public EmployeeService employeeService;

	@Autowired
	public AssetService assetService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	@GetMapping("/login") 
	public String showLoginPage(ModelMap model){
		return "login";
	}

	@PostMapping("/login")   
	public String registration(@ModelAttribute("user") UserDto user) {

		System.out.println("---------- Sending login input details ------");
		HttpStatus response = userService.loginUser(user);
		System.out.println("----- RESPONSE -------"+response);

		if (!response.equals(HttpStatus.ACCEPTED)) {
			//model.addAttribute("error", "Your username and password is invalid.");
			return "login";
		}

		return "home";
	}

	@GetMapping("/home") 
	public String showHome(ModelMap model){
		return "home";
	}
	//Add Employee
	@GetMapping("/addemployee")
	public String showAddEmployee(ModelMap model) {
		model.addAttribute("employee", new EmployeeDto());
		return "addEmployee";
	}

	//Add Employee
	@PostMapping("/addemployee")
	public String addEmployee(@ModelAttribute("employee") EmployeeDto employee) {
		employeeService.addEmployee(employee);
		return "redirect:/home";
	}

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




}
