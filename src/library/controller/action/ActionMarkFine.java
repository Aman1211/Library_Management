package library.controller.action;

import library.controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionMarkFine implements Action {

	public String perform(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("tid"));
		int amt = Integer.parseInt(request.getParameter("amt"));
		TransactionBD.markFine(id, amt);
		request.getSession().setAttribute("renew", "nofine");
		String mess = "Fine Marked Successfully!";
		request.setAttribute("message", mess);
		return "renew_book.jsp";
	}
}
