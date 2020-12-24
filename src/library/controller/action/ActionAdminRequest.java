package library.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library.model.RequestBean;
import java.util.ArrayList;
import library.controller.Action;

public class ActionAdminRequest implements Action {

	public String perform(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<RequestBean> rba = new ArrayList<>();
		rba = RequestBD.getRequests();
		request.getSession().setAttribute("rlist", rba);
		return "admin_request.jsp";

	}
}
