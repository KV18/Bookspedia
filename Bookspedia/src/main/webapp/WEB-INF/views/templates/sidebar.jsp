<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1 class="my-4">Shop Name</h1>
<div class="list-group">
<c:forEach items="${categoryList}" var="category">
	<a href="${contextRoot}/show/category/${category.categoryId}/products" id="a_${category.categoryName}"class="list-group-item">${category.categoryName}</a>
</c:forEach> 
</div>