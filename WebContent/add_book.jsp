  <%@ include file="adminhead.jsp" %> 
      <div class="container-fluid m-5">
  <% ArrayList<String>arr=(ArrayList<String>)request.getAttribute("errMessage");
%>
 <h3 style="margin-left:45%" >Add Book</h3>
  <hr>
  <main class="login-form">
    <div class="cotainer">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">Add Book</div>
                    <div class="card-body">
                        <form action="Controller" method="post"  enctype="multipart/form-data">
                        <input type="hidden" name="action" value="addbookvalidate">
                            <div class="form-group row">
                                <label for="isbn" class="col-md-4 col-form-label text-md-right">ISBN*</label>
                                <div class="col-md-6">
                                    <input type="text" id="isbn" class="form-control" name="isbn"  autofocus>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="title" class="col-md-4 col-form-label text-md-right">Title Of Book*</label>
                                <div class="col-md-6">
                                    <input type="text" id="title" class="form-control" name="title" >
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="Author" class="col-md-4 col-form-label text-md-right">Author Name*</label>
                                <div class="col-md-6">
                                    <input type="text" id="aname" class="form-control" name="aname"  autofocus>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="qty" class="col-md-4 col-form-label text-md-right">Quantity of books*</label>
                                <div class="col-md-6">
                                    <input type="number" id="qty" class="form-control" name="qty"  autofocus>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="Category" class="col-md-4 col-form-label text-md-right">Category*</label>
                                <div class="col-md-6">
                                    <select class="form-control" name="category">
                                    <option>Art & Music </option>
                                    <option>Biographic </option>
                                    <option>Business </option>
                                    <option>Comics </option>
                                    <option>Computer & Technology</option>
                                    <option>Cooking</option>
                                    <option>Education & Reference </option>
                                    <option>Entertainment </option>
                                    <option>Health & Fitness </option>
                                    <option>History </option>
                                    <option>Literature & Fiction </option>
                                    <option>Science-fiction & Fantasy </option>
                                    <option>Science & Math </option>
                                    <option>Self - Help </option>
                                    <option>Sports </option>
                                    </select>
                                </div>
                            </div>
                            
                           
                            <div class="form-group row">
                                <label for="imageofbook" class="col-md-4 col-form-label text-md-right">Book image*</label>
                                <div class="col-md-6">
                                    <input type="file" id="bookimg" class="form-control" name="bookimg"  autofocus>
                                </div>
                            </div>
                            
                            <div class="form-group row">
                                <label for="racknumber" class="col-md-4 col-form-label text-md-right">Rack Number*</label>
                                <div class="col-md-6">
                                    <input type="number" id="qty" class="form-control" name="rno"  autofocus>
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
                                <input type="submit" class="btn btn-primary" value="Add Book">
                                    
                                         
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