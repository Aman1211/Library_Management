   <%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.ArrayList" %> 
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
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
</head>
<body>
 <%@ include file="header.jsp" %> 
<%

ArrayList<String>arr=(ArrayList<String>)request.getAttribute("errMessage");
%>
  <main class="login-form">
    <div class="cotainer">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">Registration</div>
                    <div class="card-body">
                        <form action="Controller" method="post">
                        <input type="hidden" name="action" value="registervalidate">
                            <div class="form-group row">
                                <label for="email_address" class="col-md-4 col-form-label text-md-right">Username*</label>
                                <div class="col-md-6">
                                    <input type="text" id="email_address" class="form-control" name="username"  autofocus>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="password" class="col-md-4 col-form-label text-md-right">Password*</label>
                                <div class="col-md-6">
                                    <input type="password" id="password" class="form-control" name="password" >
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="name" class="col-md-4 col-form-label text-md-right">Name*</label>
                                <div class="col-md-6">
                                    <input type="text" id="name" class="form-control" name="name"  autofocus>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="contact" class="col-md-4 col-form-label text-md-right">Contact*</label>
                                <div class="col-md-6">
                                    <input type="number" id="contact" class="form-control" name="contact"  autofocus>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="type" class="col-md-4 col-form-label text-md-right">Type*</label>
                                <div class="col-md-6">
                                    <select class="form-control" name="type">
                                    <option>Student </option>
                                    <option>Faculty </option>
                                    </select>
                                </div>
                            </div>
      
        <% if(arr==null){ %>
         <div class="col-md-6 offset-md-4">
        <p> <span style="color:red"> </span> </p>
     </div>
      <% }else { %>
      <% for(String s:arr) {  %>
       <div class="col-md-6 offset-md-4">
        <p> <span style="color:red"><%= s %> </span> </p>
      </div>
      <% }} %>
     <div class="col-md-6 offset-md-4">
                                <input type="submit" class="btn btn-primary" value="Sign Up">
                                    
                                         
       </div>
   </form>
 
</body>
</html>