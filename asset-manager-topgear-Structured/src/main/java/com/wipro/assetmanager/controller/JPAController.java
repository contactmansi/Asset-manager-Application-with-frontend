package com.wipro.assetmanager.controller;

import com.wipro.assetmanager.dto.AssetDto;
import com.wipro.assetmanager.dto.EmployeeDto;
import com.wipro.assetmanager.service.AssetService;
import com.wipro.assetmanager.service.EmployeeService;
import com.wipro.assetmanager.service.UserService;
import com.wipro.assetmanager.dto.UserDto;


import org.springframework.beans.factory.annotation.Autowired;
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

	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) { // Date -
	 * dd/MM/yyyy SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	 * binder.registerCustomEditor(Date.class, new CustomDateEditor( dateFormat,
	 * false)); }
	 */

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model){
		return "login";
	}


	/*  @RequestMapping(value="/login", method = RequestMethod.POST) public String
	  showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam
	  String password){

	  boolean isValidUser = service.validateUser(name, password);

	  if (!isValidUser) { 
	  model.put("errorMessage", "Invalid Credentials"); 
	  return "login"; }

	  model.put("name", name); model.put("password", password);

	  return "welcome"; 
	  }*/


	//@RequestMapping(value = "/login", method = RequestMethod.POST)
	@PostMapping("/login")   
	public String registration(@ModelAttribute("user") UserDto user) {

		System.out.println("---------- Sending login input details ------");
		HttpStatus response = userService.loginUser(user);
		System.out.println("----- RESPONSE -------"+response);

		if (!response.equals(HttpStatus.ACCEPTED)) {
			// model.addAttribute("error", "Your username and password is invalid.");
			return "login";
		}

		return "home";
	}

	//Login
	/*@PostMapping("/login")
	public String login(ModelMap model, @RequestBody UserDto user) {
		System.out.println("---------- Sending login input details ------");
		HttpStatus response = userService.loginUser(user);
		System.out.println(response);
		model.put("user", user);
		return "home";

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


	}*/

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
	//@GetMapping("/addemployee")
	@RequestMapping(value = "/addemployee", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		//model.addAttribute("addEmployee", new EmployeeDto());
		return "addEmployee";
	}

	//Add Employee
	@PostMapping("/addemployee")
	public String addEmployee(@RequestBody EmployeeDto employee) {
		employeeService.addEmployee(employee);
		//return new ResponseEntity<>(HttpStatus.CREATED);*/
		return "home";//"redirect:/home"
	}


}
