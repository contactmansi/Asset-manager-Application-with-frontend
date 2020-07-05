<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>View Asset List</h3>
		</div>
		<div class="panel-body">
			<form method = "post" > <!-- action="viewassetlist" -->

				<fieldset class="form-group">
					<label>Asset Id</label> <input name="txtSearchAssetId" type="text"
						class="form-control" />
					</fieldset>

					<fieldset class="form-group">
						<label>Employee Id</label> <input name="txtSearchEmployeeId"
							type="text" class="form-control" />
					</fieldset>

					<button type="submit" class="btn btn-success">Search</button>
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
			<c:forEach items="${assets}" var="asset">
				<tr>

					<td><a type="button" class="button" href="/updateasset?assetabc=${asset.assetId}">${asset.assetId}</a></td>
					<td>${asset.productName}</td>
					<td>${asset.modelName}</td>
					<td>${asset.productColor}</td>
					<td>${asset.productCondition}</td>
					<td>${asset.inUse}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- <div>
		<a class="button" href="/add-todo">Add a Todo</a>
	</div> -->
</div>
<%@ include file="common/footer.jspf"%>