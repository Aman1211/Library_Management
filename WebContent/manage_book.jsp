<<<<<<< HEAD
<%@ include file="adminhead.jsp" %> 
      <div class="container-fluid">
       Manage all books here
        <a href="<%=application.getContextPath()%>/Controller?action=addbook"> Add New Book </a>
      </div>
 <%@ include file="adminfoot.jsp"%>
=======

<%@page pageEncoding="UTF-8" import="library.model.BookBean,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<script src="//code.jquery.com/jquery-3.5.1.js"></script>
<script src="//cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
<script src="//cdn.datatables.net/1.10.22/js/dataTables.bootstrap4.min.js"></script>

<link href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css" rel="stylesheet" id="bootstrap-css">
<link href="//cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css" rel="stylesheet" id="bootstrap-css">
<script>
$(document).ready(function() {
    $('#example').DataTable();
} );</script>
</head>

<body>
 <% ArrayList<BookBean>bb=new ArrayList<>();
   bb=(ArrayList<BookBean>)session.getAttribute("Itemlist");
 %>
 <%@ include file="adminhead.jsp" %>  
       <div class="container">
        
  <table id="example" class="table table-striped table-bordered" style="width:100%">
    <thead>
      <tr>
      <th>Title</th>
        <th>Author</th>
        <th>ISBN</th>
        <th>Category</th>
        <th>Quantity</th>
        <th>Rack</th>
        <th>Image</th>
        <th>Edit</th>
        <th>Delete</th>
      </tr>
    </thead>
    <tbody>
<% if(bb==null){
	 out.println("<tr><td colspan=\"4\">No Items Found</td></tr>");
 }
 else
 {
	for(BookBean b:bb){  
		String isbn = b.getISBN();
	 %>

      <tr>
        <td><%=b.getTitle() %></td>
        <td> <%=b.getAuthor() %></td>
        <td><%=b.getISBN() %></td>
        <td><%=b.getCategory() %></td>
        <td><%=b.getQty() %></td>
        <td><%=b.getRack() %></td>
        <td><img src=<%= b.getImage() %> height="100px" alt="..."></td>
        <td><a href="<%= application.getContextPath() %>/Controller?action=editbook&isbn=<%= isbn %>">Edit</a></td>
        <td><a href="<%= application.getContextPath() %>/Controller?action=deletebookvalidate&isbn=<%= isbn %>">Delete Book</a></td>
       
      </tr>
       <% }} %>
    </tbody>
  </table>
</div>
 <%@ include file="adminfoot.jsp" %>  
    </body>
</html>
>>>>>>> 883e9228942b4e63cfd8bd59e43927d5d595c023
