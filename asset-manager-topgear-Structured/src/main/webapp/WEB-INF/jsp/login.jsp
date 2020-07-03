<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<title>First Web Application</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	<font color="red">${errorMessage}</font>

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

					<button type="submit" class="btn btn-success">Login</button>
				</form>
			</div>
		</div>
	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>