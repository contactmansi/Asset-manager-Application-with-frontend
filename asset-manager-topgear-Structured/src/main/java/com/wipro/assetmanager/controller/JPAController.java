package com.wipro.assetmanager.controller;

import com.wipro.assetmanager.dto.AssetDto;
import com.wipro.assetmanager.dto.EmployeeDto;
import com.wipro.assetmanager.service.AssetService;
import com.wipro.assetmanager.service.EmployeeService;
import com.wipro.assetmanager.service.UserService;
import com.wipro.assetmanager.dto.UserDto;
import com.wipro.assetmanager.model.Asset;
import com.wipro.assetmanager.model.Employee;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
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
	
	//LOGIN

	@GetMapping("/login") 
	public String showLoginPage(ModelMap model){
		return "login";
	}

	@PostMapping("/login")   
	public String login(@Valid @ModelAttribute("user") UserDto user) {

		System.out.println("---------- Sending login input details ------");
		HttpStatus response = userService.loginUser(user);
		System.out.println("----- RESPONSE -------"+response);

		if (!response.equals(HttpStatus.ACCEPTED)) {
			//model.addAttribute("error", "Your username and password is invalid.");
			return "login";
		}

		return "home";
	}
	
	@ModelAttribute("user")
	public UserDto user() {
		return new UserDto();
	}

	//HOME

	@GetMapping("/home") 
	public String showHome(ModelMap model){
		return "home";
	}
	
	@GetMapping("/logout") 
	public String logout(ModelMap model){
		return "redirect:/login";
	}

	//Add Employee

	@GetMapping("/addemployee")
	public String showAddEmployee(ModelMap model) {
		model.addAttribute("employee", new EmployeeDto());
		return "addEmployee";
	}

	@PostMapping("/addemployee")
	public String addEmployee(@Valid @ModelAttribute("employee") EmployeeDto employee, BindingResult result) {
		if (result.hasErrors()) {

			return "addEmployee";
		}
		employeeService.addEmployee(employee);
		return "redirect:/home";
	}

	//Add Asset

	@GetMapping("/addasset")
	public String showAddAsset(ModelMap model) {
		List<Employee> employeeIdList = employeeService.getEmployeeIdList();
		model.addAttribute("employeeIdList", employeeIdList);

		model.addAttribute("asset", new AssetDto());
		return "asset";
	}

	@PostMapping("/addasset")
	public String addEmployee(@Valid @ModelAttribute("asset") AssetDto asset, ModelMap model, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("employeeIdList", employeeService.getEmployeeIdList());
			return "asset";
		}
		assetService.addAsset(asset);
		return "redirect:/home";
	}

	////UPDATE ASSET /updateasset		
	@GetMapping("/updateasset")
	public String showupdateAsset(@RequestParam String assetabc, ModelMap model) {

		Object asset = assetService.getAssetByID(assetabc);
		model.addAttribute("asset", asset);

		List<Employee> employeeIdList = employeeService.getEmployeeIdList();
		model.addAttribute("employeeIdList", employeeIdList);

		return "updateasset";
	}


	@PostMapping("/updateasset")
	public String updateAsset(@Valid @ModelAttribute("asset") AssetDto asset, BindingResult result) {
		if (result.hasErrors()) {
			return "updateasset";
		}
		assetService.updateAsset(asset);
		return "redirect:/home";
	}

	//View list of assets
	@GetMapping("/viewassetlist")
	public String showviewAssetList(ModelMap model) {
		return "viewAssetList";
	}

	@PostMapping("/viewassetlist")
	public String viewAssetList( @ModelAttribute("txtSearchAssetId") String txtSearchAssetId, 
			@ModelAttribute("txtSearchEmployeeId") String txtSearchEmployeeId, ModelMap model) {

		List<Asset> assets = assetService.viewAssetList(txtSearchAssetId,txtSearchEmployeeId);
		model.addAttribute("assets", assets);
		return "viewAssetList";
	}

}
