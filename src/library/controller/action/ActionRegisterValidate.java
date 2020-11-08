package library.controller.action;
import library.controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import library.model.*;
public class ActionRegisterValidate implements Action{
 
	public String perform(HttpServletRequest request,HttpServletResponse response)
	{
		 ArrayList<String>err=new ArrayList<>();
		 Pattern pattern;
		 Matcher match;
		String view="";
	    String username=request.getParameter("username");
	    String password=request.getParameter("password");
	    String name=request.getParameter("name");
	    String con=request.getParameter("contact");
	    String type=request.getParameter("type");
	     System.out.print(username+password+name+con+type);
	     if(username.isEmpty() || password.isEmpty() || name.isEmpty() || con.isEmpty()  || type.isEmpty() )
	     {

			err.add("Please Enter all the required fields");
			 request.setAttribute("errMessage", err); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
             request.getSession().setAttribute("user", null);
			 return "register.jsp";
	    	   
	     } 
	     long contact=Long.parseLong(request.getParameter("contact"));
	     if(password.length()<8 || password.length()>20)
	     {
	    	err.add("Password length must be between 8 and 20");
	    	 request.setAttribute("errMessage", err);
	    	 request.getSession().setAttribute("user", null);
	    	 view="register.jsp";
	     }
	     if(con.length()>10 || con.length()<10)
	     {
	    	 err.add("Invalid Contact number");
	    	 request.setAttribute("errMessage", err);
	    	 request.getSession().setAttribute("user", null);
	    	 view="register.jsp";
	     }
	     pattern = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
	        match   = pattern.matcher(username);
	        if(match.matches()) {
	          
	        } else {
	        	err.add("Invalid Username!");
	            request.setAttribute("errMessage",err);
	            view="register.jsp";
	        }
	        String regex = "^(?=.*[0-9])"
                    + "(?=.*[a-z])(?=.*[A-Z])"
                    + "(?=.*[@#$%^&+=])"
                    + "(?=\\S+$).{8,20}$"; 
          Pattern p = Pattern.compile(regex);
          Matcher m = p.matcher(password);
           if(m.matches()==false)
           {
           	 err.add("Password length must be 8 of characters and must  contain UpperCase,LowerCase,digit and Special Character !");
   			 request.setAttribute("errMessage", err); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
               
   			 return "register.jsp";
           }
	     UserBean ub=new UserBean(name,username,password,contact,type,"Member");
	     boolean res=UserBD.addUser(ub);
	     System.out.print(res + "aman");
	     if(res==false)
	     {
	    	err.clear();
	    	err.add("User Already Exists!");
	    	request.setAttribute("errMessage",err);
	    	view="register.jsp";
	     }
	     else
	     {
	    	  err.clear();
	    	  err.add("Registration Successful");
	    	  request.setAttribute("errMessage", err);
	    	   view="register.jsp";
	     } 
	     
	     return view;
	    
	    
	}
}
