<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div class="row">
			<div class="panel panel-primary">
				<div class="panel-heading"> <h2>Add Employee</h2> </div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="employee">

						<!-- 	<fieldset class="form-group">
							<label>Employee Name</label> <input name="txtName" type="text"
								class="form-control" required="required" />
						</fieldset> -->

						<fieldset class="form-group">
							<form:label path="id">Employee ID</form:label>
							<form:input path="id" name="txtEmployeeID" type="text"
								class="form-control" required="required" />
							<form:errors path="id" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="surname">Employee Surname</form:label>
							<form:input path="surname" name="txtSurname" type="text"
								class="form-control" />
							<form:errors path="surname" cssClass="text-warning" />
						</fieldset>


						<fieldset class="form-group">
							<form:label path="name">Employee Name</form:label>
							<form:input path="name" name="txtName" type="text"
								class="form-control" required="required" />
							<form:errors path="name" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="number">Mobile Number</form:label>
							<form:input path="number" name="txtMobile" type="text"
								class="form-control" />
							<form:errors path="number" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="location">Location</form:label>
							<form:input path="location" name="txtLocation" type="text"
								class="form-control" />
							<form:errors path="location" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="designation">Designation</form:label>
							<form:input path="designation" name="txtDesignation" type="text"
								class="form-control" required="required" />
							<form:errors path="designation" cssClass="text-warning" />
						</fieldset>

						<button name="addEmployee" type="submit" class="btn btn-success">Add
							Employee</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>