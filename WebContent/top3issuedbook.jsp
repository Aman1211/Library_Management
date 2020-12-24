
<%@ include file="adminhead.jsp"%>
<div class="container-fluid">
	<%
		ArrayList<BookBean> bb = new ArrayList<>();
	bb = (ArrayList<BookBean>) session.getAttribute("Itemlist");
	%>
	<h3 style="margin-left: 20%">
		Top 3 most issued book of particular month and year(<%=session.getAttribute("date123")%>)
	</h3>
	<h6>
		Year-Month:(<%=session.getAttribute("date123")%>)
	</h6>
	<hr>


	<table id="example" class="table table-striped table-bordered"
		style="width: 100%">
		<thead>
			<tr>
				<th>Title</th>
				<th>Author</th>
				<th>ISBN</th>
				<th>Category</th>
				<th>Quantity</th>
				<th>No of times books issued</th>

			</tr>
		</thead>
		<tbody>
			<%
				if (bb == null) {
				out.println("<tr><td colspan=\"4\">No Items Found</td></tr>");
			} else {
				for (BookBean b : bb) {
					String isbn = b.getISBN();
			%>

			<tr>
				<td><%=b.getTitle()%></td>
				<td><%=b.getAuthor()%></td>
				<td><%=b.getISBN()%></td>
				<td><%=b.getCategory()%></td>
				<td><%=b.getQty()%></td>
				<td><%=b.getRack()%></td>

			</tr>
			<%
				}
			}
			%>
		</tbody>
	</table>


</div>
<%@ include file="adminfoot.jsp"%>

