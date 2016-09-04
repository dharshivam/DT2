<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Product Table</title></head>
<spring:url value="/resources/css/bootstrap.css" var="boot"/>
        <link rel="stylesheet" href="${boot}">
<body>
<%@include file="/WEB-INF/views/suppliermenu.jsp"%>
<div class="text-center">
<h2>Products</h2>
</div>
<div class="container">
<form class="form-group">
</form>
	<table class="table table-bordered table-striped">
	<tr>
		<th></th>
		<th>Product Name</th>
		<th>Price</th>
		<th>Status</th>
		<th>Action</th>
	</tr>
	
	<c:forEach var="cart" items="${itemList}" varStatus="status">
	<tr>
	<td></td>
	<td>${cart.pname}</td>
	<td>${cart.price}</td>
	<td>${cart.stat}</td>
	<th><a  href="continue?id=${pageContext.request.userPrincipal.name}&pid=${cart.pname}&pprice=${cart.price}"class="btn btn-danger">Check out</a> <a class="btn btn-primary">Delete</a></th>
	</tr>
	</c:forEach>
</table>	
<br/>
<a  class="btn btn-danger">Check out</a>
<a href="user/back" class="btn btn-danger">Back</a>
</div>
	

</body>
<spring:url value="/resources/js/jquery.js" var="jq"/><script src="${jq}"></script>
<spring:url value="/resources/js/angular.min.js" var="a"/><script src="${a}"></script>       
</html>