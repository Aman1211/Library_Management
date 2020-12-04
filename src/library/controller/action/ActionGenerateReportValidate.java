package library.controller.action;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import library.controller.Action;
import library.model.BookBean;
import library.model.ReserveBean;
import library.model.TransactionBean;
import library.model.UserBean;


public class ActionGenerateReportValidate implements Action{
	
	public String perform(HttpServletRequest request,HttpServletResponse response)
	{
		 ArrayList<String>err=new ArrayList<>();
		 Pattern pattern;
		 Matcher match;
		String view="add_book.jsp";
	    String report=request.getParameter("report");
	    String date=request.getParameter("date");

	    Part bookimg = null;
	    try {
	    		bookimg=request.getPart("bookimg");
	    }
	    catch(Exception e)
	    {}
	    
	     if(report.isEmpty() || date.isEmpty())
	     {
			err.add("Please Enter all the required fields");
			 request.setAttribute("errMessage", err); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
			return "generate_report.jsp"; 
	     } 
	     else if(report.equals("1"))
           {
        	   
        	   ArrayList<BookBean>bb=new ArrayList<>();
      		 bb=BookBD.top3mostissuedbook(date);
   		 request.getSession().setAttribute("Itemlist", bb);		 
      		request.getSession().setAttribute("date123", date);
      		return "top3issuedbook.jsp";
           }
           else if(report.equals("2"))
           {
        	   ArrayList<TransactionBean>bb=new ArrayList<>();
        		 bb=TransactionBD.totalAmoountOfFine(date);
   
        		 ArrayList<UserBean> aa=new ArrayList<UserBean>();
        		 double sum=0;
        		 for(TransactionBean b:bb){  
        			sum=sum+b.getFine();
     			    aa.add(UserBD.getUser(b.getUsername()));
     			}

        		
        		 request.getSession().setAttribute("sum", sum);	
        		 request.getSession().setAttribute("Itemlist", aa);		 
        		request.getSession().setAttribute("date123", date);
        		
        		return "totalAmoountOfFine.jsp";

           }
           else if(report.equals("3"))
           {
        	   ArrayList<TransactionBean>bb=new ArrayList<>();
        		 bb=TransactionBD.top3user(date);
   
        		 ArrayList<UserBean> aa=new ArrayList<UserBean>();
        		
        		 for(TransactionBean b:bb){  
        		UserBean a1=new UserBean();
        		a1=UserBD.getUser(b.getUsername());
    			  a1.setContact((long)b.getFine());
        			 aa.add(a1);
   
     			}

        		

        		 request.getSession().setAttribute("Itemlist", aa);		 
        		request.getSession().setAttribute("date123", date);
        		
        		return "top3user.jsp";
 
           }

	    return "null";
}
}
