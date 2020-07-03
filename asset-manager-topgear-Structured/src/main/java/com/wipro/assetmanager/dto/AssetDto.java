package com.wipro.assetmanager.dto;


public class AssetDto {

	private String assetID;

	private String employeeID;

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
		this.assetID = assetId;
		this.employeeID = employeeId;
		this.productName = productName;
		this.modelName = modelName;
		this.productCondition = productCondition;
		this.productColor = productColor;
		this.inUse = inUse;
	}




	public String getAssetId() {
		return assetID;
	}



	public void setAssetId(String assetId) {
		this.assetID = assetId;
	}





	public String getEmployeeId() {
		return employeeID;
	}




	public void setEmployeeId(String employeeId) {
		this.employeeID = employeeId;
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
		return "AssetDto [assetId=" + assetID + ", employeeID=" + employeeID + ", productName=" + productName
				+ ", modelName=" + modelName + ", productCondition=" + productCondition + ", productColor="
				+ productColor + ", inUse=" + inUse + "]";
	}




}
