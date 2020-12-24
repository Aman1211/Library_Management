package library.controller.action;

import library.controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import library.model.BookBean;
import java.util.ArrayList;
import library.model.*;

public class ActionSearchBookValidate implements Action {
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		String view = "index.jsp";

		String key = request.getParameter("search");
		ArrayList<BookBean> bb = new ArrayList<>();
		bb = BookBD.Search(key);
		request.getSession().setAttribute("Itemlist", bb);
		return view;
	}
}
