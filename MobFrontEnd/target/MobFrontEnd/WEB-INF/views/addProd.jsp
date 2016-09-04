<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:url value="/resources/css/bootstrap.css" var="boot" />
<link rel="stylesheet" href="${boot}">
<title>Supplier Product</title>
<%@include file="/WEB-INF/views/suppliermenu.jsp"%>

<h1 class="text-center">Add Products</h1>
<br />
<br />
<form:form modelAttribute="prod" cssClass="form-horizontal"
	action="addingPro" method="POST">

	<div class="form-group">
		<label for="pid" class="col-sm-2 control-label"> Product Id:</label>
		<div class="col-sm-8">
			<form:input path="pid" value="${prod.pid}" cssClass="form-control"
				title="Enter product id" required="true" />
		</div>
	</div>

	<div class="form-group">
		<label for="name" class="col-sm-2 control-label"> Name:</label>
		<div class="col-sm-8">
			<form:input path="pname" value="${prod.pname}"
				cssClass="form-control" title="Enter product name" />
		</div>
	</div>
	<div class="form-group">
		<label for="category" class="col-sm-2 control-label">
			Category:</label>
		<div class="col-sm-8">
			<form:input path="pcat" value="${prod.pcat}" cssClass="form-control"
				title="Enter product category" />
		</div>
	</div>
	<div class="form-group">
		<label for="pprice" class="col-sm-2 control-label"> Price:</label>
		<div class="col-sm-8">
			<form:input path="pprice" value="${prod.pprice}"
				cssClass="form-control" title="Enter price of the product" />
		</div>
	</div>
	<div class="form-group">
		<label for="pstock" class="col-sm-2 control-label"> Stock:</label>
		<div class="col-sm-8">
			<form:input path="pstock" value="${prod.pstock}"
				cssClass="form-control" title="Enter stock of the product" />
		</div>
	</div>
	<div class="form-group">
		<label for="pdes" class="col-sm-2 control-label"> Description:</label>
		<div class="col-sm-8">
			<form:input path="pdes" value="${prod.pdes}" cssClass="form-control"
				title="Enter description of the product" />
		</div>
	</div>
	<div class="form-group text-center">
		<input type="submit" value="SAVE" class="btn btn-primary " />
	</div>

</form:form>
<h1>${successMessage }</h1>
<%-- <%@include file="/WEB-INF/views/includes1.jsp"%> --%>
<spring:url value="/resources/js/jquery.js" var="jq"/><script src="${jq}"></script>
<spring:url value="/resources/js/angular.min.js" var="a"/><script src="${a}"></script>
<spring:url value="/resources/js/admincontroller.js" var="aa"/><script src="${aa}"></script>        
</body>
</html>