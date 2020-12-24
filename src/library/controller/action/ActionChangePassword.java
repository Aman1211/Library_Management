package library.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library.controller.Action;

public class ActionChangePassword implements Action {
	public String perform(HttpServletRequest request, HttpServletResponse response) {

		return "change_password.jsp";

	}
}
