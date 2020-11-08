<%@page contentType="text/html" pageEncoding="UTF-8"
	import="library.model.RequestBean,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css"
	rel="stylesheet" id="bootstrap-css">
<link
	href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css"
	rel="stylesheet">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>

<script
	src="https://cdn.datatables.net/1.10.22/js/dataTables.bootstrap4.min.js"></script>
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
<script>
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
<title>Book Requests</title>

</head>
<body>
	<%
		ArrayList<RequestBean> bb = new ArrayList<>();
	bb = (ArrayList<RequestBean>) session.getAttribute("rlist");
	%>
	<%@ include file="header.jsp"%>
	<a style="margin-top: 5px; margin-bottom: 5px"
		href="<%=application.getContextPath()%>/Controller?action=request "
		class="btn btn-primary">Add Request</a>
	<table id="example" class="table table-striped table-bordered"
		style="width: 100%">
		<thead>
			<tr>
				<th align="center">Book Title</th>
				<th align="center">Book Author</th>
				<th align="center">Category</th>
				<th align="center">Image</th>
				<th align="center">Status</th>
			</tr>
		</thead>
		<tbody>
			<%
				if (bb == null) {
			%>
			<h3 style="margin-left: 45%">No Item Found</h3>
			<%
				} else {
			for (RequestBean b : bb) {
			%>
			<tr>
				<td align="center"><%=b.getTitle()%></td>
				<td align="center"><%=b.getAuthor()%></td>
				<td align="center"><%=b.getCategory()%></td>
				<td align="center"><a class="btn btn-primary"
					href="<%=b.getImage()%>" target="_blank">Show Image</a></td>
				<%
					if (b.getStatus() == false) {
				%>
				<td align="center"><button style="margin-left: 5px;"
						type="button" class="btn btn-danger">Pending</button></td>
				<%
					} else {
				%>
				<td align="center"><button style="margin-left: 5px;"
						type="button" class="btn btn-success">Approved</button></td>
				<%
					}
				%>
			</tr>
			<%
				}
			}
			%>


		</tbody>
	</table>
</body>


</html>

