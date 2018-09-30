<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Bookspedia | ${title}</title>

<script type="text/javascript">
	window.menu = '${title}';
	
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myStyle.css" rel="stylesheet">

<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.18/datatables.min.css"/>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">   

<link href="https://fonts.googleapis.com/css?family=Bai+Jamjuree" rel="stylesheet">   
    
</head>

<body>

	<div class="wrapper">
		
		<div class="content">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="jumbotron">
							<div class="col-sm-4">
								<i class="far fa-sad-tear" style="font-size:150px"></i>
							</div>
							<div class="col-sm-7">
							<h1>${errorTitle}</h1>
							<hr />
							<blockquote style="word-wrap:break-word;">
								${errorDescription}
							</blockquote>
							<a href="${contextRoot}/home" class="btn btn-primary">Back to Home</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- footer -->
		<%@include file="/WEB-INF/views/templates/footer.jsp"%>


		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.min.js"></script>
		<script src="${js}/bootstrap.min.js"></script>
		<script src="${js}/jquery.dataTables.js"></script>
		<script src="${js}/dataTables.bootstrap.js"></script>
		<script src="${js}/myScript.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.18/datatables.min.js"></script>
	</div>
</body>

</html>
