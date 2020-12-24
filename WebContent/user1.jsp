
<%@ include file="adminhead.jsp"%>
<div class="container-fluid">
	<%
		ArrayList<String> arr = (ArrayList<String>) request.getAttribute("errMessage");
	ArrayList<UserBean> ub = new ArrayList<>();
	ub = (ArrayList<UserBean>) session.getAttribute("userlist");
	%>

	<h3 style="margin-left: 45%">Return Book</h3>
	<hr>
	<main class="login-form">
		<div class="cotainer">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="card">
						<div class="card-header">Return Book</div>
						<div class="card-body">

							<form action="Controller" method="post"
								enctype="multipart/form-data">
								<input type="hidden" name="action" value="returnbook">
								<div class="form-group row">
									<label for="username"
										class="col-md-4 col-form-label text-md-right">Select
										Member*</label>
									<div class="col-md-6">
										<select class="fstdropdown-select" name="username">
											<option value="null">Select Member</option>
											<%
												for (UserBean u : ub) {
											%>
											<option value=<%=u.getUsername()%>><%=u.getUsername()%>-<%=u.getName()%></option>
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
										value="Fetch Transactions">


								</div>
							</form>

						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
</div>