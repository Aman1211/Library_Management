
<%@page pageEncoding="UTF-8" import="library.model.*,java.util.*"%>


<!DOCTYPE html>
<html>
<title>Admin Panel</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css"  rel="stylesheet" id="bootstrap-css">
<link href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css" rel="stylesheet" >
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
<script src="css/fstdropdown.js"></script>
<link rel="stylesheet" href="css/fstdropdown.css">
<script src="https://cdn.datatables.net/1.10.22/js/dataTables.bootstrap4.min.js"></script>
<meta charset="ISO-8859-1">
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Fonts -->
    <link rel="dns-prefetch" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600" rel="stylesheet" type="text/css">

<link href="css/simple-sidebar.css" rel="stylesheet">
<script>
 $(document).ready(function() {
	    $('#example').DataTable();
	} );
 
 $(document).ready(function() {
	 $('.mdb-select').materialSelect();
	 });
 </script>

</head>

 <% 
        if(session.getAttribute("user")==null)
        {
        	 response.sendRedirect("Controller");
        }
      %>
<body>
<%@ include file="header.jsp" %> 
  <div class="d-flex" id="wrapper">

    <!-- Sidebar -->
    <div class="bg-light border-right" id="sidebar-wrapper">
      <div class="sidebar-heading">Menu</div>
       
      <div class="list-group list-group-flush">
      	<a href="<%=application.getContextPath() %>/Controller?action=manageprofile" class="list-group-item list-group-item-action bg-light">Manage User Profile</a>
        <a href="<%=application.getContextPath() %>/Controller?action=managebook" class="list-group-item list-group-item-action bg-light">Manage Book</a>
        <a href="<%=application.getContextPath() %>/Controller?action=adminrequest" class="list-group-item list-group-item-action bg-light">View Requests</a>
        <a href="<%=application.getContextPath() %>/Controller?action=issuebook" class="list-group-item list-group-item-action bg-light">Issue Book</a>
        <a href="<%=application.getContextPath() %>/Controller?action=renew" class="list-group-item list-group-item-action bg-light">Renew Book</a>
        
      </div>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">

      <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
        <button class="navbar-toggler-icon" id="menu-toggle"></button>
        <a style="margin-left: 10px"class="navbar-brand" href="<%= application.getContextPath() %>/Controller?action=viewadmin">Admin Panel</a>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          
        </div>
      </nav>
