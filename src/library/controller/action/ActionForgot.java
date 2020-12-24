package library.controller.action;

import library.controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionForgot implements Action {
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		return "forgot.jsp";

	}
}
