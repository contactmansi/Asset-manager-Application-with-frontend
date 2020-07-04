package com.wipro.assetmanager.dto;


public class AssetDto {

	private String assetId;

	private String employeeId;

	private String productName;

	private String modelName;

	private String productCondition;

	private String productColor;

	private String inUse;


	public AssetDto() {
		super();
	}




	public AssetDto(String assetId, String employeeId, String productName, String modelName, String productCondition,
			String productColor, String inUse) {
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
