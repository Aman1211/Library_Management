package library.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library.model.*;
import java.util.*;
import library.controller.Action;

public class ActionMyTran implements Action {
	public String perform(HttpServletRequest request, HttpServletResponse response) {

		ArrayList<TransactionBean> tb = new ArrayList<>();
		String user = (String) request.getSession().getAttribute("user");
		tb = TransactionBD.getAllTransactions(user);
		Map<TransactionBean, BookBean> mp = new HashMap<>();
		for (TransactionBean t : tb) {

			BookBean b = BookBD.getBook(t.getISBN());
			mp.put(t, b);
		}
		request.getSession().setAttribute("tlist", mp);
		return "mytran.jsp";
	}
}
