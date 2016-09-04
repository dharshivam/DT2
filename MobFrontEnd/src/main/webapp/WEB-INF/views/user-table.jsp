<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/views/common.jsp"%>
</head>
<body>

<form class="form-group">
<input class="form-control" placeholder="Search the List" type="search" ng-model="searchList" />
</form>
	<table class="table table-bordered table-striped">
	<tr>
		<th>user_id</th>
		<th>Name</th>
		<th>Category</th>
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
	
<%@include file="/WEB-INF/views/includes1.jsp"%>  
</body>
      
</html>