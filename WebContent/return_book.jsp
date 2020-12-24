
<%@ include file="adminhead.jsp"%>
<div class="container-fluid">
	<%
		Map<Integer, BookBean> mp = new HashMap<>();

	mp = (Map<Integer, BookBean>) session.getAttribute("map");
	String mess = (String) request.getAttribute("message");
	%>
	<h3 style="margin-left: 45%">Return Book</h3>
	<hr>
	<%
		if (mess != null) {
	%>
	<div>
		<p>
			<span style="color: red"> <%=mess%>
			</span>
		</p>
	</div>
	<%
		}
	%>
	<hr>
	<table id="example" class="table table-striped table-bordered"
		style="width: 100%">
		<thead>
			<tr>

				<th>ISBN</th>
				<th>Title</th>
				<th>Author</th>
				<th>Image</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%
				if (mp == null) {
				out.println("<tr><td colspan=\"4\">No Transactions Found</td></tr>");
			} else {
				Set set = mp.entrySet();
				Iterator itr = set.iterator();
				while (itr.hasNext()) {
					Map.Entry entry = (Map.Entry) itr.next();
					BookBean b = (BookBean) entry.getValue();
			%>
			<tr>
				<td><%=b.getISBN()%></td>
				<td><%=b.getTitle()%></td>
				<td><%=b.getAuthor()%></td>
				<td><a class="btn btn-primary" href="<%=b.getImage()%>"
					target="_blank">Show Image</a></td>
				<%
					if (session.getAttribute("renew") == null) {
				%>
				<td><a class="btn btn-primary"
					href="<%=application.getContextPath()%>/Controller?action=checkfine1&tid=<%=entry.getKey()%>">Check
						Fine</a></td>
				<%
					} else if (session.getAttribute("renew").equals("fine")
						&& Integer.parseInt(request.getParameter("tid")) == (int) entry.getKey()) {
				%>
				<td><a class="btn btn-primary"
					href="<%=application.getContextPath()%>/Controller?action=markfine1&tid=<%=entry.getKey()%>&amt=<%=request.getAttribute("amt")%>">Mark
						Fine</a></td>
				<%
					} else if (session.getAttribute("renew").equals("fine")
						&& Integer.parseInt(request.getParameter("tid")) != (int) entry.getKey()) {
				%>
				<td><input type="button" class="btn btn-primary" disabled
					value="Mark Fine"
					<%=application.getContextPath()%>/Controller?action=markfine&tid=
					<%=entry.getKey()%>&amt=<%=request.getAttribute("amt")%>></td>
				<%
					} else if (session.getAttribute("renew").equals("nofine")
						&& Integer.parseInt(request.getParameter("tid")) == (int) entry.getKey()) {
				%>
				<td><a class="btn btn-primary"
					href="<%=application.getContextPath()%>/Controller?action=markreturn&tid=<%=entry.getKey()%>">Mark
						Return</a></td>
				<%
					} else if (session.getAttribute("renew").equals("nofine")
						&& Integer.parseInt(request.getParameter("tid")) != (int) entry.getKey()) {
				%>
				<td><input type="button" class="btn btn-primary" disabled
					value="Mark Return"
					<%=application.getContextPath()%>/Controller?action=editprofile&username=
					<%=b.getISBN()%>></td>
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


</div>
<%@ include file="adminfoot.jsp"%>

