package library.controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.controller.Action;
import library.model.BookBean;

public class ActionGenerateReport implements Action {

	public String perform(HttpServletRequest request, HttpServletResponse response) {

		return "generate_report.jsp";

	}
}
