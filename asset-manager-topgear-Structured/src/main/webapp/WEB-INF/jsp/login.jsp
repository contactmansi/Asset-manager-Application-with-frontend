<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Login</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>

<body>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h2>ASSET MANAGER</h2>
			</div>
			<div class="panel-body">
				<h2 class="form-heading">Login</h2>
				<form method="post">

					<fieldset class="form-group">
						<label>Username</label> <input name="username" type="text"
							class="form-control" required="required" />
					</fieldset>

					<fieldset class="form-group">
						<label>Password</label> <input name="password" type="password"
							class="form-control" required="required" />
					</fieldset>

					<button id= "btnSignin" type="submit" class="btn btn-success">Login</button>

					<c:if test="${not empty errorMessage}">
						<div id="errorMsg">
							<h4 class="error message">${errorMessage}</h4>
						</div>
					</c:if>
					
				</form>
			</div>
		</div>
	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>