package library.controller.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library.model.RequestBean;
import java.util.ArrayList;
import library.controller.Action;

public class ActionRequestList implements Action {

	 public String perform(HttpServletRequest request,
	            HttpServletResponse response)
	 {
		 ArrayList<RequestBean>rba=new ArrayList<>();
		 String user=(String)request.getSession().getAttribute("user");
		 rba=RequestBD.getRequests(user);
		 request.getSession().setAttribute("rlist", rba);
		 return "requestlist.jsp";
		  
} 
}

