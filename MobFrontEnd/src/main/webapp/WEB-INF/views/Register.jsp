<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
     <%@include file="/WEB-INF/views/common.jsp"%>
     
        

                
</head>
    <body class="reg">
        <h1 class="h">Register</h1>
        <div class="container rock">
       <form:form commandName="userd"  cssClass="form-horizontal" action="addinguser" method="POST">
     <div class="form-group">
    <label for="username">UserName</label>
    <form:input path="username" type="text" required="true" pattern=".{3,3}" class="form-control" id="Name"/>
  </div>
  
  <div class="form-group">
    <label for="userid">User_id</label>
    <form:input path="userid" type="text" required="true" class="form-control" id="userId" />
  </div>
  <div class="form-group">
    <label for="Password">Password</label>
    <form:input path="password" type="password" required="true" class="form-control" id="Password" />
  </div>
  
  <div class="text-center">
 <input  class="btn btn-danger" type="submit" value="Register"/>
     </div>
</form:form> 
        </div>
    </body>
</html>
