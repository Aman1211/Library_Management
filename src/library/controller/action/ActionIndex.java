package library.controller.action;

import java.io.IOException;
import library.controller.Action;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import library.model.BookBean;

class ActionIndex implements Action {
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<BookBean> bb = new ArrayList<>();
		bb = BookBD.fetchAll();
		request.getSession().setAttribute("Itemlist", bb);
		return "index.jsp";

	}
}
/**
 * implementation class ActionController
 */
