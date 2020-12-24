
<%@ include file="adminhead.jsp"%>
<div class="container-fluid">
	<%
		ArrayList<UserBean> bb = new ArrayList<>();
	bb = (ArrayList<UserBean>) session.getAttribute("Itemlist");
	%>
	<h3 style="margin-left: 1%">Top 3 member who made most no of
		transaction for particular month and year</h3>
	<h6>
		Year-Month:(<%=session.getAttribute("date123")%>)
	</h6>

	<hr>


	<table id="example" class="table table-striped table-bordered"
		style="width: 100%">
		<thead>
			<tr>
				<th>Name</th>
				<th>Count of transaction:</th>
			</tr>
		</thead>
		<tbody>
			<%
				if (bb == null) {
				out.println("<tr><td colspan=\"4\">No Items Found</td></tr>");
			} else {
				// System.out.println("HELLO="+bb.get(0).getName());
				for (UserBean b : bb) {
					//System.out.println("abc="+b.getName());
			%>

			<tr>
				<td><%=b.getUsername()%></td>
				<td><%=b.getContact()%></td>
			</tr>
			<%
				}
			}
			%>
		</tbody>
	</table>


</div>
<%@ include file="adminfoot.jsp"%>

