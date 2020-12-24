<%@page contentType="text/html" pageEncoding="UTF-8"
	import="library.model.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="shortcut icon" href="images/booklogo.jpg" type="image/x-icon" />
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Fonts -->
<link rel="dns-prefetch" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600"
	rel="stylesheet" type="text/css">

<link rel="stylesheet" href="css/style.css">

<link rel="icon" href="Favicon.png">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>Forgot Password</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<%
		if (session.getAttribute("user") != null) {
		response.sendRedirect("index.jsp");
	}
	%>
	<main class="login-form">
		<div class="cotainer">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="card">
						<div class="card-header">Forgot Password</div>
						<div class="card-body">
							<form action="Controller" method="post">
								<input type="hidden" name="action" value="forgotvalidate">
								<div class="form-group row">
									<label for="email_address"
										class="col-md-4 col-form-label text-md-right">Username*</label>
									<div class="col-md-6">
										<input type="text" id="email_address" class="form-control"
											name="username" autofocus>
									</div>
								</div>


								<div class="col-md-6 offset-md-4">
									<p>
										<span style="color: red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
									</p>
								</div>

								<div class="col-md-6 offset-md-4">
									<button type="submit" class="btn btn-primary">Send
										Password via mail</button>
									<a
										href="<%=application.getContextPath()%>/Controller?action=login"
										class="btn btn-link"> Back to login </a>
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