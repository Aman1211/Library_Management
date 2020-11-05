package library.controller.action;
import library.controller.Action;
import library.model.BookBean;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ActionViewIndex implements Action {

	public String perform(HttpServletRequest request,HttpServletResponse response)
	{
		 ArrayList<BookBean>bb=new ArrayList<>();
		 bb=BookBD.fetchAll();
		 request.getSession().setAttribute("Itemlist", bb);		 
		 return "index.jsp";
		  
		
	}
}
