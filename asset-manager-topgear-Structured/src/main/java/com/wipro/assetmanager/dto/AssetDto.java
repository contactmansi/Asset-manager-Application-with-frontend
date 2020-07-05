package com.wipro.assetmanager.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AssetDto {

	@NotNull(message = "Asset Id is mandatory")
	@Pattern(regexp = "^[A-Za-z0-9]+$", message = "Asset Id should be alpha numeric")
	@Size(max=30, message="Only 30 characters allowed")
	private String assetId;

	@NotNull(message = "Employee Id is mandatory field")
	@Pattern(regexp = "^[A-Za-z0-9]+$", message = "Employee Id should be alpha numeric")
	@Size(max=30, message="Only 30 characters allowed")
	private String employeeId;
	
	@NotBlank(message = "Product field is mandatory")
	@Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Product should be alpha numeric")
	@Size(max=30, message="Only 30 characters allowed")
	private String productName;

	@NotEmpty(message = "Model field is mandatory")
	@Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Model should be alpha numeric")
	@Size(max=30, message="Only 30 characters allowed")
	private String modelName;

	@NotNull(message = "Condition field is mandatory")
	@Pattern(regexp = "^[A-Za-z ]*$", message = "Condition should be alphabets only")
	@Size(max=30, message="Only 30 characters allowed")
	private String productCondition;

	@NotNull(message = "Color field is mandatory")
	@Pattern(regexp = "^[A-Za-z ]*$", message = "Color should be alphabets only")
	@Size(max=30, message="Only 30 characters allowed")
	private String productColor;

	private String inUse;


	public AssetDto() {
		super();
	}


	public AssetDto(
			@NotNull(message = "Asset Id is mandatory") @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Asset Id should be alpha numeric") String assetId,
			@NotNull(message = "Employee Id is mandatory field") @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Employee Id should be alpha numeric") String employeeId,
			@NotNull(message = "Product field is mandatory") @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Product should be alpha numeric") String productName,
			@NotEmpty(message = "Model field is mandatory") @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Model should be alpha numeric") String modelName,
			@NotNull(message = "Condition field is mandatory") @Pattern(regexp = "^[A-Za-z ]*$", message = "Condition should be alphabets only") String productCondition,
			@NotNull(message = "Color field is mandatory") @Pattern(regexp = "^[A-Za-z ]*$", message = "Color should be alphabets only") String productColor,
			String inUse) {
		super();
		this.assetId = assetId;
		this.employeeId = employeeId;
		this.productName = productName;
		this.modelName = modelName;
		this.productCondition = productCondition;
		this.productColor = productColor;
		this.inUse = inUse;
	}





	public String getAssetId() {
		return assetId;
	}



	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}





	public String getEmployeeId() {
		return employeeId;
	}




	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}




	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getModelName() {
		return modelName;
	}



	public void setModelName(String modelName) {
		this.modelName = modelName;
	}



	public String getProductCondition() {
		return productCondition;
	}



	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}



	public String getProductColor() {
		return productColor;
	}



	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}



	public String getInUse() {
		return inUse;
	}



	public void setInUse(String inUse) {
		this.inUse = inUse;
	}



	@Override
	public String toString() {
		return "AssetDto [assetId=" + assetId + ", employeeId=" + employeeId + ", productName=" + productName
				+ ", modelName=" + modelName + ", productCondition=" + productCondition + ", productColor="
				+ productColor + ", inUse=" + inUse + "]";
	}




}
