
<%@ include file="adminhead.jsp"%>
<div class="container-fluid">

	<%
		ArrayList<String> arr = (ArrayList<String>) request.getAttribute("errMessage");
	%>
	<h3 style="margin-left: 45%">Add Member</h3>
	<hr>
	<main class="login-form">
		<div class="cotainer">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="card">
						<div class="card-header">Add Member</div>
						<div class="card-body">
							<form action="Controller" method="post">
								<input type="hidden" name="action" value="registervalidate">
								<div class="form-group row">
									<label for="email_address"
										class="col-md-4 col-form-label text-md-right">Username*</label>
									<div class="col-md-6">
										<input type="text" id="email_address" class="form-control"
											name="username" autofocus>
									</div>
								</div>

								<div class="form-group row">
									<label for="password"
										class="col-md-4 col-form-label text-md-right">Password*</label>
									<div class="col-md-6">
										<input type="password" id="password" class="form-control"
											name="password">
									</div>
								</div>
								<div class="form-group row">
									<label for="name" class="col-md-4 col-form-label text-md-right">Name*</label>
									<div class="col-md-6">
										<input type="text" id="name" class="form-control" name="name"
											autofocus>
									</div>
								</div>
								<div class="form-group row">
									<label for="contact"
										class="col-md-4 col-form-label text-md-right">Contact*</label>
									<div class="col-md-6">
										<input type="number" id="contact" class="form-control"
											name="contact" autofocus>
									</div>
								</div>
								<div class="form-group row">
									<label for="type" class="col-md-4 col-form-label text-md-right">Type*</label>
									<div class="col-md-6">
										<select class="form-control" name="type">
											<option>Student</option>
											<option>Faculty</option>
										</select>
									</div>
								</div>

								<%
									if (arr == null) {
								%>
								<div class="col-md-6 offset-md-4">
									<p>
										<span style="color: red"> </span>
									</p>
								</div>
								<%
									} else {
								%>
								<%
									for (String s : arr) {
								%>
								<div class="col-md-6 offset-md-4">
									<p>
										<span style="color: red"><%=s%> </span>
									</p>
								</div>
								<%
									}
								}
								%>
								<div class="col-md-6 offset-md-4">
									<input type="submit" class="btn btn-primary" value="Sign Up">


								</div>
							</form>

						</div>

					</div>
				</div>
			</div>
		</div>
	</main>
</div>
<%@ include file="adminfoot.jsp"%>