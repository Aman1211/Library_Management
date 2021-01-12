
<%@ include file="adminhead.jsp"%>
<div class="container-fluid">
	<% ArrayList<UserBean>ub=new ArrayList<>();
  ub = (ArrayList<UserBean>)session.getAttribute("userlist");
 	%>
	<h3 style="margin-left: 45%">Manage Profile</h3>
	<hr>

	<table id="example" class="table table-striped table-bordered"
		style="width: 100%">
		<thead>
			<tr>
				<th>UserName</th>
				<th>Name</th>
				<th>Contact</th>
				<th>Type</th>
				<th>Edit</th>
				<th>Remove</th>
			</tr>
		</thead>
		<tbody>
			<% if(ub==null){
	 out.println("<tr><td colspan=\"4\">No Users Found</td></tr>");
 }
 else
 {
	for(UserBean b:ub){  
		String type = b.getType();
		String Username = b.getUsername();
		if(!type.equals("Admin"))
		{
	 %>

			<tr>
				<td><%=b.getUsername() %></td>
				<td><%=b.getName() %></td>
				<td><%=b.getContact() %></td>
				<td><%=b.getType() %></td>
				<td><a class="btn btn-primary"
					href="<%= application.getContextPath() %>/Controller?action=editprofile&username=<%= Username %>">Edit</a></td>
           <td><a class="btn btn-primary"
					href="<%= application.getContextPath() %>/Controller?action=removeprofile&username=<%= Username %>">Remove</a></td>
           
			</tr>
			<% }}} %>
		</tbody>
	</table>


</div>
<%@ include file="adminfoot.jsp"%>

