 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@include file="/WEB-INF/views/common.jsp"%>

        <spring:url value="/resources/css/common.css" var="common"/>
<link rel="stylesheet" href="${common}">
        
    </head>
    <body>
        <header>Sign In</header>
    <div class="container for">
 <form:form  commandName="users" action="login" cssClass="form-horizontal" method="POST" >
         <div class="form-group">
    <label for="USER_ID">USER-ID</label>
    <form:input path="user_id" type="text" value="${users.user_id}" required="true" class="form-control" id="ID"/>
  </div>
  </div>
  </form:form>