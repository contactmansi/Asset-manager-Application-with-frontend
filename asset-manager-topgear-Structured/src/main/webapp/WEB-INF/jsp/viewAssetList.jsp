<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<title>View Asset List</title>
<div class="container">

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>View Asset List</h3>
		</div>
		<div class="panel-body">
			<form method="post">

				<fieldset class="form-group">
					<label>Asset Id</label> <input name="txtSearchAssetId" type="text"
						class="form-control" />
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Id</label> <input name="txtSearchEmployeeId"
						type="text" class="form-control" />
				</fieldset>

				<button name="btnSearch" type="submit" class="btn btn-success">Search</button>

				<c:if test="${not empty errorMessage}">
					<div id="errorMsg">
						<h4 class="error message">${errorMessage}</h4>
					</div>
				</c:if>

			</form>
		</div>
	</div>
	<table class="table table-striped">
		<!-- <caption>View Asset List</caption> -->
		<thead>
			<tr>
				<th>Asset ID</th>
				<th>Product</th>
				<th>Model</th>
				<th>Color</th>
				<th>Condition</th>
				<th>In Use</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${assets}" var="asset" varStatus="myIndex">
				<tr>

					<td><a type="button" class="button"
						href="/updateasset?assetabc=${asset.assetId}">${asset.assetId}</a></td>
					<td><label id = "prod_${myIndex.count}">${asset.productName}</label></td>
					<td><label id = "model_${myIndex.count}">${asset.modelName}</label></td>
					<td><label id = "color_${myIndex.count}">${asset.productColor}</label></td>
					<td><label id = "condition_${myIndex.count}">${asset.productCondition}</label></td>
					<td><label id = "inUse_${myIndex.count}">${asset.inUse}</label></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- <div>
		<a class="button" href="/add-todo">Add a Todo</a>
	</div> -->
</div>
<%@ include file="common/footer.jspf"%>