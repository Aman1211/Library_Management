package library.controller.action;
import library.controller.Action;
import library.model.UserBean;

import javax.servlet.http.Part;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
public class ActionEditProfileValidate implements Action {

	public String perform(HttpServletRequest request,
            HttpServletResponse response) {
		 ArrayList<String>err=new ArrayList<>();
		 Pattern pattern;
		 Matcher match;
		 String uname = request.getParameter("uname");
		String username=request.getParameter("username");
		String name=request.getParameter("name");
		String contact=request.getParameter("contact");
		String type=request.getParameter("type");
		  if(username.isEmpty() || name.isEmpty() || contact.isEmpty()  || type.isEmpty())
		     {
		    	
				err.add("Please Enter all the required fields");
				 request.setAttribute("errMessage", err); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
	             //request.getSession().setAttribute("user", null);
				return "edit_profile.jsp"; 
		     } 
		  
		  if(contact.length()>10 || contact.length()<10)
		     {
		    	 err.add("Invalid Contact number");
		    	 request.setAttribute("errMessage", err);
		    	 
		    	 return "edit_profile.jsp";
		     }
		     pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		    	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		        match   = pattern.matcher(username);
		        if(match.matches()) {
		          
		        } else {
		        	err.add("Invalid Username!");
		            request.setAttribute("errMessage",err);
		            return "edit_profile.jsp";
		        }
		       
	           
	 
		     long con = Long.parseLong(contact);
		     String pass = "";
		     System.out.println("edit validate");
		     UserBean ub=new UserBean(name,username,pass,con,type,"",0);
		     UserBD.editProfile(ub, uname);
	   return "/Controller?action=manageprofile";
	}
}
