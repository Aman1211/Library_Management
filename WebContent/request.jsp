<%@page contentType="text/html" pageEncoding="UTF-8" import="library.model.UserBean"%>
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
<title>Request Book</title>
</head>
<body>
 <%@ include file="header.jsp" %> 
   
      
      <main class="login-form">
    <div class="cotainer">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">Request Book</div>
                    <div class="card-body">
                        <form action="Controller" enctype="multipart/form-data"   method="post">
                        <input type="hidden" name="action" value="requestvalidate">
                            <div class="form-group row">
                                <label for="Title" class="col-md-4 col-form-label text-md-right">Title*</label>
                                <div class="col-md-6">
                                    <input type="text" id="Title" class="form-control" name="title"  autofocus>
                                </div>
                            </div>
                              <div class="form-group row">
                                <label for="Author" class="col-md-4 col-form-label text-md-right">Author*</label>
                                <div class="col-md-6">
                                    <input type="text" id="Author" class="form-control" name="author"  autofocus>
                                </div>
                            </div>
                              <div class="form-group row">
                                <label for="Category" class="col-md-4 col-form-label text-md-right">Category*</label>
                                <div class="col-md-6">
                                    <select id="Category" class="form-control" name="category" autofocus>
                                    
                                   <option> Art & Music</option>
                                     <option>Biographics</option>
                                      <option>Business</option>
                                          <option>Comics</option>
                                           <option>Computer&Tech</option>
                                               <option>Cooking</option>
                                             <option>Edu&Reference</option>
                                            <option>Entertainment</option>
                                           <option>Health&Fitness</option>
                                            <option>History</option>
                                              <option>Literature&Fiction</option>
                                              <option>Sci-Fi&Fantasy</option>
                                             <option>Science&Math</option>
                                               <option>Self-Help</option> 
                                                <option>Sports</option>
                                    </select>
                                  
                                </div>
                            </div>
                             <div class="form-group row">
                                <label for="Image" class="col-md-4 col-form-label text-md-right">Image*</label>
                                <div class="col-md-6">
                                    <input type="file" id="Image" class="form-control" name="image"  autofocus>
                                </div>
                            </div>
                            
                            
                           
                             <div class="col-md-6 offset-md-4">
                              <p> <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
                             : request.getAttribute("errMessage")%></span></p>
                              </div>
                            
                            <div class="col-md-6 offset-md-4">
                                <button type="submit" class="btn btn-primary">
                                    Request
                                </button>
                               
                            </div>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    </div>

</main>
</body>
</html>