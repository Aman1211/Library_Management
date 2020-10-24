
package library.controller.action;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library.model.UserBean;
import library.service.UserService;
import library.controller.action.ActionError;
import library.controller.Action;

public class ActionChangePasswordValidate implements Action{

	 public String perform(HttpServletRequest request,
	            HttpServletResponse response)
	 {
		 ArrayList<String>err=new ArrayList<>();
		 String view="";
		 String username=request.getParameter("username");
		 String password=request.getParameter("password");
		 String current_password=request.getParameter("current_password");
		 String confirm_password=request.getParameter("confirm_password");
		 System.out.print(username + password);
		 if(username.isEmpty() || password.isEmpty() || current_password.isEmpty() || confirm_password.isEmpty())
		 {
				err.add("Please Enter all the required fields");
				 request.setAttribute("errMessage1", err); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
		            
             request.getSession().setAttribute("user", username);
             return "change_password.jsp";
		 }
		 if(password.length()<8 || password.length()>20)
	     {

	    	err.add("Password length must be between 8 and 20");
	    	 request.setAttribute("errMessage1", err);
	    	 request.getSession().setAttribute("user", username);
	    	 return "change_password.jsp";
	     }
		 if(password.equals(confirm_password)==false)
	     {
	    	err.add("You must enter the same password twice in order to confirm password");
	    	 request.setAttribute("errMessage1", err);
	    	 request.getSession().setAttribute("user", username);
	    	 return "change_password.jsp";
	     }
		 else 
		 {
			 UserBean user=new UserBean();
			 user.setUsername(username);
			 user.setPassword(password);
			
			 boolean res=UserBD.updateUser(user,current_password);
		     
		     if(res==true)
		     {
		    	  err.clear();
		    	  err.add("Password Changed");
		    	  request.setAttribute("errMessage1", err);
		    	   view="change_password.jsp";
		     }
		     else
		     {
		    	  err.clear();
		    	 err.add("Current password not matched");	
		    	  request.setAttribute("errMessage1", err);
		    	   view="change_password.jsp";
		     }

		    
			 
			
		 }
		 
		 return view;
		  
} 

}
