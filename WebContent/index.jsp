
<%@page contentType="text/html" pageEncoding="UTF-8" import="library.model.BookBean,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<style>
select {
  margin-bottom: 1em;
  padding: .25em;
  border: 0;
  border-bottom: 2px solid currentcolor; 
  font-weight: bold;
  letter-spacing: .15em;
  border-radius: 0;
  &:focus, &:active {
    outline: 0;
    border-bottom-color: red;
  }
}
</style>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Fonts -->
    <link rel="dns-prefetch" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600" rel="stylesheet" type="text/css">

    <link rel="stylesheet" href="css/style.css">
     <link rel="stylesheet" href="css/search.css">
    <link rel="icon" href="Favicon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>Home</title>
</head>
<body>
 <% ArrayList<BookBean>bb=new ArrayList<>();
   bb=(ArrayList<BookBean>)session.getAttribute("Itemlist");
 %>
 <%@ include file="header.jsp" %>  
 <div class="container" style="margin-top:5px">
  <div class="row searchFilter" >
     <div class="col-sm-12" >
     <form method="post" action="Controller">
      <input type="hidden" name="action" value="searchValidate">
      <div class="input-group" >
      
       <input id="table_filter" type="text" class="form-control" name="search" aria-label="Text input with segmented button dropdown" placeholder="Search by ISBN,Title,Author,Category" required>
       <div class="input-group-btn" >
       
        <button id="searchBtn" type="submit" class="btn btn-secondary btn-search" ><span class="glyphicon glyphicon-search" >&nbsp;</span> <span class="label-icon" >Search</span></button>
        <a href="<%=application.getContextPath()%>/Controller?action=viewIndex" class="btn btn-secondary btn-search"><span class="glyphicon glyphicon-search" >&nbsp;</span> <span class="label-icon" >Reset</span></a>
       </div>
       
      </div>
       </form>
     </div>
  </div>
</div>

 <div class="row">
  <form action="Controller" method="post">
     <input type="text" id="username" class="form-control" hidden value="<%= session.getAttribute("user")%>" name="username"  autofocus>
  </form>
 <%
 
 if(bb==null){
	 %>
	 <h3 style="margin-left:45%" >No Item Found</h3>
 <% }
 else
 {
	 
	for(BookBean b:bb){  
		String isbn = b.getISBN();
	 %>
  <div class="col-sm-3">
   <div class="card" style="width: 18rem; margin-top:10px">
  <img src=<%= b.getImage() %> height="200px" class="card-img-top" alt="...">
  
 
  <div class="card-body">
    <h5 class="card-title"><%=b.getTitle() %></h5>
  <ul class="list-group list-group-flush">
    
  
    <li class="list-group-item">Author:- <b> <%=b.getAuthor() %></b></li>
     <li class="list-group-item"> ISBN:- <b> <%=b.getISBN() %></b></li>
      <li class="list-group-item">Category:- <b> <%=b.getCategory() %></b></li>
     <li class="list-group-item"> Quantity:- <b> <%=b.getQty() %></b></li>
       <li class="list-group-item"> Rack:- <b> <%=b.getRack() %></b></li>
      
    <%  if(b.getQty()==0){ %>
        <li class="list-group-item"><a class="btn btn-primary" href="<%= application.getContextPath() %>/Controller?action=reservebookvalidation&isbn=<%= isbn %>">Reserve</a></li>  
    
    <% } %>
   </ul>
  </div>
</div>
</div>
 
 <% }} %>
 
</div>
      
    </body>
</html>
