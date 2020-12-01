package library.controller.action;
import library.controller.Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library.model.*;
public class ActionMarkRenew implements Action{
	public String perform(HttpServletRequest request,HttpServletResponse response)
	{
		
		int id=Integer.parseInt(request.getParameter("tid"));
		
	    TransactionBean tb=TransactionBD.getTransaction(id);
	    boolean result=ReserveBD.getReservation(tb.getISBN());
	    System.out.println(result);
	    if(result==true)
	    {
	    	System.out.println(tb.getISBN());
	         TransactionBean tb1=new TransactionBean(tb.getUsername(),tb.getISBN());
	    	TransactionBD.renew(tb1);
	    	String mess="Book renewed successfully";
	    	request.setAttribute("message",mess);
	    }
	    else
	    {
	    	BookBean bb=BookBD.getBook(tb.getISBN());
	    	int cnt=bb.getQty();
	    	System.out.println(cnt + " cntshow");
	    	cnt=cnt+1;
	    	bb.setQty(cnt);
	    	BookBD.editBook(bb);
	    	UserBD.decrement(tb.getUsername());
	    	String mess="Book Already Reserved by some other member";
	    	request.setAttribute("message",mess);
	    	
	   
	    }
	    String uname=(String)request.getSession().getAttribute("rmember");
		ArrayList<TransactionBean>tb1=TransactionBD.getTransactions(uname);
		Map<Integer,BookBean>mp=new HashMap<>();
	     for(TransactionBean t:tb1)
	     {
	    	
	    	 BookBean b=BookBD.getBook(t.getISBN());
	    	 mp.put(t.getTransactionId(), b);
	     }
		request.getSession().setAttribute("map", mp);
	
	    request.getSession().setAttribute("renew",null);
	    return "renew_book.jsp";
	}
}
