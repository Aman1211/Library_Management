package library.controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.controller.Action;
import library.model.BookBean;

public class ActionManageBook implements Action {

	public String perform(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<BookBean> bb = new ArrayList<>();
		bb = BookBD.fetchAll();

		request.getSession().setAttribute("Itemlist", bb);

		return "manage_book.jsp";

	}
}
