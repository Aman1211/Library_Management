package library.controller.action;
import library.controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ActionRemoveProfile implements Action {
public String perform(HttpServletRequest req,HttpServletResponse res)
{
	String username=req.getParameter("username");
	UserBD.remove(username);
	return "/Controller?action=manageprofile";
}
}
