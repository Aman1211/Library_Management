package library.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.controller.Action;

public class ActionSearchBook implements Action {
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		return "index.jsp";

	}
}