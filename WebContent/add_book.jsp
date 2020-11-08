   <%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.ArrayList" %> 
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>add book</title>
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
                    <div class="card-header">Add Book</div>
                    <div class="card-body">
                        <form action="Controller" method="post"  enctype="multipart/form-data">
                        <input type="hidden" name="action" value="addbookvalidate">
                            <div class="form-group row">
                                <label for="isbn" class="col-md-4 col-form-label text-md-right">ISBN*</label>
                                <div class="col-md-6">
                                    <input type="text" id="isbn" class="form-control" name="isbn"  autofocus>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="title" class="col-md-4 col-form-label text-md-right">Title Of Book*</label>
                                <div class="col-md-6">
                                    <input type="text" id="title" class="form-control" name="title" >
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="Author" class="col-md-4 col-form-label text-md-right">Author Name*</label>
                                <div class="col-md-6">
                                    <input type="text" id="aname" class="form-control" name="aname"  autofocus>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="qty" class="col-md-4 col-form-label text-md-right">Quantity of books*</label>
                                <div class="col-md-6">
                                    <input type="number" id="qty" class="form-control" name="qty"  autofocus>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="Category" class="col-md-4 col-form-label text-md-right">Category*</label>
                                <div class="col-md-6">
                                    <select class="form-control" name="category">
                                    <option>Art & Music </option>
                                    <option>Biographic </option>
                                    <option>Business </option>
                                    <option>Comics </option>
                                    <option>Computer & Technology</option>
                                    <option>Cooking</option>
                                    <option>Education & Reference </option>
                                    <option>Entertainment </option>
                                    <option>Health & Fitness </option>
                                    <option>History </option>
                                    <option>Literature & Fiction </option>
                                    <option>Science-fiction & Fantasy </option>
                                    <option>Science & Math </option>
                                    <option>Self - Help </option>
                                    <option>Sports </option>
                                    </select>
                                </div>
                            </div>
                            
                           
                            <div class="form-group row">
                                <label for="imageofbook" class="col-md-4 col-form-label text-md-right">Book image*</label>
                                <div class="col-md-6">
                                    <input type="file" id="bookimg" class="form-control" name="bookimg"  autofocus>
                                </div>
                            </div>
                            
                            <div class="form-group row">
                                <label for="racknumber" class="col-md-4 col-form-label text-md-right">Rack Number*</label>
                                <div class="col-md-6">
                                    <input type="number" id="qty" class="form-control" name="rno"  autofocus>
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
                                <input type="submit" class="btn btn-primary" value="Add Book">
                                    
                                         
       </div>
   </form>
 
</body>
</html>