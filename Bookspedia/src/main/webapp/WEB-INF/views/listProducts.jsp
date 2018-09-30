<div class="container">
	<div class="row">
		<div class="col-md-3">
			<%@ include file="/WEB-INF/views/templates/sidebar.jsp" %>
		</div>

		<div class="col-md-9">

			<div class="row">
				<div class="col-lg-12">
				<c:if test="${userClickAllProducts == true}">
				
					<Script>
						window.categoryId = '';
					</Script>
				
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href=" ${contextRoot}/home">Home</a></li>
						<li class="breadcrumb-item active">All Products</li>
						
					</ol>
				</c:if>
				<c:if test="${userClickCategoryProducts == true}">
					
					<Script>
						window.categoryId = '${category.categoryId}';
					</Script>
					
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href=" ${contextRoot}/home">Home</a></li>
						<li class="breadcrumb-item active">Category Products</li>
						<li class="breadcrumb-item active">${category.categoryName}</li>
						
					</ol>
				</c:if>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12">
					<table id="productListTable" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Quantity</th>
								<th></th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Quantity</th>
								<th></th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>