package library.controller.action;
import library.controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ActionLogout implements Action {
	public String perform(HttpServletRequest request,HttpServletResponse response)
	{
		request.getSession().setAttribute("user",null);
		 return "/Controller?action=viewindex";
	}
}
