
<%@ include file="adminhead.jsp"%>
<div class="container-fluid">
	<%
		ArrayList<String> arr = (ArrayList<String>) request.getAttribute("errMessage");
	BookBean bb = new BookBean();
	bb = (BookBean) session.getAttribute("book");
	%>
	<script>
		$(document).ready(function() {
			$('#cat').value =
	<%=bb.getCategory()%>
		;
		});
	</script>

	</script>
	<h3 style="margin-left: 45%">Edit Book</h3>
	<hr>
	<main class="login-form">
		<div class="cotainer">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="card">
						<div class="card-header">Edit Book</div>
						<div class="card-body">
							<%
								if (bb != null) {
							%>
							<form action="Controller" method="post"
								enctype="multipart/form-data">
								<input type="hidden" name="action" value="editbookvalidate">
								<div class="form-group row">
									<label for="isbn" class="col-md-4 col-form-label text-md-right">ISBN*</label>
									<div class="col-md-6">
										<input type="text" id="isbn" value=<%=bb.getISBN()%>
											class="form-control" name="isbn" autofocus readonly>
									</div>
								</div>

								<div class="form-group row">
									<label for="title"
										class="col-md-4 col-form-label text-md-right">Title Of
										Book*</label>
									<div class="col-md-6">
										<input type="text" id="title" value="<%=bb.getTitle()%>"
											class="form-control" name="title">
									</div>
								</div>
								<div class="form-group row">
									<label for="Author"
										class="col-md-4 col-form-label text-md-right">Author
										Name*</label>
									<div class="col-md-6">
										<input type="text" id="aname" value="<%=bb.getAuthor()%>"
											class="form-control" name="aname" autofocus>
									</div>
								</div>
								<div class="form-group row">
									<label for="qty" class="col-md-4 col-form-label text-md-right">Quantity
										of books*</label>
									<div class="col-md-6">
										<input type="number" id="qty" value="<%=bb.getQty()%>"
											class="form-control" name="qty" autofocus>
									</div>
								</div>
								<div class="form-group row">
									<label for="Category"
										class="col-md-4 col-form-label text-md-right">Category*</label>
									<div class="col-md-6">
										<select class="form-control" id="cat" name="category">
											<%
												if (bb.getCategory().equalsIgnoreCase("Art & Music")) {
											%>
											<option value="Art & Music " selected>Art & Music</option>
											<%
												} else {
											%>
											<option value="Art & Music">Art & Music</option>
											<%
												}
											%>
											<%
												if (bb.getCategory().equalsIgnoreCase("Biographic")) {
											%>
											<option value="Biographic" selected>Biographic</option>
											<%
												} else {
											%>
											<option value="Biographic">Biographic</option>
											<%
												}
											%>
											<%
												if (bb.getCategory().equalsIgnoreCase("Business")) {
											%>
											<option value="Business " selected>Business</option>
											<%
												} else {
											%>
											<option value="Business">Business</option>
											<%
												}
											%>
											<%
												if (bb.getCategory().equalsIgnoreCase("Comics")) {
											%>
											<option value="Comics " selected>Comics</option>
											<%
												} else {
											%>
											<option value="Comics ">Comics</option>
											<%
												}
											%>
											<%
												if (bb.getCategory().equalsIgnoreCase("Computer & Technology")) {
											%>
											<option value="Computer & Technology" selected><%=bb.getCategory()%></option>
											<%
												} else {
											%>
											<option value="Computer & Technology">Computer &
												Technology</option>
											<%
												}
											%>
											<%
												if (bb.getCategory().equalsIgnoreCase("Cooking")) {
											%>
											<option value="Cooking" selected><%=bb.getCategory()%></option>
											<%
												} else {
											%>
											<option value="Cooking">Cooking</option>
											<%
												}
											%>
											<%
												if (bb.getCategory().equalsIgnoreCase("Education & Reference")) {
											%>
											<option value="Education & Reference" selected><%=bb.getCategory()%>
											</option>
											<%
												} else {
											%>
											<option value="Education & Reference">Education &
												Reference</option>
											<%
												}
											%>
											<option value="Entertainment">Entertainment</option>
											<option value="Health & Fitness">Health & Fitness</option>
											<option value="History ">History</option>
											<%
												if (bb.getCategory().equalsIgnoreCase("Literature & Fiction")) {
											%>
											<option value="Literature & Fiction" selected>Literature
												& Fiction</option>
											<%
												} else {
											%>
											<option value="Literature & Fiction">Literature &
												Fiction</option>
											<%
												}
											%>
											<option value="Science-fiction & Fantasy">Science-fiction
												& Fantasy</option>
											<option value="Science & Math">Science & Math</option>
											<option value="Self - Help">Self - Help</option>
											<option value="Sports">Sports</option>
										</select>
									</div>
								</div>


								<div class="form-group row">
									<label for="imageofbook"
										class="col-md-4 col-form-label text-md-right">Book
										image*</label>
									<div class="col-md-6">
										<input type="file" id="bookimg" class="form-control"
											name="bookimg" autofocus>
									</div>
								</div>

								<div class="form-group row">
									<label for="racknumber"
										class="col-md-4 col-form-label text-md-right">Rack
										Number*</label>
									<div class="col-md-6">
										<input type="number" id="qty" value="<%=bb.getRack()%>"
											class="form-control" name="rno" autofocus>
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
									<input type="submit" class="btn btn-primary" value="Edit Book">


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