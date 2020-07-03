package com.wipro.assetmanager.mapper;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wipro.assetmanager.dto.AssetDto;
import com.wipro.assetmanager.model.Asset;
import com.wipro.assetmanager.model.Employee;
import com.wipro.assetmanager.repository.EmployeeRepository;

@Component
public class AssetMapper {
	
	@Autowired
	public Asset model;
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	public Asset mapDto(AssetDto assetDto) {
		
		Optional.ofNullable(assetDto.getAssetId()).ifPresent(assetId -> model.setAssetId(assetId));
		Optional.ofNullable(assetDto.getModelName()).ifPresent(modelName -> model.setModelName(modelName));
		Optional.ofNullable(assetDto.getProductColor()).ifPresent(color-> model.setProductColor(color));
		Optional.ofNullable(assetDto.getProductCondition()).ifPresent(condition -> model.setProductCondition(condition));
		Optional.ofNullable(assetDto.getProductName()).ifPresent(productName -> model.setProductName(productName));
		/*
		 * Optional.ofNullable(assetDto.getEmployeeId()).ifPresent( employeeID ->
		 * model.setEmployeeId( employeeRepository.findById(employeeID).get()));
		 */
		
		Optional.ofNullable(assetDto.getEmployeeId()).ifPresent(
				employeeID -> Optional.ofNullable(
								employeeRepository.findById(employeeID).get()).ifPresent(
										employee -> model.setEmployeeId(employee)));				
		
		Optional.ofNullable(assetDto.getInUse()).ifPresent(inUse -> model.setInUse(inUse));
		model.setTime(Instant.now());
		return model;
	}

}
