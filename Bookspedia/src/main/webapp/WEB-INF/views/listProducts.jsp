<div class="container">
	<div class="row">
		<div class="col-md-3">
			<%@ include file="/WEB-INF/views/templates/sidebar.jsp" %>
		</div>
		<div class="col-md-9">
		<!-- Breadcrumb -->
			<div class="row">
				<div class="col-lg-12">
				<c:if test="${userClickAllProducts == true}">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href=" ${contextRoot}/home">Home</a></li>
						<li class="breadcrumb-item active">All Products</li>
						
					</ol>
				</c:if>
				<c:if test="${userClickCategoryProducts == true}">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href=" ${contextRoot}/home">Home</a></li>
						<li class="breadcrumb-item active">Category Products</li>
						<li class="breadcrumb-item active">${category.categoryName}</li>
						
					</ol>
				</c:if>
				</div>
			</div>
		</div>
	</div>
</div>