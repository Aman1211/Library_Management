
<%@ include file="adminhead.jsp"%>
<div class="container-fluid">
	<%
		ArrayList<String> arr = (ArrayList<String>) request.getAttribute("errMessage");
	UserBean ub = new UserBean();
	ub = (UserBean) session.getAttribute("user");
	%>


	</script>
	<h3 style="margin-left: 45%">Edit Profile</h3>
	<hr>
	<main class="login-form">
		<div class="cotainer">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="card">
						<div class="card-header">Edit Profile</div>
						<div class="card-body">
							<%
								if (ub != null) {
							%>
							<form action="Controller" method="post"
								enctype="multipart/form-data">
								<input type="hidden" name="action" value="editprofilevalidate">

								<input type="hidden" name="uname" value=<%=ub.getUsername()%>>
								<div class="form-group row">
									<label for="username"
										class="col-md-4 col-form-label text-md-right">Username*</label>
									<div class="col-md-6">
										<input type="text" id="username" value=<%=ub.getUsername()%>
											class="form-control" name="username" autofocus>
									</div>
								</div>

								<div class="form-group row">
									<label for="name" class="col-md-4 col-form-label text-md-right">Name*</label>
									<div class="col-md-6">
										<input type="text" id="name" value="<%=ub.getName()%>"
											class="form-control" name="name">
									</div>
								</div>
								<div class="form-group row">
									<label for="contact"
										class="col-md-4 col-form-label text-md-right">Contact*</label>
									<div class="col-md-6">
										<input type="number" id="contact"
											value="<%=ub.getContact()%>" class="form-control"
											name="contact" autofocus>
									</div>
								</div>

								<div class="form-group row">
									<label for="type" class="col-md-4 col-form-label text-md-right">Type*</label>
									<div class="col-md-6">
										<select class="form-control" id="type" name="type">
											<%
												if (ub.getType().equalsIgnoreCase("Student")) {
											%>
											<option value="Student " selected>Student</option>
											<%
												} else {
											%>
											<option value="Student">Student</option>
											<%
												}
											%>
											<%
												if (ub.getType().equalsIgnoreCase("Faculty")) {
											%>
											<option value="Faculty" selected>Faculty</option>
											<%
												} else {
											%>
											<option value="Faculty">Faculty</option>
											<%
												}
											%>

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
									<input type="submit" class="btn btn-primary"
										value="Edit Profile">


								</div>
							</form>
							<%
								}
							%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
</div>