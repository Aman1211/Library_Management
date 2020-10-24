<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
  <h3> Welcome:-<%=session.getAttribute("user") %> </h3>
  <% if(session.getAttribute("user")!=null){ %>
  <a href="<%= application.getContextPath() %>/Controller?action=logout">Logout</a><br>
  <a href="<%= application.getContextPath() %>/Controller?action=changepassword">Change Password</a>
  <%} %>
  
</body>
</html>