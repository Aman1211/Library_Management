package library.controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.controller.Action;
import library.model.BookBean;
import library.model.ReserveBean;


public class ActionBookReservation implements Action {
	 public String perform(HttpServletRequest request,
	            HttpServletResponse response)
	 {
		 ArrayList<ReserveBean>bb=new ArrayList<>();
		 String username=(String)request.getSession().getAttribute("user");
		 bb=ReserveBD.getReservations(username);
	
		 ArrayList<BookBean> aa=new ArrayList<BookBean>();
			for (ReserveBean b : bb) {
				aa.add(BookBD.getBook(b.getISBN()));
			}
		 request.getSession().setAttribute("Itemlist", aa);		 
		
		
		 return "book_reservation.jsp";
		  
} 
}
