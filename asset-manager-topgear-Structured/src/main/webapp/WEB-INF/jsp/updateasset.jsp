<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div class="row">
		<div class="panel panel-primary">
			<div class="panel-heading" name="lblAssetDetails">
				<h2>Asset Details</h2>
			</div>
			<div class="panel-body">
				<form:form method="post" modelAttribute="asset">

					<!-- 	<fieldset class="form-group">
							<label>Employee Name</label> <input name="txtName" type="text"
								class="form-control" required="required" />
						</fieldset> -->

					<fieldset class="form-group">
						<form:label path="assetId">Asset Id</form:label>
						<form:input path="assetId" name="txtAssetID"  type="text"
							class="form-control" required="required" />
						<form:errors path="assetId" cssClass="error" />
					</fieldset>

					<fieldset class="form-group">
						<form:label path="productName">Product Name</form:label>
						<form:input path="productName" name="txtProduct" type="text"
							class="form-control" required="required" />
						<form:errors path="productName" cssClass="error" />
					</fieldset>


					<fieldset class="form-group">
						<form:label path="modelName">Model Name</form:label>
						<form:input path="modelName" name="txtModel" type="text"
							class="form-control" required="required" />
						<form:errors path="modelName" cssClass="error" />
					</fieldset>

					<fieldset class="form-group">
						<form:label path="productCondition">Condition</form:label>
						<form:input path="productCondition" name="txtCondition"
							type="text" class="form-control" required="required" />
						<form:errors path="productCondition" cssClass="error" />
					</fieldset>

					<fieldset class="form-group">
						<form:label path="productColor">Product Color</form:label>
						<form:input path="productColor" name="txtColor" type="text"
							class="form-control" required="required" />
						<form:errors path="productColor" cssClass="error" />
					</fieldset>

					<fieldset class="form-group">
						<form:label path="inUse">In Use</form:label>
						<form:select path="inUse" name="drpInUse" class="form-control"
							required="required">
							<form:option value="Yes" label="Yes" />
							<form:option value="No" label="No" />
						</form:select>
						<form:errors path="inUse" cssClass="error" />
					</fieldset>

					<fieldset class="form-group">
						<form:label path="employeeId">Employee Id</form:label>
						<form:select path="employeeId" name="drpEmployeeID"
							class="form-control" required="required">
							<form:options items="${employeeIdList}" />
						</form:select>
						<form:errors path="employeeId" cssClass="error" />
					</fieldset>
					<button name="btnSave" type="submit" class="btn btn-success">Update
						Asset</button>
				</form:form>


			</div>
		</div>
	</div>
</div>
</div>
<%@ include file="common/footer.jspf"%>