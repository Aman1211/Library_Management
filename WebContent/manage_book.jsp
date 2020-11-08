
<%@ include file="adminhead.jsp" %> 
      <div class="container-fluid">
      <% ArrayList<BookBean>bb=new ArrayList<>();
   bb=(ArrayList<BookBean>)session.getAttribute("Itemlist");
 	%>
       Manage all books here
        <a href="<%=application.getContextPath()%>/Controller?action=addbook"> Add New Book </a>
      
      <table id="example" class="table table-striped table-bordered" style="width:100%">
    <thead>
      <tr>
      <th>Title</th>
        <th>Author</th>
        <th>ISBN</th>
        <th>Category</th>
        <th>Quantity</th>
        <th>Rack</th>
        <th>Image</th>
        <th>Edit</th>
        <th>Delete</th>
      </tr>
    </thead>
    <tbody>
<% if(bb==null){
	 out.println("<tr><td colspan=\"4\">No Items Found</td></tr>");
 }
 else
 {
	for(BookBean b:bb){  
		String isbn = b.getISBN();
	 %>

      <tr>
        <td><%=b.getTitle() %></td>
        <td> <%=b.getAuthor() %></td>
        <td><%=b.getISBN() %></td>
        <td><%=b.getCategory() %></td>
        <td><%=b.getQty() %></td>
        <td><%=b.getRack() %></td>
        <td><img src=<%= b.getImage() %> height="100px" alt="..."></td>
        <td><a href="<%= application.getContextPath() %>/Controller?action=editbook&isbn=<%= isbn %>">Edit</a></td>
        <td><a href="<%= application.getContextPath() %>/Controller?action=deletebookvalidate&isbn=<%= isbn %>">Delete Book</a></td>
       
      </tr>
       <% }} %>
    </tbody>
  </table>
      
      
      </div>
 <%@ include file="adminfoot.jsp"%>

