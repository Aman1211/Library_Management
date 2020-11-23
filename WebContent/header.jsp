
<nav class="navbar navbar-expand-lg navbar-light navbar-laravel">
    <div class="container">
     <a class="navbar-brand" href="#">
          <img src="images/booklogo.jpg" height="50" width="100" style="margin-right:5px; border-radius:10px"   alt="">
        </a>
        <% if(session.getAttribute("role")==null || session.getAttribute("role").equals("Member")){ %>
        <a class="navbar-brand" href="<%= application.getContextPath() %>/Controller">Library Management System</a>
        <%}else { %>
         <a class="navbar-brand" href="<%= application.getContextPath() %>/Controller?action=viewadmin">Library Management System</a>
        <%} %>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto" style="margin-top:25px">
                <%  if(session.getAttribute("user")!=null){ %>
                <% if(session.getAttribute("role").equals("Member")){ %>
                 <li class="nav-item">
                    <a  class="nav-link" href="<%= application.getContextPath() %>/Controller?action=requestlist">Request Book</a><br>
                    
                </li>
                <%} %>
                 <li class="nav-item">
                    <a  class="nav-link" href="<%= application.getContextPath() %>/Controller?action=logout">Logout</a><br>
                    
                </li>
                <li class="nav-item" >
                 <a class="nav-link" href="<%= application.getContextPath() %>/Controller?action=changepassword">Change Password</a>
                </li>
                <li class="nav-item" >
                 <a class="nav-link" href="<%= application.getContextPath() %>/Controller?action=bookreservation">Book Reservation</a>
                </li>
                <% if(session.getAttribute("role").equals("Admin")){ %>
                <li class="nav-item" >
                 <a class="nav-link" href="<%= application.getContextPath() %>/Controller?action=register">Add Member</a>
                </li>
                <%} %>
               
                <% } else { %>
                <li class="nav-item" style="margin-left:30px">
                    <a class="nav-link" href="<%=application.getContextPath() %>/Controller?action=login">Login</a>
                </li>
                 <% } %>
               
            </ul>

        </div>
    </div>
</nav>
