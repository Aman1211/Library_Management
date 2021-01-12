package library.controller.action;

import library.controller.Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library.model.*;

public class ActionMarkReturn implements Action {
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("tid"));

		TransactionBean tb = TransactionBD.getTransaction(id);
		
		BookBean bb = BookBD.getBook(tb.getISBN());
		int cnt = bb.getQty();
		cnt = cnt + 1;
		bb.setQty(cnt);
		BookBD.editBook(bb);
		UserBD.decrement(tb.getUsername());
		String mess = "Book Returned Successfully!";
		request.setAttribute("message", mess);
		ReserveBD.notify(bb.getISBN());
		TransactionBD.notifyreturn(bb.getISBN(), tb.getUsername());
		String uname = (String) request.getSession().getAttribute("rmember");
		ArrayList<TransactionBean> tb1 = TransactionBD.getTransactions(uname);
		Map<Integer, BookBean> mp = new HashMap<>();
		for (TransactionBean t : tb1) {

			BookBean b = BookBD.getBook(t.getISBN());
			mp.put(t.getTransactionId(), b);
		}
		request.getSession().setAttribute("map", mp);

		request.getSession().setAttribute("renew", null);
		return "return_book.jsp";
	}

}
