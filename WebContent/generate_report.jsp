
  <%@ include file="adminhead.jsp" %> 
      <div class="container-fluid">
  <% ArrayList<String>arr=(ArrayList<String>)request.getAttribute("errMessage");
%>
 <h3 style="margin-left:37%" >Generate Report</h3>
  <hr>
  <main class="login-form">
    <div class="cotainer">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">Generate Report</div>
                    <div class="card-body">
                        <form action="Controller" method="post"  enctype="multipart/form-data">
                        <input type="hidden" name="action" value="generatereportvalidate">
                                  
                            <div class="form-group row">
                                <label for="Category" class="col-md-4 col-form-label text-md-right">Select Report*</label>
                                <div class="col-md-6">
                                    <select class="form-control" name="report">
                                    <option value="1">Top 3 most issued book of particular month and year.</option>
                                    <option value="2">Total amount of fine for a particular month and year and list of member who got fined. </option>
                                    <option value="3">Top 3 member who made most no of transaction for particular month and year. </option>
                                    </select>
                                </div>
                            </div>
                            
                           
                            
                            <div class="form-group row">
                                <label for="racknumber" class="col-md-4 col-form-label text-md-right">Select Date*</label>
                                <div class="col-md-6">
                                    <input type="month" id="date" class="form-control" name="date"  autofocus>
                                </div>
                            </div>
                           
      
        <% if(arr==null){ %>
         <div class="col-md-6 offset-md-4">
        <p> <span style="color:red"> </span> </p>
     </div>
      <% }else { %>
      <% for(String s:arr) {  %>
       <div class="col-md-6 offset-md-4">
        <p> <span style="color:red"><%= s %> </span> </p>
      </div>
      <% }} %>
     <div class="col-md-6 offset-md-4">
        <input type="submit" class="btn btn-primary" value="Generate Report">
                                    
                                         
       </div>
   </form>
   </div>
   </div>
   </div>
   </div>
   </div>
   </main>
   </div>
 <%@ include file="adminfoot.jsp"%>