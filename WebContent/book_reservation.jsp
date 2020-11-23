<%@page pageEncoding="UTF-8" import="library.model.BookBean,java.util.ArrayList,library.model.ReserveBean,java.util.ArrayList,library.model.RequestBean"%>

<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Fonts -->
    <link rel="dns-prefetch" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="icon" href="Favicon.png">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>Reservation Details</title>
</head>
<body>
 <%@ include file="header.jsp" %>  
      <div class="container-fluid">
      <% ArrayList<BookBean>bb=new ArrayList<>();
   bb=(ArrayList<BookBean>)session.getAttribute("Itemlist");
 	%>
      <h3 style="margin-left:45%" >Book Reservation Details</h3>
  <hr>
       
      
      <table id="example" class="table table-striped table-bordered" style="width:100%">
    <thead>
      <tr>
      
        <th>BookName</th>
        <th>Cancel Reservation</th>
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

        <td><a class="btn btn-primary" href="<%= application.getContextPath() %>/Controller?action=cancelreservationvalidate&isbn=<%= isbn %>">Cancel Reservation</a></td>
     
        
       
      </tr>
       <% }} %>
    </tbody>
  </table>
      
      
      </div>


