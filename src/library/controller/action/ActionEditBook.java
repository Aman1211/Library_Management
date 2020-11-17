/*package library.controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.model.BookBean;


public class ActionEditBook {
	 public String perform(HttpServletRequest request,
	            HttpServletResponse response)
	 {
   

		 
		 System.out.println("aavi gya");
		 
		  String isbn = request.getParameter("isbn");
      	request.setAttribute("book", BookBD.getBook(isbn));       

		 return "edit_book.jsp";
		  
}
}
*/
package library.controller.action;
import library.controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionEditBook implements Action {
	 public String perform(HttpServletRequest request,
	            HttpServletResponse response) {
		
		  String isbn = request.getParameter("isbn");

    
	      	 request.getSession().setAttribute("book", BookBD.getBook(isbn));
			 return "edit_book.jsp";
}
}
