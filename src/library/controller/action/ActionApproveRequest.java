package library.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library.model.RequestBean;
import java.util.ArrayList;
import library.controller.Action;

public class ActionApproveRequest implements Action {

	public String perform(HttpServletRequest req, HttpServletResponse res) {
		int id = Integer.parseInt(req.getParameter("id"));

		RequestBD.approveRequest(id);
		return "/Controller?action=adminrequest";
	}
}
