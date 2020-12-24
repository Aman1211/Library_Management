package library.controller.action;

import library.controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library.model.*;

public class ActionForgotValidate implements Action {

	public String perform(HttpServletRequest req, HttpServletResponse res) {
		String view = "";
		String username = req.getParameter("username");
		if (username.isEmpty()) {
			String Message = "Please fill the required fields";
			req.setAttribute("errMessage", Message);
			return "forgot.jsp";
		} else {
			UserBean ub = new UserBean();
			ub.setUsername(username);
			boolean ans = UserBD.forgot(ub);
			if (ans == false) {
				String Message = "User Not Found!";
				req.setAttribute("errMessage", Message);
				view = "forgot.jsp";
			} else {
				String Message = "Password has been sent on your registered email.";
				req.setAttribute("errMessage", Message);
				view = "forgot.jsp";
			}
		}
		return view;
	}
}
