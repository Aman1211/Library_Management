package library.controller.action;

import library.controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import library.model.*;

public class ActionReturnUser implements Action {
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<UserBean> ub = UserBD.fetchAll();
		request.getSession().setAttribute("userlist", ub);
		return "user1.jsp";

	}
}
