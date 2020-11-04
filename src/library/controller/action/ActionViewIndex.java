package library.controller.action;
import library.controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ActionViewIndex implements Action {

	public String perform(HttpServletRequest request,HttpServletResponse response)
	{
		return "index.jsp";
	}
}
