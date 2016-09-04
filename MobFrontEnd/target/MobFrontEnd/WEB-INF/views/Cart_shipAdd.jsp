<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
     <%@include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

        <h1 class="h">Shipping Address</h1>
        <div class="container rock">
        
       <form:form modelAttribute="order" cssClass="form-horizontal" method="POST">
    <div class="form-group">
    <label for="Name">Name</label>
    <form:input  type="text" path="name" value="${order.name}" class="form-control" id="Name" required="true"/>
  </div>
  <div class="form-group">
    <label for="Address">Address</label>
    <form:input type="text" path="shipping_address"  value="${order.shipping_address}" class="form-control" id="address" required="true"/>
  </div>
   <div class="form-group">
    <label for="Ph no">Mobile Number</label>
    <form:input type="text" path="contact_no" value=" ${order.contact_no}"  class="form-control" id="Ph no" required="true"/>
  </div>
  
  <div class="text-center">
 <a  class="btn btn-danger" href="confirm" type="submit">Submit</a>
     </div>
</form:form> 
        </div>

</body>
</html>