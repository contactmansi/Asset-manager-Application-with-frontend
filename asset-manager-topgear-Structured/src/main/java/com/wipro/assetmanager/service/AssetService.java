package com.wipro.assetmanager.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wipro.assetmanager.dto.AssetDto;
import com.wipro.assetmanager.exceptions.GenericException;
import com.wipro.assetmanager.mapper.AssetMapper;
import com.wipro.assetmanager.model.Asset;
import com.wipro.assetmanager.model.Employee;
import com.wipro.assetmanager.repository.AssetRepository;
import com.wipro.assetmanager.repository.EmployeeRepository;

@Service
public class AssetService {

	@Autowired
	public AssetMapper mapper;

	@Autowired
	public AssetRepository assetRepository;

	@Autowired
	public EmployeeRepository employeeRepository;

	public void addAsset(AssetDto assetDto) {
		// TODO Auto-generated method stub
		try {
			//Mapping
			Asset model = mapper.mapDto(assetDto);
			//Save into Asset Model
			assetRepository.save(model);
		}
		catch(Exception e) {
			System.out.println("--------- PRINTING STACK TRACE-----");
			e.printStackTrace();
			throw new GenericException("Error occurred while saving");
		}
	}
	

	public void updateAsset(AssetDto assetDto) {
		try {
			//Mapping
			Asset model = mapper.mapDto(assetDto);
			//Save into Asset Model
			assetRepository.save(model);
		}
		catch(Exception e) {
			//REMOVE these two statements later
			System.out.println("--------- PRINTING STACK TRACE-----");
			e.printStackTrace();
			throw new GenericException("Error occurred while saving");
		}	
		
	}

	public Object viewAssetList(String assetId, String employeeId) {

		if(assetId.isBlank() && employeeId.isBlank()) //both null
			throw new GenericException("No records found");

		else if(!assetId.isBlank()) { // assetId present in inputs
			Optional<Asset> asset = assetRepository.findById(assetId);
			if(!asset.isPresent()) {
				throw new GenericException("No records found");
			}
			//Optional<Object> list = Optional.ofNullable(assetId).map(Id -> assetRepository.findById(Id));

			/*
			 * Optional.ofNullable(employeeId).ofNullable(
			 * asset.get().getEmployeeId().getId().equals(employeeId)).orElseThrow(() -> new
			 * GenericException("No records found"));
			 */


			if(employeeId!=null) { //EmployeeId also present in inputs
				if(!asset.get().getEmployeeId().getId().equals(employeeId)) {

					System.out.println("---- Exception from employeeID comparison---"); throw new
					GenericException("No records found"); }

			}
			return asset.get();
		}
		
		//Only Employee Id in inputs --> return list of assets from Asset Repo
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if(!employee.isPresent()) 
			throw new GenericException("No records found");
		
		
		Optional<List<Asset>> asset = assetRepository.findByEmployee(employee.get());
		if(!asset.isPresent()) {
			throw new GenericException("No records found");
		}
		
		//Sort assets acc to Asset ID
		Collections.sort(asset.get(), new Comparator<Asset>() { 
			public int compare(Asset o1, Asset o2) { 
				return o1.getAssetId().compareTo(o2.getAssetId()); 
			} 
		});
		return asset.get();		

	}
		

}
