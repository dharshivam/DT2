<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Admin-view</title></head>
<spring:url value="/resources/css/bootstrap.css" var="boot"/>
        <link rel="stylesheet" href="${boot}">
<body>
<%@include file="/WEB-INF/views/suppliermenu.jsp"%>
<a href="supplier-table" class="btn btn-info">Manage-Supplier</a>
<a href="user-table" class="btn btn-info">Manage-users</a>
<a href="product-table" class="btn btn-info">Manage-products</a>

</body>
</html>
