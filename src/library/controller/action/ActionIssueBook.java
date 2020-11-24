package library.controller.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import library.controller.Action;
import library.model.*;

public class ActionIssueBook implements Action {
	 public String perform(HttpServletRequest request,
	            HttpServletResponse response) {
		 
	     ArrayList<BookBean>bb=new ArrayList<>();
	     ArrayList<UserBean>ub=new ArrayList<>();
	     bb=BookBD.fetchAll();
	     ub=UserBD.fetchAll();
	    request.getSession().setAttribute("booklist", bb);
	    request.getSession().setAttribute("userlist", ub);
		 return "Issue_book.jsp";
		 
	 }
}
