<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h2>ASSET MANAGER HOME</h2>
				</div>
				<div class="panel-body">

					<p>

						<a class="btn btn-success" id="btnAddEmployee" href="/addemployee">Add
							Employee</a>

					</p>
					<p>
						<a class="btn btn-success" id="btnViewAssets"
							href="/viewassetlist">View Asset List</a>
					</p>

					<p>
						<a class="btn btn-success" id="btnAddAsset" href="/addasset">Add
							Asset</a>
					</p>


				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="common/footer.jspf"%>