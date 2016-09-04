<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/views/common.jsp"%>
<%@include file="/WEB-INF/views/suppliermenu.jsp"%>
</head>
<body>



  
<div class="text-center">
<h2>Products</h2>
</div>
<div class="container"  ng-app="admintable" ng-controller="admincontroller">
<c:if test="${message == 'true' }">
<div class="alert alert-success">
  <strong>Success!</strong> Edited Successfully !
</div>
</c:if>
<a class="btn btn-primary" href="apro">Add Product</a>
<form class="form-group">
<input class="form-control" placeholder="Search the List" type="search" ng-model="searchList" />
</form>
	<table class="table table-bordered table-striped">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Category</th>
		<th>Price</th>
		<th>Stock</th>
		<th>Description</th>
		<th>Action</th>
	</tr>
	
	<tr ng-repeat="show in list | filter:searchList ">
	<td>{{show.pid}}</td>
	<td>{{show.pname}}</td>
	<td>{{show.pcat}}</td>
	<td>{{show.pprice}}</td>
	<td>{{show.pstock}}</td>
	<td>{{show.pprice}}</td>
	<th><a  class="btn btn-danger" href="edit.do?id={{show.pid}}" >Edit</a> <a class="btn btn-primary" href="sdel?val={{show.pid}}">Delete</a></th>
	</tr>
</table>	
<br/>
${msg}
</div>
	
<%-- <%@include file="/WEB-INF/views/includes1.jsp"%>   --%>
<spring:url value="/resources/js/jquery.js" var="jq"/><script src="${jq}"></script>
<spring:url value="/resources/js/angular.min.js" var="a"/><script src="${a}"></script>
<spring:url value="/resources/js/admincontroller.js" var="aa"/><script src="${aa}"></script>        
</body>
      
</html>