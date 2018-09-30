<div class="container">
	<!-- breadcrumb -->
	<div class="row">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
				<li class="breadcrumb-item"><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="breadcrumb-item active">${product.productName}</li>
			</ol>
		</div>
	</div>
	
	<div class="row">
		<!-- Product Image -->
		<div class="col-xs-12 col-sm-4">
			<div class="img-thumbnail">
				<img src="${images}/${product.productCode}.jpg" class="img img-fluid"/>
			</div>
		</div>
		<!-- product description -->
		<div class="col-xs-12 col-sm-8">
			<h3>${product.productName}</h3>
			<hr />
			<p>${product.productDescription}</p>
			<hr />
			<h4>Price: 	<strong> &#8377; ${product.unitPrice} /-</strong></h4>
			<hr />
			
			
			<c:choose>
				<c:when test="${product.quantity <1}">
					<h6>Qty.Available: <span style="color:red">Out Of Stock</span></h6>
				</c:when>
				<c:otherwise>
					<h6>Qty. Available: ${product.quantity}</h6>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${product.quantity <1}">
					<a href="javascript:void(0)" class="btn btn-success disabled"><i class="fas fa-cart-plus"></i><strike> Add To Cart</strike></a>
				</c:when>
				<c:otherwise>
					<a href="${contextRoot}/cart/add/${product.productId}/product" class="btn btn-success"><i class="fas fa-cart-plus"></i> Add To Cart</a>
				</c:otherwise>
			</c:choose>			
			
			<a href="${contextRoot}/show/all//products" class="btn btn-danger">Back</a>
		</div>
	</div>
</div>