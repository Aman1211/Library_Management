package library.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library.controller.Action;

public class ActionLogin implements Action {

	public String perform(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("user", null);
		return "login.jsp";

	}
}
