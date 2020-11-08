<%@ include file="adminhead.jsp" %> 
      <div class="container-fluid">
       <% ArrayList<RequestBean>bb=new ArrayList<>();
   bb=(ArrayList<RequestBean>)session.getAttribute("rlist");   
 %>
  <h3 style="margin-left:45%" >View Requests</h3>
  <hr>
 <table id="example" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
                <th align="center">Book Title</th>
                <th align="center"> Book Author</th>
                <th align="center">Category</th>
                <th align="center">Image</th>
                <th align="center">Action</th>
            </tr>
        </thead>
        <tbody>
          <% if(bb==null){ %>
           <h3 style="margin-left:45%" >No Item Found</h3>
          <% }
          else
          {
        	for(RequestBean b:bb)
        	{%>
           <tr>
           <td align="center"><%=b.getTitle() %> </td>
           <td align="center"><%= b.getAuthor() %> </td>
           <td align="center"><%= b.getCategory() %> </td>
           <td align="center"><a class="btn btn-primary" href="<%=b.getImage()%>" target="_blank">Show Image</a> </td>
            
            <td align="center"><a href="<%=application.getContextPath() %>/Controller?action=approverequest&id=<%=b.getId() %>" style="margin-left:5px;" class="btn btn-primary" >
  Approve
</a> </td>
  
           </tr>
           <% }} %>
        	  
          
        </tbody>
        </table>
      </div>
 <%@ include file="adminfoot.jsp"%>