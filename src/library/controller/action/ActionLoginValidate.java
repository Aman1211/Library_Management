package library.controller.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library.model.UserBean;
import library.service.UserService;
import library.controller.action.ActionError;

import library.controller.Action;
public class ActionLoginValidate implements Action{

	 public String perform(HttpServletRequest request,
	            HttpServletResponse response)
	 {
		 String view="";
		 String username=request.getParameter("username");
		 String password=request.getParameter("password");
		 System.out.print(username + password);
		 if(username.isEmpty() || password.isEmpty())
		 {
			 String userValidate="Please Fill the required fields!";
			 request.setAttribute("errMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
             request.getSession().setAttribute("user", null);
			 return "login.jsp";
		 }
		 else 
		 {
			 
			 UserBean user=new UserBean();
			 user.setUsername(username);
			 user.setPassword(password);
			
			 user=UserBD.Verify(user);
			 			 if(user.getUsername()==null)
			 {
				 String message="Invalid User Credentials!";
				 request.setAttribute("errMessage",message);
				  request.getSession().setAttribute("user", null);
				 view="login.jsp";
			 }
			 else
			 {request.getSession().setAttribute("user",user.getUsername());
				 view="index.jsp";
			 }
			 
			
		 }
		 
		 return view;
		  
} 

}
