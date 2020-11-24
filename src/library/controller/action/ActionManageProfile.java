package library.controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.controller.Action;
import library.model.UserBean;

public class ActionManageProfile implements Action {

	 public String perform(HttpServletRequest request,
	            HttpServletResponse response)
	 {
		 ArrayList<UserBean> ub =new ArrayList<>();
		 ub=UserBD.fetchAll();
		 request.getSession().setAttribute("userlist", ub);	
		 return "manage_profile.jsp";
		  
     } 
}
 
