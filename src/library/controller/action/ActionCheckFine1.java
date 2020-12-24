package library.controller.action;

import library.controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.*;
import library.model.*;

public class ActionCheckFine1 implements Action {

	public String perform(HttpServletRequest req, HttpServletResponse res) {
		int tid = Integer.parseInt(req.getParameter("tid"));
		int fine = TransactionBD.checkFine(tid);
		System.out.println(fine);
		if (fine == 0) {

			req.getSession().setAttribute("renew", "nofine");
			String mess = "No Fine on this Transaction";
			req.setAttribute("message", mess);
		} else {
			String mess = "Total amount of Fine:- " + fine;
			req.setAttribute("message", mess);
			req.setAttribute("amt", fine);
			req.getSession().setAttribute("renew", "fine");
		}

		return "return_book.jsp";
	}
}
