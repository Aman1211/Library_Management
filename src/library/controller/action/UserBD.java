package library.controller.action;
import library.service.*;
<<<<<<< HEAD
import library.model.RequestBean;
import library.model.UserBean;

import java.util.ArrayList;
=======

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import library.model.BookBean;
import library.model.UserBean;
>>>>>>> 883800dc5be2de6867440a014564755a118f6ed4

public class UserBD {
  
	static UserBean Verify(UserBean ub)  {
		UserTO ut=Bean2TO(ub);
	
	    return  TO2Bean( service.Verify(ut));     
	
	}
	
	static UserBean getUser(String uname)
	{
		return TO2Bean(service.getUser(uname));
	}
	
	static boolean addUser(UserBean ub) {
		UserTO ut=Bean2TO(ub);
		return service.addUser(ut); 
	}
	static boolean updateUser(UserBean ub,String current_password) {
		UserTO ut=Bean2TO(ub);
		return service.updateUser(ut,current_password);
	}
	
	private static ArrayList<UserBean> Cast2Bean(ArrayList<UserTO> userst) {
		ArrayList<UserBean> users = new ArrayList<>();
		for(UserTO ukt : userst) {
			users.add( TO2Bean(ukt) );
		}
		return users;
	}
		
	static UserBean getUser(String username) {
		return TO2Bean(service.getUser(username)); 
			
		}
	
	static void editProfile(UserBean ub, String uname)
	{
		UserTO ut=Bean2TO(ub);
		service.editProfile(ut, uname);
	}
	
	static boolean forgot(UserBean ub)
	{
		UserTO ut=Bean2TO(ub);
		return service.forgot(ut);
	}
	
	static ArrayList<UserBean>fetchAll()
	{
		ArrayList<UserBean> ub=new ArrayList<>();
		
		return Cast2Bean(service.fetchAll());
		
	}
	
	private static ArrayList<UserBean> Cast2Bean(ArrayList<UserTO> userst) {
		ArrayList<UserBean> users = new ArrayList<>();
		for(UserTO ut : userst) {
			users.add( TO2Bean(ut) );
		}
		return users;
	}
		private static UserBean TO2Bean(UserTO bkt) {
			UserBean user = new UserBean(bkt.getName(), bkt.getUsername(), 
					bkt.getPassword(), bkt.getContact(),bkt.getType(),bkt.getRole(),bkt.getCnt());
			return user;
		}

		private static UserTO Bean2TO(UserBean bk) {
			UserTO user = new UserTO(bk.getName(),bk.getUsername(),bk.getPassword(),bk.getContact(),bk.getType(),bk.getRole(),bk.getCnt());
			return user;
		}
		
		static ArrayList<UserBean> fetchAll()
		{
			return Cast2Bean(service.fetchAll());
		}
		
		private static UserService service = UserService.getInstance();	
	}


