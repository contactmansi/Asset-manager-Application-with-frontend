package com.wipro.assetmanager.model;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Asset {

	@Id
	@NotNull(message = "Asset Id is mandatory")
	@Pattern(regexp = "^[A-Za-z0-9]+$", message = "Asset Id should be alpha numeric")
	private String assetId;
	
	//Foreign key should reference to Employee.id
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee", referencedColumnName = "id")
	private Employee employee;

	@NotNull(message = "Product field is mandatory")
	@Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Product should be alpha numeric")
	private String productName;

	@NotEmpty(message = "Model field is mandatory")
	@Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Model should be alpha numeric")
	private String modelName;

	@NotNull(message = "Condition field is mandatory")
	@Pattern(regexp = "^[A-Za-z ]*$", message = "Condition should be alphabets only")
	private String productCondition;

	@NotNull(message = "Color field is mandatory")
	@Pattern(regexp = "^[A-Za-z ]*$", message = "Color should be alphabets only")
	private String productColor;

	//Allow only yes/No values
	@Value("No") 
	private String inUse;

	private Instant time;
	
	

	public Asset() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Asset(
			@NotNull(message = "Asset Id is mandatory") @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Asset Id should be alpha numeric") String assetId,
			Employee employeeId,
			@NotNull(message = "Product field is mandatory") @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Product should be alpha numeric") String productName,
			@NotEmpty(message = "Model field is mandatory") @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Model should be alpha numeric") String modelName,
			@NotNull(message = "Condition field is mandatory") @Pattern(regexp = "^[A-Za-z ]*$", message = "Condition should be alphabets only") String productCondition,
			@NotNull(message = "Color field is mandatory") @Pattern(regexp = "^[A-Za-z ]*$", message = "Color should be alphabets only") String productColor,
			String inUse, Instant time) {
		super();
		this.assetId = assetId;
		this.employee = employeeId;
		this.productName = productName;
		this.modelName = modelName;
		this.productCondition = productCondition;
		this.productColor = productColor;
		this.inUse = inUse;
		this.time = time;
	}

	public String getAssetId() {
		return assetId;
	}



	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public Employee getEmployeeId() {
		return employee;
	}



	public void setEmployeeId(Employee employeeId) {
		this.employee = employeeId;
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



	public Instant getTime() {
		return time;
	}


	public void setTime(Instant time) {
		this.time = time;
	}



	@Override
	public String toString() {
		return "Asset [assetId=" + assetId + ", employeeId=" + employee + ", productName=" + productName
				+ ", modelName=" + modelName + ", productCondition=" + productCondition + ", productColor="
				+ productColor + ", inUse=" + inUse + ", time=" + time + "]";
	}
	
	
	

}
