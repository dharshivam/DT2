 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@include file="/WEB-INF/views/common.jsp"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <spring:url value="/resources/css/common.css" var="common"/>
<link rel="stylesheet" href="${common}">

        

</head>
<body>
	
	

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Mob Store</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="#">About</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <!-- <li><a href="logins"><span class="glyphicon glyphicon-log-in"></span>  Login</a></li> -->
        <li><a href="register"><span class="glyphicon glyphicon-paste"></span>  SignUp</a></li>
      </ul>
    </div>
  </div>
</nav>
    
    
        <h2 class="text-center">Sign In</h2>
    <div class="container" style="padding-right:25%;">
    
    
 <form action="<c:url value='/j_spring_security_check' />" class="form-group text-center" method='POST'>

			<table>
				<tr>
					<td>User:</td>
					<td><input type='text' class="form-control" name='username'></td>
					</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' class="form-control" name='password' /></td>
				</tr>
				<tr>
					<td><input name="submit" class="btn btn-success center-text" type="submit"
						value="submit" /></td>
				</tr>
			</table>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>
		
        </div>
        
        <c:if test="${msg == true}">
  <div class="alert alert-danger fade in">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Error !</strong>Either User id or Password in incorrect ! Try Again
  </div>
  </c:if>
        <%-- <div class="mg">
        <spring:url value="/resources/img/w3.png" var="w3"/><img src="${w3}" class="center-block">
        </div> --%>
    </body>
</html>
  