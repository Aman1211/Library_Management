package library.controller.action;

import library.controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.model.*;
import java.util.*;

public class ActionReturnBook implements Action {
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<String> err = new ArrayList<>();
		request.getSession().setAttribute("rmember", request.getParameter("username"));
		if (request.getParameter("username").equalsIgnoreCase("null")) {
			err.add("Please select the member!");
			request.setAttribute("errMessage", err);

			return "user1.jsp";

		}
		request.getSession().setAttribute("renew", null);
		String uname = request.getParameter("username");
		ArrayList<TransactionBean> tb = TransactionBD.getTransactions(uname);
		Map<Integer, BookBean> mp = new HashMap<>();
		for (TransactionBean t : tb) {

			BookBean b = BookBD.getBook(t.getISBN());
			mp.put(t.getTransactionId(), b);
		}
		request.getSession().setAttribute("map", mp);
		return "return_book.jsp";

	}

}
