package library.controller.action;
import library.controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.*;
import library.model.*;
public class ActionIssueBookValidate implements Action {
	public String perform(HttpServletRequest request,HttpServletResponse response)
	{
		ArrayList<String>err=new ArrayList<>();
		ArrayList<StringBuilder>mess=new ArrayList<>();
		String username=request.getParameter("username");
		String book[]=request.getParameterValues("book");
		
		
	  UserBean ub=UserBD.getUser(username);
	  if(username.equalsIgnoreCase("null") || book==null || book[0]=="null")
	  {
		  err.add("Please select the required fields");
		  request.setAttribute("errMessage",err);
			return "Issue_book.jsp";
	  }
	  if(ub.getType().equalsIgnoreCase("Student")&& ub.getCnt()+book.length>5 )
	  {
		err.add("Member's IssueCount is " + ub.getCnt() + " books,required  numbers of books will exceed the limit");
		request.setAttribute("errMessage",err);
		return "Issue_book.jsp";
	  }
	  if(ub.getType().equalsIgnoreCase("Faculty") && ub.getCnt()+book.length>10)
	  {
		  err.add("Member's IssueCount is " + ub.getCnt() + " books,required  numbers of books will exceed the limit");
		  request.setAttribute("errMessage",err);
		  return "Issue_book.jsp";
	  }
	  Map<String,Boolean>mp=new HashMap<>();
	  StringBuilder sb=new StringBuilder();
	   StringBuilder sb1=new StringBuilder();
	   sb.append("<b>List of Books Issued and Not Issued</b>").append("<br>");
	  for(String s:book)
	  {
	  boolean result=TransactionBD.verify(username,s);
	  mp.put(s,result);
	  
	   
	}
	  int issuecnt=0,rescnt=0;
	  Set set=mp.entrySet();
	    Iterator itr=set.iterator();  
	    while(itr.hasNext()){  
	        Map.Entry entry=(Map.Entry)itr.next(); 
	        if(entry.getValue().equals(true))
	        {
	        	TransactionBean tb=new TransactionBean(username,entry.getKey().toString());
	        	BookBean bb=BookBD.getBook(entry.getKey().toString());
	             sb.append(bb.getTitle() + " Issued Successfully").append("<br>");
	            TransactionBD.issue(tb);
	            issuecnt++;
	        }
	        else
	        {
	        	BookBean bb=BookBD.getBook(entry.getKey().toString());
	             sb.append(bb.getTitle() + " not issued due to reservation").append("<br>");
	        	rescnt++;
	        	
	        }
	      
	    }
	    if(issuecnt>0)
	    TransactionBD.Notify(username,set);
	    err.clear();
	    mess.add(sb);
	    request.setAttribute("errMessage1", mess);
	    return "Issue_book.jsp";
	
}
}
