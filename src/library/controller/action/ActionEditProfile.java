
package library.controller.action;

import library.controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionEditProfile implements Action {
	public String perform(HttpServletRequest request, HttpServletResponse response) {

		String username = request.getParameter("username");
		System.out.println("hiii in Actioneditprofile");

		request.getSession().setAttribute("user", UserBD.getUser(username));
		return "edit_profile.jsp";
	}
}
