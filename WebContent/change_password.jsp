<%@page contentType="text/html" pageEncoding="UTF-8" import="library.model.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="shortcut icon" href="images/booklogo.jpg" type="image/x-icon" />
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
<title>Change Password</title>
</head>
<body>
 <%@ include file="header.jsp" %> 
    <% 
        if(session.getAttribute("user")==null)
        {
        	 response.sendRedirect("index.jsp");
        }
      %>

      <main class="login-form">
    <div class="cotainer">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">Change Password</div>
                    <div class="card-body">
                        <form action="Controller" method="post">
                        <input type="hidden" name="action" value="changepasswordvalidate">
                            <div class="form-group row" hidden>
                                <label for="email_address" class="col-md-4 col-form-label text-md-right">Username*</label>
                                <div class="col-md-6">
                                    <input type="text" id="username" class="form-control" value="<%= session.getAttribute("user")%>" name="username"  autofocus>
                                </div>
                            </div>
               <div class="form-group row">
                                <label for="password" class="col-md-4 col-form-label text-md-right">Currrent Password*</label>
                                <div class="col-md-6">
                                    <input type="password" id="current_password" class="form-control" name="current_password" >
                                </div>
                            </div>
             
                            <div class="form-group row">
                                <label for="password" class="col-md-4 col-form-label text-md-right">New Password*</label>
                                <div class="col-md-6">
                                    <input type="password" id="password" class="form-control" name="password" >
                                </div>
                            </div>
                                                        <div class="form-group row">
                                <label for="password" class="col-md-4 col-form-label text-md-right">Confirm Password*</label>
                                <div class="col-md-6">
                                    <input type="password" id="confirm_password" class="form-control" name="confirm_password" >
                                </div>
                            </div>
                             <div class="col-md-6 offset-md-4">
                              <p> <span style="color:red"><%=(request.getAttribute("errMessage1") == null) ? ""
                             : request.getAttribute("errMessage1")%></span></p>
                              </div>
                           
                            <div class="col-md-6 offset-md-4">
                                <button type="submit" class="btn btn-primary">
                                    Change Password
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